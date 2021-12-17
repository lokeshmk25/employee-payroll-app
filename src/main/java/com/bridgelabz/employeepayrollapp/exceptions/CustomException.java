package com.bridgelabz.employeepayrollapp.exceptions;

/**
 * Purpose - To create CustomException that throws in Run time
 *
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 08-12-21
 */
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
