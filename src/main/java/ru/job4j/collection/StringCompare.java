package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        for (int i = 0; i < left.length() && i < right.length(); i++) {
            char l = left.charAt(i);
            char r = right.charAt(i);
            rsl =  Character.compare(l, r) + rsl;
        }
        if (left.length() < right.length()) {
            rsl = left.length() - right.length() + rsl;
        }
        return rsl;
    }
}



