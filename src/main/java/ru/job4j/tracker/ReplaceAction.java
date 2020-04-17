package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit the Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item newItem = new Item(input.askStr("Enter a new name: "));
        if (tracker.replace(id, newItem)) {
            System.out.println("Item id= " + id + " is edited successfully.");
        } else {
            System.out.println("Item id= " + id + " doesn't exist.");
        }
        return true;
    }
}