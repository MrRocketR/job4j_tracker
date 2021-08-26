package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surname, String education, int birthday, int rank, boolean swearing,  String language) {
        super(name, surname, education, birthday, rank, swearing);
        this.language = language;
    }
}
