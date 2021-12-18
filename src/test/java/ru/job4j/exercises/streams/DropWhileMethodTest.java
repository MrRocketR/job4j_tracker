package ru.job4j.exercises.streams;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DropWhileMethodTest {
    @Test
    public void test() {
        assertEquals(
                List.of(1, 2, 3),
                DropWhileMethod.dropWhile(List.of(3, 2, 1, -1, -2))
        );
    }
}