package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String patient;
    private int experience;

    public Doctor(String patient, int experience) {
        this.patient = patient;
        this.experience = experience;
    }

    public Doctor() {
    }

    public void toHeal(Diagnosis diagnosis) {
    }

}
