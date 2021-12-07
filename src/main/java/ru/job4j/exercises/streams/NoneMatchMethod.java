package ru.job4j.exercises.streams;

import java.util.List;

public class NoneMatchMethod {
    public static boolean check(List<String> list) {
       return list.stream().noneMatch(n -> n.isEmpty());
    }
}
