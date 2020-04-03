package ru.job4j.tracker;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Random;
import java.util.SortedMap;

public class Tracker {
    private final Item[] items = new Item[10];
    private int position = 0;

    public Item add(Item item) throws TrackerException {
        if (item.getName() != null) {
            item.setId(generateId());
            this.items[position++] = item;
            return item;
        } else {
            System.out.println("Impossible to add Item with null Name");
            throw new TrackerException();
        }
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(Math.abs(rm.nextLong()) + System.currentTimeMillis());
    }

    public Item[] findAll() {
        if (this.position == 0) {
            System.out.println("There are no Items in Tracker");
        }
        return Arrays.copyOf(this.items, position);
    }

    public Item[] findByName(String key) throws TrackerException {
        if (key != null) {
            if (this.position == 0) {
                System.out.println("There are not Items in Tracker");
                return null;
            } else {
                int size = 0;
                Item[] itemsFindByName = new Item[position];
                for (Item x : findAll()) {
                    if (x.getName().equals(key)) {
                        itemsFindByName[size] = x;
                        size++;
                    }
                }
                if (size > 0) {
                    return Arrays.copyOf(itemsFindByName, size);
                } else {
                    System.out.println("There is no Item with Name - " + key + " in Tracker");
                    return null;
                }
            }
        } else {
            System.out.println("Impossible to search Item with null Name");
            throw new TrackerException();
        }
    }

    public Item findById(String id) throws TrackerException {
        if (id != null) {
            if (this.position != 0) {
                for (Item x : findAll()) {
                    if (x.getId().equals(id)) {
                        return x;
                    } else {
                        System.out.println("There is no Item with Id - " + id + " in Tracker");
                        return null;
                    }
                }
            } else {
                System.out.println("There are not Items in Tracker");
                return null;
            }
        } else {
            System.out.println("Impossible to search Item with null ID");
            throw new TrackerException();
        }
        return null;
    }
}
