package ru.job4j.exercises.streams;

import java.util.List;
import java.util.stream.Collectors;

public class FilterString {
    public static List<String> filter(List<String> data) {
        return data.stream()
                .filter(n -> n.startsWith("A"))
                .filter(t -> t.endsWith(".java"))
                .collect(Collectors.toList());
    }
}
