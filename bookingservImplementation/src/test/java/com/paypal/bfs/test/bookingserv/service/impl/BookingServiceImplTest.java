package com.paypal.bfs.test.bookingserv.service.impl;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import junit.framework.TestCase;
import org.jeasy.random.EasyRandom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceImplTest extends TestCase {

    @InjectMocks
    BookingServiceImpl bookingService = new BookingServiceImpl();

    @Mock
    BookingRepository bookingRepository;

    @Test
    public void testCreateBooking() {
        Booking bookingReq = getBookingRequest();
        Booking booking = bookingService.createBooking(bookingReq);
        assertNotNull(booking);
    }

    @Test
    public void testGetAllBooking() {
        when(bookingRepository.findAll()).thenReturn(getBookingEntities());
        List<Booking> bookings = bookingService.getAllBooking();
        assertEquals(2, bookings.size());
    }

    @Test
    public void testGetAllBooking_No_Entity() {
        when(bookingRepository.findAll()).thenReturn(getBookingZeroEntity());
        List<Booking> bookings = bookingService.getAllBooking();
        assertEquals(0, bookings.size());
    }

    private List<BookingEntity> getBookingEntities(){
        List<BookingEntity> list = new ArrayList<>();
        EasyRandom generator = new EasyRandom();
        BookingEntity b1= generator.nextObject(BookingEntity.class);
        BookingEntity b2= generator.nextObject(BookingEntity.class);
        list.add(b1);
        list.add(b2);
        return list;
    }

    private List<BookingEntity> getBookingZeroEntity(){
        List<BookingEntity> list = new ArrayList<>();
        return list;
    }

    private Booking getBookingRequest(){
        EasyRandom generator = new EasyRandom();
        return generator.nextObject(Booking.class);
    }
}