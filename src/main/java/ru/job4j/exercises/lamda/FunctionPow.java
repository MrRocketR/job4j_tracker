package ru.job4j.exercises.lamda;

import java.util.function.Function;

public class FunctionPow {

    public static double calculate(double x) {
        return calculate(a -> Math.pow(a, 2), x);
    }

    public static double calculate(Function<Double, Double> y, double x) {
        return y.apply(x);
    }

    public static void main(String[] args) {
        System.out.println(calculate(2));
    }

}
