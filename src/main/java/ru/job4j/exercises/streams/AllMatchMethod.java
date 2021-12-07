package ru.job4j.exercises.streams;

import java.util.List;

public class AllMatchMethod {
    public static boolean check(List<String> list) {
        return list.stream().allMatch(n -> n.length() > 3);
    }
}
