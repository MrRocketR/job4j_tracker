package ru.job4j.exercises.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DistinctForPrimitive {
    public static List<Integer> collect(int[] data) {
        return  Arrays.stream(data).distinct().boxed().collect(Collectors.toList());
    }
}