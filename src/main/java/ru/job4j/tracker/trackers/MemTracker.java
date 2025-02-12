package ru.job4j.tracker.trackers;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    @Override
    public void init() {

    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item>  findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item temp: items) {
            if (key.equals(temp.getName())) {
                result.add(temp);
            }
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if ((items.get(i).getId() == id)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
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

