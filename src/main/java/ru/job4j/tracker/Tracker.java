package ru.job4j.tracker;

import javax.print.DocFlavor;
import java.util.*;

public class Tracker {
    private final List<Item> items = new ArrayList<>();

    public Item add(Item item) {
        if (item.getName() != null) {
            item.setId(generateId());
            this.items.add(item);
        }
        return item;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(Math.abs(rm.nextLong()) + System.currentTimeMillis());
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        int size = 0;
        List<Item> itemsFindByName = new ArrayList<>();
        if (key != null) {
            for (Item x : items) {
                if (x.getName().equalsIgnoreCase(key)) {
                    itemsFindByName.add(x);
                }
            }
        }
        return itemsFindByName;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (Item x : items) {
            if (x.getId().equals(id)) {
                rsl = items.indexOf(x);
                break;
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
        }
        return index != -1;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
        return index != -1;
    }
}
