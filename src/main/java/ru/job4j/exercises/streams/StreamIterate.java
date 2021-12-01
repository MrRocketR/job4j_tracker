package ru.job4j.exercises.streams;

import java.util.stream.Stream;

public class StreamIterate {
    public static void showArray(Integer[] data) {
        Stream.iterate(0, i -> (i % 2) != 0, i-> i + 1)
                .forEach(i -> System.out.println(data[i]));
    }

    public static void main(String[] args) {
        Stream.iterate(0, i -> i < 5, i -> i + 1);
                //=> сгенерируются 0, 1, 2, 3, 4
        Integer [] test = {1,2,3,4,5};
        showArray(test);

    }
}
