package ru.job4j.lambda.function;

import ru.job4j.lambda.Attachment;

import java.util.Comparator;

public class CompFunction {

    Comparator<String> cmpText = String::compareTo;
    Comparator<String> cmpDescSize = (left, right) -> Integer.compare(left.length(), right.length());

}
