package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find the Item by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> itemList = tracker.findByName(name);
        if (itemList.size() != 0) {
            for (Item x : itemList) {
                System.out.println(x);
            }
        } else {
            System.out.println("Items don't exist.");
        }
        return true;
    }
}
