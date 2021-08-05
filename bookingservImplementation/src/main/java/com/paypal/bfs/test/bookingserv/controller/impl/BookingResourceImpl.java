package com.paypal.bfs.test.bookingserv.controller.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingResourceImpl implements BookingResource {

    @Autowired
    private BookingService bookingService;

    @Override
    public ResponseEntity<Booking> create(Booking request) {

        Booking booking = bookingService.createBooking(request);

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Booking>> getAllBooking() {

        List<Booking> bookingList = bookingService.getAllBooking();

        return new ResponseEntity<>(bookingList, HttpStatus.OK);
    }
}
