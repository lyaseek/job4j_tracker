package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) throws InterruptedException {
        boolean run = true;
        Item item;
        Item[] itemPosition, itemList;
        String id, name;
        int select;
        while (run) {
            itemPosition = tracker.findAll();
            this.showMenu();
            System.out.print("Select: ");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case (0): {
                    System.out.println("=== Create a new Item ====");
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
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
                    System.out.print("Enter id: ");
                    id = scanner.nextLine();
                    System.out.print("Enter a new name: ");
                    Item newItem = new Item(scanner.nextLine());
                    if (tracker.replace(id, newItem)) {
                        System.out.println("Item id " + id + " is edited successfully.");
                    } else {
                        System.out.println("Item id " + id + " doesn't exist.");
                    }
                    break;
                }
                case (3): {
                    System.out.println("=== Deleting the Item ====");
                    System.out.print("Enter id: ");
                    id = scanner.nextLine();
                    if (tracker.delete(id)) {
                        System.out.println("Item id " + id + " is deleted successfully.");
                    } else {
                        System.out.println("Item id " + id + " doesn't exist.");
                    }
                    break;
                }
                case (4): {
                    System.out.println("=== Finding the Item ====");
                    System.out.print("Enter id: ");
                    id = scanner.nextLine();
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
                    System.out.print("Enter name: ");
                    itemList = tracker.findByName(scanner.nextLine());
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
