package ru.job4j.inheritance;

public class Dentist extends Doctor {
    public void checkTeeth() {
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void dentalAbuse(Patient p) {
    }
}
