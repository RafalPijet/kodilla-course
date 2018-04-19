package com.kodilla.stream.iterate;

import java.util.stream.Stream;

public final class NumbersGenerator {
    public static void generateEven(int max) {
        Stream.iterate(1, n -> n + 1)
                .limit(max)
                .filter(n -> n % 2 == 0)
                .map(n -> n + ", ")
                .forEach(System.out::print);
    }
}
