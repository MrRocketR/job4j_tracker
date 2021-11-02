package ru.job4j.lambda.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCount {

    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (int i = start; i < end; i++) {
            double y = func.apply((double) i);
            rsl.add(y);
        }
        return rsl;
    }

}


