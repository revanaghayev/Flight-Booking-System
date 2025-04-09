package com.flightbooking;

import com.flightbooking.controller.BookingController;
import com.flightbooking.dao.BookingDAO;
import com.flightbooking.dao.BookingDAOImpl;
import com.flightbooking.model.Booking;
import com.flightbooking.service.BookingService;

public class Main {

    public static void main(String[] args) {
        Booking booking = new Booking();
//        BookingDAO bookingDAO = new Booking
        BookingController bookingController = new BookingController(booking)
    }
}
