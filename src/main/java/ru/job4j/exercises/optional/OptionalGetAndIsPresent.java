package ru.job4j.exercises.optional;

import java.util.Optional;

public class OptionalGetAndIsPresent {

    public static int get(int[] data, int el) {
        Optional<Integer> out = indexOf(data, el);
        if (out.isEmpty()) {
            return -1;
        } else {
            return out.get();
        }
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        Optional<Integer> out = null;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                out = Optional.of(i);
                out.get();
                break;
            }
            out = Optional.empty();
        }

        return out;
    }

}
