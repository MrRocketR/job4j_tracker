package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public double add(double first, double second) {
        return first + second;
    }

    public double add(double first, double second, double third) {
        return first + second + third;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public static int sum(int y) {
        return y + x;
    }

    public int multiply(int y) {
        return y * x;
    }

    public int sumAllOperation(int y) {
        return minus(y) + divide(y) + sum(y) + multiply(y);

    }

    public static void main(String[] args) {
        int m = Calculator.minus(10);
        System.out.println(m);
        Calculator calculator = new Calculator();
        int d = calculator.divide(10);
        System.out.println(d);
        int mult = calculator.multiply(10);
        System.out.println(mult);
        int sum = Calculator.sum(10);
        System.out.println(sum);
        int s = calculator.sumAllOperation(10);
        System.out.println(s);
    }
}
