package ru.job4j.exercises.streams;

import java.util.stream.Stream;

public class StreamIterate {
    public static void showArray(Integer[] data) {
        Stream.iterate(1, i -> i < 4, i -> i + 2)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Stream.iterate(0, i -> i < 5, i -> i + 1).forEach(System.out::println);
        System.out.println("___________");
        int[] data = {1, 2, 3, 4};
        Stream.iterate(1, i -> i < data.length, i -> i + 2)
                .forEach(System.out::println);

    }
}
