package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] newArray = new Item[items.length];
        int size = 0;
        for (int index = 0; index < newArray.length; index++) {
            Item temp = items[index];
            if (temp != null) {
                newArray[size] = temp;
                size++;
            }
        }
        newArray = Arrays.copyOf(newArray, size);
        return newArray;
        }

    public Item[] findByName(String key) {
        Item[] newArray = new Item[items.length];
        int size = 0;
        for (int index = 0; index < newArray.length; index++) {
            Item temp = items[index];
            if (temp != null && key.equals(temp.getName())) {
                newArray[size] = temp;
                size++;
            }
        }
        newArray = Arrays.copyOf(newArray, size);
        return newArray;
    }
    }

