package ru.job4j.oop;

public class Battery {
    private int load;

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery();
        Battery battery2 = new Battery();
        battery1.load = 100;
        battery2.load = 50;
        battery1.exchange(battery2);
        System.out.println(battery1.load);
        System.out.println(battery2.load);
    }
}
