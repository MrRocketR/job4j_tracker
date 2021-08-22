package ru.job4j.codition;

public class Max {

    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public int max(int a, int b, int c) {
        return max(a, max(b, c));
    }

    public int max(int a, int b, int c, int d) {
        return max(max(a, b), max(c, d));
    }

}
