package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemTest {

    @Test
    public void sortUpById() {
        List<Item> items = Arrays.asList(
                new Item(2, "Fix Bugs"),
                new Item(1, "Eat bugs"),
                new Item(4, "4 Bugs"),
                new Item(3, " Third Bugs")
        );
        List<Item> itemsExpected = Arrays.asList(
                new Item(1, "Eat bugs"),
                new Item(2, "Fix Bugs"),
                new Item(3, " Third Bugs"),
                new Item(4, "4 Bugs")
        );
        Collections.sort(items);
        Assert.assertEquals(items, itemsExpected);

    }

    @Test
    public void sortReverseById() {
        List<Item> items = Arrays.asList(
                new Item(2, "Fix Bugs"),
                new Item(1, "Eat bugs"),
                new Item(4, "4 Bugs"),
                new Item(3, "Third Bugs")
        );
        List<Item> itemsExpected = Arrays.asList(
                new Item(4, "4 Bugs"),
                new Item(3, "Third Bugs"),
                new Item(2, "Fix Bugs"),
                new Item(1, "Eat bugs")
        );
        Collections.sort(items, Collections.reverseOrder());
        Assert.assertEquals(items, itemsExpected);

    }

    @Test
    public void sortComparatorByNameUp() {
        List<Item> items = Arrays.asList(
                new Item(2, "abcd"),
                new Item(1, "abc"),
                new Item(4, "ab"),
                new Item(3, "a")
        );
        List<Item> itemsExpected = Arrays.asList(
                new Item(3, "a"),
                new Item(4, "ab"),
                new Item(1, "abc"),
                new Item(2, "abcd")

        );
        Collections.sort(items, new SorterByNameUp());
        Assert.assertEquals(itemsExpected, items);

    }

    @Test
    public void sortDownComparatorByName() {
        List<Item> items = Arrays.asList(
                new Item(2, "abcd"),
                new Item(1, "abc"),
                new Item(4, "ab"),
                new Item(3, "a")
        );
        List<Item> itemsExpected = Arrays.asList(
                new Item(2, "abcd"),
                new Item(1, "abc"),
                new Item(4, "ab"),
                new Item(3, "a")
        );
        Collections.sort(items, new SorterByNameDown());
        Assert.assertEquals(itemsExpected, items);
    }
}