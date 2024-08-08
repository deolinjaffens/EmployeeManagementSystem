package com.ideas2it.util.exception;

/**
 *<p>
 *Exception class for Database related errors
 *<p>
 *@author Deolin Jaffens
 */

public class EmployeeException extends Exception {
    public EmployeeException(String errorMessage) {
        super(errorMessage);
    }

    public EmployeeException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}