package ru.job4j.exercises.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DistinctForPrimitive {
    public static List<Integer> collect(int[] data) {
        int num = Arrays.stream(data)
                .min()
                .getAsInt(); // returns 7

        return new ArrayList<Integer>();
    }
}