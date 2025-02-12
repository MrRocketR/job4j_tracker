package ru.job4j.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(s -> s != null)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .takeWhile(s -> s.getScore() > bound)
                .collect(Collectors.toList());
    }
}
