package com.paypal.bfs.test.bookingserv.controller.impl;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import org.jeasy.random.EasyRandom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookingResourceImplTest {

    @InjectMocks
    BookingResourceImpl bookingResource = new BookingResourceImpl();

    @Mock
    BookingService bookingService;

    @Test
    public void create() {
        Booking bookingReq = getBookingRequest();
        ResponseEntity<Booking> response = bookingResource.create(bookingReq);
        assertNotNull(response.getBody());
    }

    @Test
    public void getAllBooking() {
        when(bookingService.getAllBooking()).thenReturn(getBookingList());
        ResponseEntity<List<Booking>> response = bookingResource.getAllBooking();
        assertEquals(2, response.getBody().size());
    }

    private Booking getBookingRequest(){
        EasyRandom generator = new EasyRandom();
        return generator.nextObject(Booking.class);
    }

    private List<Booking> getBookingList(){
        List<Booking> list = new ArrayList<>();
        EasyRandom generator = new EasyRandom();
        Booking b1= generator.nextObject(Booking.class);
        Booking b2= generator.nextObject(Booking.class);
        list.add(b1);
        list.add(b2);
        return list;
    }
}