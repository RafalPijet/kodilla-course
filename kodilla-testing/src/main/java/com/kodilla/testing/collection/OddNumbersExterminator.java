package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {
    ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        ArrayList<Integer> onlyEvenNumbers = new ArrayList<Integer>();
        if (numbers.size() > 0) {
            for (Integer number : numbers) {
                if (number % 2 == 0) {
                    onlyEvenNumbers.add(number);
                }
            }
            System.out.println("Ilość liczb parzystych --> " + onlyEvenNumbers.size() + ", z " + numbers.size() + " liczb przekazanych");
        } else {
            System.out.println("Lista przekazana do metody 'exterminate' jest PUSTA!!!");
        }
        return onlyEvenNumbers;
    }
}
