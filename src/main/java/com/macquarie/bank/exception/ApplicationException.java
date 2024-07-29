package com.macquarie.bank.exception;

/**
 * Custom exception class to handle specific application errors.
 */
public class ApplicationException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructor for ApplicationException with a message.
     *
     * @param message the error message
     */
    public ApplicationException(String message) {
        super(message);
    }

    /**
     * Constructor for ApplicationException with a message and cause.
     *
     * @param message the error message
     * @param cause the cause of the exception
     */
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
