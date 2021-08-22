package ru.job4j.codition;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenMaxNine() {
        Max test = new Max();
        int exp = 9;
        int out =  test.max(4, 2, 9, 7);
        Assert.assertEquals(exp, out);
    }
}