package ru.job4j.codition;

public class Max {

    public int max(int a, int b) {
        int res = a > b ? a : b;

        return res;
    }

    public int max(int a, int b, int c) {
        return max(a, max(b, c));
    }

    public int max(int a, int b, int c, int d) {
        return max(max(a, b), max(c, d));
    }

}
