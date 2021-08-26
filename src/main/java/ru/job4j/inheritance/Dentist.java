package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int price;

    public Dentist(String name, String surname, String education, int birthday, String patient, int experience, int price) {
        super(name, surname, education, birthday, patient, experience);
        this.price = price;
    }

    public void dentalAbuse(Patient p) {
    }
}
