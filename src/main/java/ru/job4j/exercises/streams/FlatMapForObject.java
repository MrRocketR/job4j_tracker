package ru.job4j.exercises.streams;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapForObject {
    public static List<Integer> flatMap(List<List<Integer>> lists) {
        return lists.stream().flatMap(subStream -> subStream.stream())
                .collect(Collectors.toList());
    }
}
