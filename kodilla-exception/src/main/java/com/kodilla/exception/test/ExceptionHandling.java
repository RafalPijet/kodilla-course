package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        boolean checkStatus = false;
        try {
            String result = secondChallenge.propableIWillThrowException(1.0, 1.5);
            System.out.println(result);
            checkStatus = true;
        } catch (Exception e) {
            System.out.println("Niedozwolony argument metody!!! --> " + e);
        } finally {
            if (checkStatus) {
                System.out.println("Wszystko OK");
            } else {
                System.out.println("Nie jest OK");
            }
        }
    }
}
