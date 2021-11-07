package ru.job4j.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> out = new ArrayList<>();
        return students.stream().filter(predict).collect(Collectors.toList());
    }
}