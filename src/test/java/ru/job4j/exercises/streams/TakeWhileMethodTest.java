package ru.job4j.exercises.streams;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TakeWhileMethodTest {
    @Test
    public void test() {
        assertEquals(
                List.of(-2, -1),
                TakeWhileMethod.takeWhile(List.of(3, 2, 1, 0, -2, -1))
        );
    }
}