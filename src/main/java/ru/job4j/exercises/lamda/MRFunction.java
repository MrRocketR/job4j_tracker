package ru.job4j.exercises.lamda;

import java.util.function.Function;

public class MRFunction {
    public static Function<Double, Double> apply() {
        Function<Double, Double> f = Math::sqrt;
        return f;
    }
}
