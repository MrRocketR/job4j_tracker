package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.trackers.HbmTracker;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerHbmTest {
    private final HbmTracker tracker = new HbmTracker();
    private SessionFactory sf = tracker.getSf();

    @After
    public void wipeTable() {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.createSQLQuery("DELETE FROM items").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item("test1");
        tracker.add(item);
        Item rsl = tracker.findById(item.getId());
        Assertions.assertEquals(rsl.getName(), item.getName());
    }

    @Test
    public void whenSaveItemAndThenReplaceThenIdMustBeTheSame() {
        Item item1 = tracker.add(new Item("test1"));
        Item item2 = new Item("test2");
        int expectedId = item1.getId();
        tracker.replace(expectedId, item2);
        Assertions.assertEquals(tracker.findById(expectedId).getName(), item2.getName());
    }

    @Test
    public void whenSaveThenDeleteThenNullById() {
        Item item = tracker.add(new Item("test"));
        tracker.delete(item.getId());
        Assertions.assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenSaveListAndFindAllThenGetSameList() {
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        Assertions.assertEquals(tracker.findAll(), List.of(item1, item2, item3));
    }
}
