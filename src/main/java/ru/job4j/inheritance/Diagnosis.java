package ru.job4j.inheritance;

public class Diagnosis {
    private int years;
    private String firtSymptome;
    private String secondSymptome;
    private String patientStatus;
    private boolean isHealed;

    public Diagnosis(int years, String firtSymptome, String secondSymptome, String patientStatus, boolean isHealed) {
        this.years = years;
        this.firtSymptome = firtSymptome;
        this.secondSymptome = secondSymptome;
        this.patientStatus = patientStatus;
        this.isHealed = isHealed;
    }
}
