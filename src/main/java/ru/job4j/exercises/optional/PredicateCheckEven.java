package ru.job4j.exercises.optional;

import java.util.function.Predicate;

public class PredicateCheckEven {

    public static boolean check(int num) {
        return check(n -> n % 2 == 0, num);
    }

    private static boolean check(Predicate<Integer> predicate, int num) {
        return predicate.test(num);
    }
}
