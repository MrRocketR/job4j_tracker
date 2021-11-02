package ru.job4j.lambda.function;

import java.util.Comparator;

public class LambdaUsage {

    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left.length() +  right.length());
            return Integer.compare(left.length(), right.length());

        };
    }
}
