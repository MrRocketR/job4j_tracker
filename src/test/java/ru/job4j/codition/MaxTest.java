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

    @Test
    public void whenTwoMax() {
        Max test = new Max();
        int expected = 2;
        int result = test.max(1, 2);
        Assert.assertEquals(2, result);
    }

    @Test
    public void whenThreeMax() {
        Max test = new Max();
        int expected = 10;
        int result = test.max(1, 10, 7);
        Assert.assertEquals(10, result);
    }

    @Test
    public void whenAllEquals() {
        Max test = new Max();
        int expected = 2;
        int result = test.max(2, 2,2,2);
        Assert.assertEquals(2, result);
    }
}