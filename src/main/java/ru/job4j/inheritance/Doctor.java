package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String patient;
    private int experience;

    public void toHeal(Diagnosis diagnosis) {
        diagnosis.isHealed = true;
    }

}
