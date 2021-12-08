package ru.job4j.exercises.streams;


import java.util.List;
import java.util.stream.Collectors;

public class MapToIntMethod {
    public static long sum(List<Character> characters) {
       long out;
       out = characters.stream().mapToInt(n -> (int) n).sum();
       return out;
    }
}
