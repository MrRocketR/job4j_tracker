package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String material;

    public Builder(String name, String surname, String education,
                   int birthday, int rank,
                   boolean swearing, String material) {
        super(name, surname, education, birthday, rank, swearing);
        this.material = material;

    }

    public void canBuild() {
    }
}
