package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete the Item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Item id= " + id + " is deleted successfully.");
        } else {
            System.out.println("Item id= " + id + " doesn't exist.");
        }
        return true;
    }
}

