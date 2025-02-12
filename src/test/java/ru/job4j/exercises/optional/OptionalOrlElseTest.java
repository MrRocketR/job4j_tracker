package ru.job4j.exercises.optional;

import org.junit.Test;
import ru.job4j.exercises.optional.OptionalOrlElse;

import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalOrlElseTest {

    @Test
    public void test() {
        assertEquals(Integer.valueOf(-1), OptionalOrlElse.orElse(Optional.empty()));
        assertEquals(Integer.valueOf(1), OptionalOrlElse.orElse(Optional.of(1)));
    }

}