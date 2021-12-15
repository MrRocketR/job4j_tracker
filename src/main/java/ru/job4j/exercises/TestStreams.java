package ru.job4j.exercises;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStreams {
    public static void main(String[] args) {
        Stream.of(1, 2, 2, 3).reduce(Integer::sum).orElse(0);
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);

        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);

        List.of(1, 2, 3).stream().forEach(n -> System.out.println(n));

        int a1 = 2;
        int a2 = 1;
        int a3 = 4;
        Stream.builder().add(a1).add(a2).add(a3).build();
        System.out.println("reduce");
        Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 5);
        collection.stream().reduce((s1, s2) -> s1 + s2).orElse(0);
        collection.forEach(System.out::println);

    }
}
