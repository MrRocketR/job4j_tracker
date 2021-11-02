package ru.job4j.collection.departments;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] s1 = o1.split("/");
        String[] s2 = o2.split("/");
        int rsl = s1[0].compareTo(s2[0]);
        if (rsl == 0) {
            return o1.compareTo(o2);
        }
        return rsl;

    }
}
