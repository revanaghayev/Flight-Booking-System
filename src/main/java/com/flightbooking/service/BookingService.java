package com.flightbooking.service;

import com.flightbooking.dao.BookingDAO;
import com.flightbooking.dao.BookingDAOImpl;
import com.flightbooking.model.Booking;
import com.flightbooking.model.Flight;
import com.flightbooking.model.Seat;

import java.time.LocalDateTime;
import java.util.List;

public class BookingService {

    private final BookingDAO bookingDAO;

    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public Booking createBooking(Integer bookingId, Flight flight, List<String> passengerFullNames, Integer seatNumber, Double totalPrice, LocalDateTime bookingDate, Integer numberOfTicets) {
        if (bookingId == null || flight == null || passengerFullNames == null || seatNumber == null || totalPrice <= 0 || bookingDate == null || numberOfTicets == null) {
//            return;
            throw new RuntimeException("Invalid booking information.");
        }

//        if (!isSeatAvailable(seat)) {
        if (seatNumber == null || seatNumber >= 0) {
//            return;
            throw new RuntimeException("The seat is already booked.");
        }

        Booking newBooking = new Booking();
        newBooking.setBookingId(bookingId);
        newBooking.setFlight(flight);
        newBooking.setPassengerFullNames(passengerFullNames);
        newBooking.setSeatNumber(seatNumber);
        newBooking.setTotalPrice(totalPrice);
        newBooking.setBookingDate(bookingDate);
        newBooking.setNumberOfTickets(numberOfTicets);

        bookingDAO.addBooking(newBooking);

//        seat.setBooked(true);
        System.out.println("Booking successfully created.");
        return newBooking;
    }

    public List<Booking> findAllBookings() {
        return bookingDAO.findAllBookings();
    }

    public Booking findBookingById(Integer id) {
        return bookingDAO.findBookingsById(id);
    }

    public List<Booking> findBookingsByPassengerNames(String fullName) {
        return bookingDAO.findBookingsByPassengerName(fullName);
    }

    public void updateBooking(Integer bookingId, Flight newFlight, Integer newSeat, Double newTotalPrice) {
        if (bookingId == null || newFlight == null || newSeat == null || newTotalPrice<= 0) {
            System.out.println("Invalid booking details.");
            return;
        }

//        if (isSeatAvailable(newSeat)) {
//            System.out.println("The selected seat is already booked.");
//            return;
//        }

        bookingDAO.updateBooking(bookingId, newFlight, newSeat, newTotalPrice);
    }

    public boolean deleteBooking(Integer Id) {
        Booking booking = bookingDAO.findBookingsById(Id);
        if (booking == null) {
            throw new IllegalArgumentException("Booking not found");
        }
        return bookingDAO.deleteBookingById(String.valueOf(Id));
    }

    public void saveBookings() {
        bookingDAO.saveBookings();
    }

    private boolean isSeatAvailable(Seat seat) {
//        return !seat.isBooked();
        return true;
    }
}
