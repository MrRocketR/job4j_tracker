package ru.job4j.lambda.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionCountTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCount.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11.0, 13.0, 15.0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = FunctionCount.diapason(1, 4, x -> 1 * Math.pow(x, 2));
        List<Double> expected = Arrays.asList(1.0, 4.0, 9.0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExpResult() {
        List<Double> result = FunctionCount.diapason(1, 4, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(2.0, 4.0, 8.0);
        assertThat(result, is(expected));
    }

}


