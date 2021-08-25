package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String specialisation;

    public Surgeon(String patient, int experience, String specialisation) {
        super(patient, experience);
        this.specialisation = specialisation;
    }

    public void amputation(Patient patient) {
    }

}
