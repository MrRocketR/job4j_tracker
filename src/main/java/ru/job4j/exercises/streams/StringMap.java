package ru.job4j.exercises.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StringMap {
    public static List<String> map(List<String> names) {
        return names.stream().map(n -> n + ".java").collect(Collectors.toList());
    }
}
