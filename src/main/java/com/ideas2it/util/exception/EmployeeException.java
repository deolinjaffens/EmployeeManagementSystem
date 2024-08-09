package com.ideas2it.util.exception;

/**
 * <p>
 * Exception class for exception that occurs all through the application
 * <p>
 *
 * @author Deolin Jaffens
 */

public class EmployeeException extends Exception {

    /**
     * <p>
     * Constructor called only when the error message has to be passed
     * </p>
     *
     * @param errorMessage - message that has to be passed
     */
    public EmployeeException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * <p>
     * Constructor called when the error message has to be passed along with
     * the cause
     * </p>
     *
     * @param errorMessage - message that has to be passed
     * @param cause        - cause of that specific exception
     */

    public EmployeeException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}