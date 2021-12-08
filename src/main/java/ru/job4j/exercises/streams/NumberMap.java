package ru.job4j.exercises.streams;

import java.util.List;
import java.util.stream.Collectors;

public class NumberMap {
    public static List<Integer> map(List<Integer> numbers) {
        return numbers.stream().map(n ->  (int) Math.pow(n, 2)).collect(Collectors.toList());
    }
}
