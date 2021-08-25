package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String language;

    public Programmer(int rank, boolean swearing, String language) {
        super(rank, swearing);
        this.language = language;
    }
}
