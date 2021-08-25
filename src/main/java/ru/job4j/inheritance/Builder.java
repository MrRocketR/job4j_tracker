package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String material;
    private int materialCount;

    public Builder(String material, int materialCount) {
        this.material = material;
        this.materialCount = materialCount;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void canBuild() {
    }
}
