package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void when00to20then2() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(2,0);
        double expected = 2;
        double out = p1.distance(p2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when20to20then0() {
        double expected = 0.0;
        Point p1 = new Point(2,0);
        Point p2 = new Point(2,0);
        double out = p1.distance(p2);
        Assert.assertEquals(expected, out, 0.01);
    }
    @Test
    public void when200to200then0() {
        double expected = 0.0;
        Point p1 = new Point(2,0,0);
        Point p2 = new Point(2,0,0);
        double out = p1.distance(p2);
        Assert.assertEquals(expected, out, 0.01);
    }




}