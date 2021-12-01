package ru.job4j.exercises.optional;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalOrlElse {
    public static Integer orElse(Optional<Integer> optional) {
        return  optional.orElse(-1);
    }

}

