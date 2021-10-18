package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.collection.Job;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void sortUp()
    {
        List<Item> items = Arrays.asList(
                new Item(2,"Fix Bugs"),
                new Item(1,"Eat bugs"),
                new Item(4, "4 Bugs"),
                new Item(3," Third Bugs")
        );
        List<Item> itemsExpected = Arrays.asList(
                new Item(1,"Eat bugs"),
                new Item(2,"Fix Bugs"),
                new Item(3," Third Bugs"),
                new Item(4, "4 Bugs")
        );
        Collections.sort(items);
        Assert.assertEquals(items, itemsExpected);

    }

    @Test
    public void sortDown()
    {
        List<Item> items = Arrays.asList(
                new Item(2,"Fix Bugs"),
                new Item(1,"Eat bugs"),
                new Item(4, "4 Bugs"),
                new Item(3," Third Bugs")
        );
        List<Item> itemsExpected = Arrays.asList(
                new Item(3," Third Bugs"),
                new Item(4, "4 Bugs"),
                new Item(1,"Eat bugs"),
                new Item(2,"Fix Bugs")

        );
        Collections.sort(items,new SorterComparatorByName());
        Assert.assertEquals(items, itemsExpected);

    }

}