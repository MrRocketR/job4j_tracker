package ru.job4j.lambda.function;

import ru.job4j.lambda.Attachment;

import java.util.Comparator;

public class CompFunction {

    Comparator<String> cmpText = (left, right) -> left.compareTo(right);
    Comparator<String> cmpDescSize = (left, right) -> left.length() - right.length();

}
