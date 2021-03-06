package com.paypal.bfs.test.bookingserv.service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

import java.util.List;

public interface BookingService {
    public Booking createBooking(Booking request);
    public List<Booking> getAllBooking();
}
