package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman fresh = new Freshman();
        Student st = fresh; //up
        Object obj = fresh; //up
        Object obj1 = new Object();
        Freshman freshFromObject = (Freshman) obj1; //down
    }
}
