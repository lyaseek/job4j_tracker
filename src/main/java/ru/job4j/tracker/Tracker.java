package ru.job4j.tracker;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Random;
import java.util.SortedMap;

public class Tracker {
    public static final Item ITEM_DEFAULT = new Item("Default");
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
        int index = indexOf(id);
        return index != -1 ? items[index] : ITEM_DEFAULT;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        if ((index != -1) && (item.getName() != null)) {
            items[index].setName(item.getName());
        }
        return items[index].getName().equals(item.getName());
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        items[index] = null;
        System.arraycopy(items, index + 1, items, index, position - index);
        items[position - 1] = null;
        position--;
        return items[index] != null;
    }
}
