package ru.job4j.lambda.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String For Interface";
        System.out.println(sup.get());
        System.out.println("____________________");
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup2 = () -> new HashSet<>(list);
        Set<String> strings = sup2.get();
        for (String s : strings) {
            System.out.println(s);
        }
        System.out.println("____________________");
        Supplier<String> sup3 = () -> "New String For Interface";
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept(sup3.get());
        System.out.println("____________________");
        Supplier<String> sup4 = () -> "New String For Interface";
        BiConsumer<String, String> consumer2 = (s, s1) -> System.out.println(s + s1);
        consumer2.accept(sup4.get(), " and Second String");
        System.out.println("____________________");
        List<String> list2 = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup5 = () -> new HashSet<>(list);
        BiConsumer<Integer, String> consumer3 = (s, s1) -> System.out.println(s + s1);
        Set<String> strings2 = sup5.get();
        int i = 1;
        for (String s : strings2) {
            consumer3.accept(i++, " is " + s);
        }
        System.out.println("____________________");
        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("Строка пустая: " + pred.test(""));
        System.out.println("Строка пустая: " + pred.test("test"));
        System.out.println("____________________");
        BiPredicate<String, Integer> cond = (s, k) -> s.contains(k.toString());
        System.out.println("Строка содержит подстроку: " + cond.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + cond.test("Name", 123));
        System.out.println("____________________");
        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Третий символ в строке: " + func.apply("first"));
        System.out.println("Третий символ в строке: " + func.apply("second"));
        System.out.println("____________________");
        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: " + builder
                .apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder
                .apply(new StringBuilder("tset rof gnirtS")));
        System.out.println("____________________");
        BinaryOperator<StringBuilder> builder2 = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "Строка после объединения: " + builder2.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );

    }

}
