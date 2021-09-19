package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void ride() {
        System.out.println("Трогаемся!");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Автобус содержит " + passengers + "пассажиров");
    }

    @Override
    public int fuelUp(int gasoline) {
        int out = gasoline * 82;
        return out;
    }

    @Override
    public void move() {
        System.out.println("Bus is moving on the ground");
    }
}
