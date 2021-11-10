package ru.job4j.streams;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MatrixToListTest {
    @Test
    public void convert() {
        MatrixToList matrixToList = new MatrixToList();
        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> result = matrixToList.convert(matrix);
        assertThat(result, is(expected));
    }

    @Test
    public void convert2() {
        MatrixToList matrixToList = new MatrixToList();
        Integer[][] matrix = {
                {1, 2},
                {3, 4, 5}
        };
        List<Integer> expected = List.of(1, 2, 3, 4, 5);
        List<Integer> result = matrixToList.convert(matrix);
        assertThat(result, is(expected));
    }
}