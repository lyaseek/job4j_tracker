package ru.job4j.tracker;

public class Animal {
    String name;

    public Animal() {
        System.out.println("Animal");
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal");
    }

    public static class Predator extends Animal {
        public Predator() {
        }

        public Predator(String name) {
            super(name);
            System.out.println("Predator");
        }
    }

    public static class Tiger extends Predator {
        public Tiger() {
        }

        public Tiger(String name) {
            super(name);
            System.out.println("Tiger");
        }
    }

    public static void main(String[] args) {
        Animal animal = new Animal("Animal");
        System.out.println();
        Predator predator = new Predator("Predator");
        System.out.println();
        Tiger tiger = new Tiger("Tiger");
    }
}
