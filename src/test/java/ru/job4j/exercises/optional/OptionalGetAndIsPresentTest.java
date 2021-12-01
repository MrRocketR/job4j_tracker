package ru.job4j.exercises.optional;

import org.junit.Test;
import ru.job4j.exercises.optional.OptionalGetAndIsPresent;

import static org.junit.Assert.*;

public class OptionalGetAndIsPresentTest {

    @Test
    public void whenExist() {
        assertEquals(
                1,
                OptionalGetAndIsPresent.get(
                        new int[] {1, 2, 3},
                        2
                )
        );
    }

    @Test
    public void whenNotExist() {
        assertEquals(
                -1,
                OptionalGetAndIsPresent.get(
                        new int[] {1, 2, 3},
                        4
                )
        );
    }

}