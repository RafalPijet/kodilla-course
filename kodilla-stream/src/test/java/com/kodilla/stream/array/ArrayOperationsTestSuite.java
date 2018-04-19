package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;
import java.util.Random;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        Random generatorNumbers = new Random();
        int sum = 0;
        int numbers[] = new int[20];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generatorNumbers.nextInt(100);
            sum += numbers[i];
        }

        //When
        double resultAverage = ArrayOperations.getAverage(numbers);
        double expectedAverage = (double) sum / numbers.length;

        //Then
        Assert.assertEquals(expectedAverage, resultAverage, 0.001);
    }

}
