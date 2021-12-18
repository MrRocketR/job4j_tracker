package ru.job4j.exercises.streams;

import java.util.List;

public class ReduceMethodOneArgument {
    public static Integer reduce(List<Integer> list) {
        Integer sum = list.stream().reduce((n1, n2) -> n1 * n2).get();
        return sum;
    }
}
