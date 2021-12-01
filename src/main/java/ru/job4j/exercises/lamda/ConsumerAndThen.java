package ru.job4j.exercises.lamda;

import java.util.function.Consumer;

public class ConsumerAndThen {
    public static Consumer<String> consumer(String input) {
        Consumer<String> print = x -> System.out.print(x);
        Consumer<String> ln = (a) -> System.out.println();
        return print.andThen(ln);
    }

    public static void main(String[] args) {
        System.out.println("job4j");

    }
}
