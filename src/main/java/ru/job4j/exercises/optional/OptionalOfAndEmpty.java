package ru.job4j.exercises.optional;

import java.util.List;
import java.util.Optional;

public class OptionalOfAndEmpty {
    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<String> out;
        if (strings.contains(value)) {
            out = Optional.of(value);
        } else {
            out = Optional.empty();
        }
        return out;
    }
}
