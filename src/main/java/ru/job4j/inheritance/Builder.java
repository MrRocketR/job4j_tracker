package ru.job4j.inheritance;

public class Builder extends Engineer {
    String material;
    int materialCount;

    @Override
    public String getName() {
        return super.getName();
    }

    public void canBuild() {
    }
}
