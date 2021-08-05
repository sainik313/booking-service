package com.paypal.bfs.test.bookingserv.api.exception;

public class BookingException extends RuntimeException{
    private String errorMessage;

    public BookingException( String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public BookingException() {

    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
