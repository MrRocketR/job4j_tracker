package ru.job4j.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SimpleTest {
    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("1,2,0", "4,5");
        // получить все числовые значения, которые хранятся через запятую в collection
        String[] number = collection.stream().
                flatMap((p) -> Arrays.asList(p.split(",")).
                        stream()).toArray(String[]::new);
        System.out.println("number = " + Arrays.toString(number));

    }
}
