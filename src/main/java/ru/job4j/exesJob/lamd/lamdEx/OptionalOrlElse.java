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


    }

    public static Integer oR (Optional<Integer> optional)
    {

    }


}

