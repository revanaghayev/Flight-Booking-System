package com.flightbooking.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Booking implements Serializable {

    private Integer bookingId;
    private Flight flight;
    private List<String> passengerFullNames;
    private Integer seatNumber;
    private Double totalPrice;
    private LocalDateTime bookingDate;
    private Integer numberOfTickets;

    public Booking(Integer bookingId, Flight flight, List<String> passengerFullNames, Integer seatNumber, Double totalPrice, LocalDateTime bookingDate, Integer numberOfTicets) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.passengerFullNames = passengerFullNames;
        this.seatNumber = seatNumber;
        this.totalPrice = totalPrice;
        this.bookingDate = bookingDate;
        this.numberOfTickets = numberOfTicets;
    }

    public Booking() {

    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<String> getPassengerFullNames() {
        return passengerFullNames;
    }

    public void setPassengerFullNames(List<String> passengerFullNames) {
        this.passengerFullNames = passengerFullNames;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public String toString() {
        return "\n\n-----------BOOKING INFO-----------\n" +
                "Booking ID: " + bookingId +
                "\nFlight: " + flight +
                "\nSeat Number: " + seatNumber +
                "\nTotal Price: " + totalPrice +
                "\nBooking Date: " + bookingDate +
                "\nPassenger Full Names: " + passengerFullNames +
                "\nNumber of Tickets: " + numberOfTickets;
    }
}
