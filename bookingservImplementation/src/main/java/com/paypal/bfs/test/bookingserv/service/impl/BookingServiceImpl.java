package com.paypal.bfs.test.bookingserv.service.impl;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entity.AddressEntity;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking request) {
        AddressEntity addressEntity = new AddressEntity();
        BeanUtils.copyProperties(request.getAddress(), addressEntity);
        BookingEntity bookingEntity = new BookingEntity();
        BeanUtils.copyProperties(request, bookingEntity);
        bookingEntity.setAddress(addressEntity);
        bookingRepository.save(bookingEntity);
        return request;
    }

    @Override
    public List<Booking> getAllBooking() {
        List<BookingEntity> bookingEntityList = bookingRepository.findAll();
        List<Booking> list = new ArrayList<>();
        for(BookingEntity entity: bookingEntityList){
            Booking booking = new Booking();
            BeanUtils.copyProperties(entity, booking);
            Address address = new Address();
            BeanUtils.copyProperties(entity.getAddress(), address);
            booking.setAddress(address);
            list.add(booking);
        }
        return list;
    }
}
