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
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index > -1) {
            items[index].setName(item.getName());
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index  > -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
            return true;
        } else {
            return false;
        }

    }
}

