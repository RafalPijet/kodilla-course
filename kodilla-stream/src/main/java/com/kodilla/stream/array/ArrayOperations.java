package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        System.out.println("Zawartość dostarczonej tablicy:");
        System.out.print("[");
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(n -> System.out.print(n + ", "));
        System.out.println("\b\b]");
        System.out.println();
        OptionalDouble result = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average();
        double doubleResult = result.getAsDouble();
        System.out.println("Średnia wartości w tablicy --> " + doubleResult);
        return doubleResult;
    }
}
