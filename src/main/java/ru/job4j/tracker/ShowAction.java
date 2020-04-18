package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item x : tracker.findAll()) {
            System.out.println(x);
        }
        return true;
    }
}
