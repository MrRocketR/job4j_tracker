package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String patient;
    private int experience;

    public Doctor(String name, String surname, String education, int birthday, String patient, int experience) {
        super(name, surname, education, birthday);
        this.patient = patient;
        this.experience = experience;
    }

    public void toHeal(Diagnosis diagnosis) {
    }

}
