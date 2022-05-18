package ru.job4j.tracker;

import org.junit.*;
import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item1"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveItemAndDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item1"));
        Assert.assertTrue(tracker.delete(item.getId()));

    }

    @Test
    public void whenSaveItemAndReplaced() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item1"));
        Item itemR = new Item("item2");
        int id = item.getId();
        Assert.assertTrue(tracker.replace(item.getId(), itemR));
        Assert.assertEquals(tracker.findById(id).getName(), itemR.getName());
    }

    @Test
    public void whenSaveItemAndReplacedAndSameName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item1"));
        Item itemR = new Item("item2");
        int id = item.getId();
        tracker.replace(id, itemR);
        Assert.assertEquals(tracker.findById(id).getName(), itemR.getName());
    }

    @Test
    public void whenAddAndFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        assertThat(tracker.findByName("item"), is(List.of(item1)));
    }

    @Test
    public void whenAddAndFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item"));
        Item item2 = tracker.add(new Item("item2"));
        Assert.assertEquals((tracker.findById(item1.getId())), item1);
    }

    @Test
    public void whenAddAndFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item2"));
        assertThat(tracker.findAll(), is(List.of(item1, item2, item3)));
    }

    @Test
    public void whenAddAndDeleteNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item"));
        tracker.delete(item1.getId());
        Assert.assertNull(tracker.findById(item1.getId()));
    }

}

