package ru.job4j.exercises.optional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalOfNullable {
    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<String> out = Optional.empty();
        Optional<String> v = Optional.ofNullable(value);
        for (String s:strings) {
            Optional<String> nS = Optional.ofNullable(s);
            if (nS.equals(v)) {
                out = nS;
                break;
            }
        }
        return out;
    }
}
