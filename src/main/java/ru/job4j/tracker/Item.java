package ru.job4j.tracker;

import java.util.*;

public class Item {
    private String id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Item id = " + String.format("%-5s", this.id) + " name = " + String.format("%-5s", this.name);
        // 20 & 15
    }
}