package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String specialisation;

    public Surgeon(String name, String surname, String education, int birthday, String patient, int experience, String specialisation) {
        super(name, surname, education, birthday, patient, experience);
        this.specialisation = specialisation;

    }

    public void amputation(Patient patient) {
    }

}
