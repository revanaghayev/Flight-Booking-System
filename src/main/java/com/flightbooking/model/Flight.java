package com.flightbooking.model;

import java.time.LocalDateTime;

public class Flight {
    private long flightID;
    private LocalDateTime departureTime;
    private String destination;
    private int totalSeats;
    private int availableSeats;

    public Flight(long flightID, LocalDateTime departureTime, String destination, int totalSeats, int availableSeats) {
        this.flightID = flightID;
        this.departureTime = departureTime;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public long getFlightID() {
        return flightID;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    @Override
    public String toString() {
        return "\n\n-----------FLIGHT INFO----------\n" +
                "Flight ID: " + flightID +
                "\nDeparture: " + departureTime +
                "\nDestination: " + destination +
                "\nAvailable Seats: " + availableSeats;
    }
}
