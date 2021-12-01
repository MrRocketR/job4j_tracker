package ru.job4j.exercises;

import java.util.stream.Stream;

public class TestStreams {
    public static void main(String[] args) {
        Stream.of(1,2,2,3).reduce(Integer::sum).orElse(0);
    }
}
