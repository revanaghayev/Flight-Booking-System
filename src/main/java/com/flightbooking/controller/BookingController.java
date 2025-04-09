package com.flightbooking.controller;

import com.flightbooking.model.Booking;
import com.flightbooking.model.Flight;
import com.flightbooking.service.BookingService;

import java.time.LocalDateTime;
import java.util.List;

public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void createBooking(Integer bookingId, Flight flight, List<String> passengerFullNames, Integer seatNumber, Double totalPrice, LocalDateTime bookingDate, Integer numberOfTickets) {
        try {
            Booking createdBooking = bookingService.createBooking(bookingId, flight, passengerFullNames, seatNumber, totalPrice, bookingDate, numberOfTickets);
            System.out.println("Booking created successfully: " + createdBooking);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating booking: " + e.getMessage());
        }
    }

    public void findAllBookings() {
        bookingService.findAllBookings();
    }

    public void findBookingById(Integer Id) {
        Booking booking = bookingService.findBookingById(Id);
        if (booking != null) {
            System.out.println("Booking found: " + booking);
        } else {
            System.out.println("Booking not found!");
        }
    }

    public void findBookingByPassengerName(String fullName) {
        List<Booking> booking = bookingService.findBookingsByPassengerNames(fullName);
        if (booking != null) {
            System.out.println("Bookings found: " + booking);
        } else {
            System.out.println("Bookings not found!");
        }
    }

    public void updateBooking(Integer bookingId, Flight newFlight, Integer newSeat, Double newTotalPrice) {
        try {
            bookingService.updateBooking(bookingId, newFlight, newSeat, newTotalPrice);
            System.out.println("Booking updated successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error updating booking: " + e.getMessage());
        }
    }

    public void saveBookings() {
        bookingService.saveBookings();
    }

    public void deleteBooking(Integer id) {
        try {
            bookingService.deleteBooking(id);
            System.out.println("Booking deleted successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error deleting booking: " + e.getMessage());
        }
    }
}
