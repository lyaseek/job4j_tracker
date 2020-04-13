package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) throws InterruptedException {
        boolean run = true;
        Item item;
        Item[] itemPosition, itemList;
        String id, name;
        int select;
        while (run) {
            itemPosition = tracker.findAll();
            this.showMenu();
            select = input.askInt("Select: ");
            switch (select) {
                case (0): {
                    System.out.println("=== Create a new Item ====");
                    name = input.askStr("Enter name: ");
                    item = new Item(name);
                    tracker.add(item);
                    break;
                }
                case (1): {
                    System.out.println("=== Items ====");
                    for (Item x : itemPosition) {
                        System.out.println(x.getId() + " " + x.getName());
                    }
                    break;
                }
                case (2): {
                    System.out.println("=== Editing the Item ====");
                    id = input.askStr("Enter id: ");
                    Item newItem = new Item(input.askStr("Enter a new name: "));
                    if (tracker.replace(id, newItem)) {
                        System.out.println("Item id " + id + " is edited successfully.");
                    } else {
                        System.out.println("Item id " + id + " doesn't exist.");
                    }
                    break;
                }
                case (3): {
                    System.out.println("=== Deleting the Item ====");
                    id = input.askStr("Enter id: ");
                    if (tracker.delete(id)) {
                        System.out.println("Item id " + id + " is deleted successfully.");
                    } else {
                        System.out.println("Item id " + id + " doesn't exist.");
                    }
                    break;
                }
                case (4): {
                    System.out.println("=== Finding the Item ====");
                    id = input.askStr("Enter id: ");
                    item = tracker.findById(id);
                    if (item != null) {
                        System.out.println(item.getName());
                    } else {
                        System.out.println("Item id " + id + " doesn't exist.");
                    }
                    break;
                }
                case (5): {
                    System.out.println("=== Finding the Item ====");
                    name = input.askStr("Enter name: ");
                    itemList = tracker.findByName(name);
                    if (itemList.length != 0) {
                        for (Item x : itemList) {
                            System.out.println(x.getId() + " " + x.getName());
                        }
                    } else {
                        System.out.println("Items don't exist.");
                    }
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
