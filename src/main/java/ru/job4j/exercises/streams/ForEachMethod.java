package ru.job4j.exercises.streams;

import java.util.stream.Stream;

public class ForEachMethod {
    public static void show(Stream<Integer> data) {
        data.forEach(n -> System.out.println(n));

    }
}
