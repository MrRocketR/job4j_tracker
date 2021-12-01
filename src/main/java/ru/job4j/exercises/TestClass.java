package ru.job4j.exercises;

import java.util.function.Consumer;

public class TestClass implements Consumer {
    @Override
    public void accept(Object o) {
        System.out.println(o);
    }

    @Override
    public Consumer andThen(Consumer after) {
        return Consumer.super.andThen(after);
    }

    public static void main(String[] args) {
        TestClass t = new TestClass();
        t.accept(t);
    }
}
