package ru.job4j.tracker;

public class Animal {
    public Animal() {
        System.out.println("Animal");
    }

    public static class Predator extends Animal {
        public Predator() {
            super();
            System.out.println("Predator");
        }
    }

    public static class Tiger extends Predator {
        public Tiger() {
            super();
            System.out.println("Tiger");
        }
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println();
        Predator predator = new Predator();
        System.out.println();
        Tiger tiger = new Tiger();
    }
}
