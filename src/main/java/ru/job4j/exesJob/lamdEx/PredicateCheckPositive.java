package ru.job4j.exesJob.lamdEx;

import java.util.function.Predicate;

public class PredicateCheckPositive {

    public static boolean check(int num) {
        return check(n -> n > 0, num);
    }

    private static boolean check(Predicate<Integer> predicate, int num) {
        return predicate.test(num);
    }

    public static void main(String[] args) {
        System.out.println(check(2));
    }
}
