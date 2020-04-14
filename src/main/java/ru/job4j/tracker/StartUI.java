package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItems(Tracker tracker) {
        System.out.println("=== Items ====");
        for (Item x : tracker.findAll()) {
            System.out.println(x.getId() + " " + x.getName());
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Editing the Item ====");
        String id = input.askStr("Enter id: ");
        Item newItem = new Item(input.askStr("Enter a new name: "));
        if (tracker.replace(id, newItem)) {
            System.out.println("Item id " + id + " is edited successfully.");
        } else {
            System.out.println("Item id " + id + " doesn't exist.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Deleting the Item ====");
        String id = input.askStr("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Item id " + id + " is deleted successfully.");
        } else {
            System.out.println("Item id " + id + " doesn't exist.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Finding the Item ====");
        String id = input.askStr("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.getName());
        } else {
            System.out.println("Item id " + id + " doesn't exist.");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Finding the Item ====");
        String name = input.askStr("Enter name: ");
        Item[] itemList = tracker.findByName(name);
        if (itemList.length != 0) {
            for (Item x : itemList) {
                System.out.println(x.getId() + " " + x.getName());
            }
        } else {
            System.out.println("Items don't exist.");
        }
    }

    public void init(Input input, Tracker tracker) throws InterruptedException {
        boolean run = true;
        int select;
        while (run) {
            this.showMenu();
            select = input.askInt("Select: ");
            switch (select) {
                case (0): {
                    StartUI.createItem(input, tracker);
                    break;
                }
                case (1): {
                    StartUI.showItems(tracker);
                    break;
                }
                case (2): {
                    StartUI.replaceItem(input, tracker);
                    break;
                }
                case (3): {
                    StartUI.deleteItem(input, tracker);
                    break;
                }
                case (4): {
                    StartUI.findItemById(input, tracker);
                    break;
                }
                case (5): {
                    findItemByName(input, tracker);
                    break;
                }
                case (6): {
                    run = false;
                    break;
                }
            }
        }
    }

    private void showMenu() throws InterruptedException {
        System.out.println("Menu.");
        Thread.sleep(1000);
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) throws InterruptedException {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
