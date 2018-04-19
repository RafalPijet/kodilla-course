package com.kodilla.exception.test;

public class FirstChallange {
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public static void main(String[] args) {
        String info = null;
        FirstChallange firstChallange = new FirstChallange();
        try {
            double result = firstChallange.divide(3, 0);
            System.out.println("Wynik dzielenia --> " + result);
            info = "SUKCESEM";
        } catch (ArithmeticException ae) {
            System.out.println("Pamiętaj chol.ro, nie dziel przez zero:)");
            info = "PORAŻKĄ";
        } finally {
            System.out.println("Operacja zakończona " + info);
        }
    }
}
