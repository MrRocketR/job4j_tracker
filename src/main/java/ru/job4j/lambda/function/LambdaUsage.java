package ru.job4j.lambda.function;

import java.util.Comparator;

public class LambdaUsage {

    Comparator<String> cmpDescSize = (left, right) -> {
        System.out.println("compare - " + right.length() +  left.length());
        return right.length() - left.length();

    };
}
