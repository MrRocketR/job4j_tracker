package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int price;

    public Dentist(int price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void dentalAbuse(Patient p) {
    }
}
