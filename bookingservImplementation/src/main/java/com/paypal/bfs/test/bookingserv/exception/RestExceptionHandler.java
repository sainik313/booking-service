package com.paypal.bfs.test.bookingserv.exception;

import com.paypal.bfs.test.bookingserv.api.exception.BookingException;
import com.paypal.bfs.test.bookingserv.api.exception.BookingExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BookingException.class)
    public ResponseEntity<Object> handleBookingException(
            BookingException ex,
            HttpServletRequest httpRequest,
            HttpServletResponse httpResponse) {
        BookingExceptionResponse apiError = new BookingExceptionResponse(ex.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
