package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int rank;
    private boolean swearing;

    public Engineer(String name, String surname, String education,
                    int birthday, int rank, boolean swearing) {
        super(name, surname, education, birthday);
        this.rank = rank;
        this.swearing = swearing;
    }

}
