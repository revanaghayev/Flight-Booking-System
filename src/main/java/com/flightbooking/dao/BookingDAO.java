package com.flightbooking.dao;

import com.flightbooking.model.Booking;
import com.flightbooking.model.Flight;

import java.util.List;

public interface BookingDAO {

    void addBooking(Booking booking);
    List<Booking> findAllBookings();
    Booking findBookingsById(Integer Id);
    List<Booking> findBookingsByPassengerName(String fullName);
    void updateBooking(Integer bookingId, Flight newFlight, Integer seatNumber, Double newTotalPrice);
    boolean deleteBookingById(String id);
    void saveBookings();
}
