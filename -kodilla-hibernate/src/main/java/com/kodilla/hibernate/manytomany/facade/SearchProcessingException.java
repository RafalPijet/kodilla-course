package com.kodilla.hibernate.manytomany.facade;

public class SearchProcessingException extends Exception {

    public static String ERR_NOT_FOUND_EMPLOYEE = "The employee was not found for the given parameter value";
    public static String ERR_NOT_FOUND_COMPANY = "The company was not found for the given parameter value";

    public SearchProcessingException(String message) {
        super(message);
    }
}
