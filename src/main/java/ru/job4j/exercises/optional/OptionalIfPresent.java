package ru.job4j.exercises.optional;

import java.util.Optional;

public class OptionalIfPresent {

    public static void ifPresent(int[] data) {
        Optional<Integer> p = max(data);
        p.ifPresent(val -> System.out.println("Max: " +  val));
    }

    private static Optional<Integer> max(int[] data) {
        Optional<Integer> out;
        if (data.length != 0) {
            int max = 0;
            for (int datum : data) {
                if (datum > max) {
                    max = datum;
                }
            }
            out = Optional.of(max);

        } else {
            out = Optional.empty();
        }
        return out;
    }

    public static void main(String[] args) {
        int[] data1 = {1, 2, 3};
        ifPresent(data1);
        }
}
