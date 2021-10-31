package ru.job4j.lambda.function;

import java.util.Arrays;
import java.util.Comparator;

public class Lazy {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };

        String[] names2 = {
                "Ivan",
                "Petr"
        };
        Arrays.sort(names, lengthCmp);
        Arrays.sort(names2, lengthCmp);

    }
}
