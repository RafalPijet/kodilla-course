package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuit {
    private static int counterTest = 0;

    @Before
    public void before(){
        counterTest++;
        System.out.println("\nRozpoczęcie przypadku testowego nr " + counterTest);
    }

    @After
    public void after() {
        System.out.println("Zakończenie przypadku testowego nr " + counterTest);
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("POCZĄTEK ZESTAWU TESTÓW");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("\nKONIEC ZESTAWU TESTÓW");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumberExterminator = new OddNumbersExterminator();
        ArrayList<Integer> emptyList = new ArrayList<Integer>();
        //When
        ArrayList<Integer> checkList = oddNumberExterminator.exterminate(emptyList);
        //Then
        Assert.assertTrue(checkList.isEmpty());
    }

    @Test
    public void testOddNumberExterminatorNormalList() {

        //Given
        OddNumbersExterminator oddNumberExterminator = new OddNumbersExterminator();
        ArrayList<Integer> onlyEvenNumbersList = new ArrayList<Integer>();
        ArrayList<Integer> numbersList = new ArrayList<Integer>();
        for (int i = 2; i < 11; i += 2) {
            onlyEvenNumbersList.add(i);
        }
        for (int i = 1; i < 11; i++) {
            numbersList.add(i);
        }

        //When
        ArrayList<Integer> checkList = oddNumberExterminator.exterminate(numbersList);

        //Then
        Assert.assertEquals(onlyEvenNumbersList, checkList);

    }
}
