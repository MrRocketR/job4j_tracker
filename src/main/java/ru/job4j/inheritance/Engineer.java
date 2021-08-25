package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int rank;
    private boolean swearing;

    public Engineer(int rank, boolean swearing) {
        this.rank = rank;
        this.swearing = swearing;
    }

    public Engineer() {
    }
}
