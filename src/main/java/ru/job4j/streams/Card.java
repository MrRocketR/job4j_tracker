package ru.job4j.streams;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values())
                        .map(v -> new Card(s, v)))
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "["
                + suit
                + ", " + value
                + ']';
    }
}
