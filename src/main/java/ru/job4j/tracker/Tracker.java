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
        return Arrays.copyOf(items, size);
        }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item temp = items[index];
            if (key.equals(temp.getName())) {
                result[count] = temp;
                count++;
            }
        }
        return Arrays.copyOf(items, count);
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
        boolean output = false;
        int index = indexOf(id);
        if (index > -1) {
            items[index].setName(item.getName());
            items[index].setId(item.getId());
            output = true;
        }
        return output;
    }

    public boolean delete(int id) {
        boolean output = false;
        int index = indexOf(id);
        if (index  > -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
            output = true;
        }
        return output;

    }
}

