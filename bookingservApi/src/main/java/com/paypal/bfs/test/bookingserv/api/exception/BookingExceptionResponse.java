package com.paypal.bfs.test.bookingserv.api.exception;

public class BookingExceptionResponse{
    private String errorMessage;
    private String statusCode;

    public BookingExceptionResponse(String errorMessage, String statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }
}
