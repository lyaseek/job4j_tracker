package ru.job4j.tracker;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Random;
import java.util.SortedMap;

public class Tracker {
    public static Item itemDefault = new Item("Default");
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
        return Arrays.copyOf(this.items, position);
    }

    public Item[] findByName(String key) {
        int size = 0;
        Item[] itemsFindByName = new Item[position];
        if (key != null) {
            for (int i = 0; i < position; i++) {
                if (items[i].getName().equals(key)) {
                    itemsFindByName[size] = items[i];
                    size++;
                }
            }
        }
        return Arrays.copyOf(itemsFindByName, size);
    }

    public Item findById(String id) {
        if (id != null) {
            for (int i = 0; i < position; i++) {
                if (items[i].getId().equals(id)) {
                    return items[i];
                }
            }
        }
        return itemDefault;
    }
}
