package ru.job4j.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPI {
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(5);
        integerArrayList.add(-2);
        integerArrayList.add(-12);
        integerArrayList.add(22);
        integerArrayList.add(-5);
        integerArrayList.add(6);
        integerArrayList.add(-1);
        integerArrayList.stream().filter(value -> value > 0).collect(Collectors.toList());

    }

}
