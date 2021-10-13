package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class Tracker {
    private ArrayList<Item> items = new ArrayList<Item>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        if (items.size() == 0)  {
            items.add(new Item(0, "zero"));
        }
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public ArrayList<Item> findAll() {
        ArrayList<Item> newArray = new ArrayList<Item>();
        for (Item temp: items) {
            if (temp != null) {
                newArray.add(temp);
            }
        }
        return newArray;
    }

    public ArrayList<Item>  findByName(String key) {
        ArrayList<Item> result = new ArrayList<Item>();
        for (Item temp: items) {
            if (key.equals(temp.getName())) {
                result.add(temp);
            }
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item temp : items) {
            if (temp.getId() == id) {
                rsl = id;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.get(index).setId(id);
            items.add(id, item);
        }
        return result;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
        return result;
    }
}

