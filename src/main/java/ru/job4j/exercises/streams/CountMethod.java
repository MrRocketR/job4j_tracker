package ru.job4j.exercises.streams;

import java.util.stream.Stream;

public class CountMethod {
    public static long count(Stream<Integer> data) {
        return data.count();
    }
}
