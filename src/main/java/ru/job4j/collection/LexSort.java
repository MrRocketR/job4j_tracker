package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] o1Array = left.split("\\.");
        String[] o2Array = right.split("\\.");
        int o1Lex = Integer.parseInt(o1Array[0]);
        int o2Lex = Integer.parseInt(o2Array[0]);
        return Integer.compare(o1Lex, o2Lex);
    }

}