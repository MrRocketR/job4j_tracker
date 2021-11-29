package ru.job4j.exesJob.lamd.lamdEx;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalOrlElse {
    public static Integer orElse(Optional<Integer> optional) {
        // do refactor
        Integer value = -1;
        if (optional.isPresent()) {
            value = optional.get();
        }
        return value;
    }

    public static void main(String[] args) {
        Integer value = -1;
        Optional<Integer> n = Optional.of(-1);
        Supplier<Integer> s = () -> (Integer) (int) (1 * 2 * Math.random());
        Integer result =  Optional.of(value).orElseGet(s);
        System.out.println(result);
        Integer result2 = (Integer) Optional.empty().orElse(s);

    }
}

