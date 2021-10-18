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

    public static void main(String[] args) {
        String a = "invanov";
        String b = "ivanova";
        char l =  a.charAt(7);
        char r =  a.charAt(7);
        int test = Character.compare(l, r);
        System.out.println(test);

    }
}

/*

String.charAt(int index)

Integer.compare(int left, int right),

Character.compare(char left, char right);


 */