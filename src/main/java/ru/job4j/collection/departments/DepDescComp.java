package ru.job4j.collection.departments;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        String[] s1 = o1.split("/");
        String[] s2 = o2.split("/");
        for (String c1:s1) {
            for (String c2: s2) {
                rsl = c2.compareTo(c1);
            }
        }
        if (rsl == 0) {
            return o1.compareTo(o2);
        }
        return rsl;
    }
}
