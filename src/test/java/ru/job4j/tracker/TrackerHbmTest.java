package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.trackers.HbmTracker;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerHbmTest {

    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(REGISTRY)
            .buildMetadata().buildSessionFactory();
    private final HbmTracker tracker = new HbmTracker();

    @AfterEach
    public void wipeTable() {
        tracker.wipeTable();
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        Item item = new Item("test1");
        tracker.add(item);
        Item rsl = tracker.findById(item.getId());
        tracker.close();
        Assertions.assertEquals(rsl.getName(), item.getName());
    }

    @Test
    public void whenSaveItemAndThenReplaceThenIdMustBeTheSame() throws Exception {
        Item item1 = tracker.add(new Item("test1"));
        Item item2 = new Item("test2");
        int expectedId = item1.getId();
        tracker.replace(expectedId, item2);
        Assertions.assertEquals(tracker.findById(expectedId).getName(), item2.getName());
        tracker.close();
    }

    @Test
    public void whenSaveThenDeleteThenNullById() throws Exception {
        Item item = new Item("deleted");
        tracker.add(item);
        boolean result = tracker.delete(item.getId());
        Assertions.assertTrue(result);
    }

    @Test
    public void whenSaveListAndFindAllThenGetSameList() throws Exception {
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        Assertions.assertEquals(tracker.findAll(), List.of(item1, item2, item3));
        tracker.close();
    }
}
