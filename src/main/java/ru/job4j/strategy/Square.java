package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    "   __     " + ln
                + "  |__|" + ln;
    }

    public static void main(String[] args) {

    }
}