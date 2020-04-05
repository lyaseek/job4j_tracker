package ru.job4j.tracker;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Random;
import java.util.SortedMap;

public class Tracker {
    private final Item[] items = new Item[10];
    private int position = 0;

    public Item add(Item item) {
        if (item.getName() != null) {
            item.setId(generateId());
            this.items[position++] = item;
        }
        return item;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(Math.abs(rm.nextLong()) + System.currentTimeMillis());
    }

    public Item[] findAll() {
        if (this.position != 0) {
            return Arrays.copyOf(this.items, position);
        } else return null;
    }

    public Item[] findByName(String key) {
        if (key != null) {
            if (this.position != 0) {
                int size = 0;
                Item[] itemsFindByName = new Item[position];
                for (Item x : findAll()) {
                    if (x.getName().equals(key)) {
                        itemsFindByName[size] = x;
                        size++;
                    }
                }
                return Arrays.copyOf(itemsFindByName, size);
            }
        }
        return null;
    }

    public Item findById(String id) {
        if (id != null) {
            if (this.position != 0) {
                for (Item x : findAll()) {
                    if (x.getId().equals(id)) {
                        return x;
                    }
                }
            }
        }
        return null;
    }
}
