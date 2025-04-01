package com.flightbooking.model;

import java.time.LocalDateTime;

public class Flight {
    private Long flightID;
    private LocalDateTime departureTime;
    private String destination;
    private Integer totalSeats;
    private Integer availableSeats;

    public Flight(Long flightID, LocalDateTime departureTime, String destination, Integer totalSeats, Integer availableSeats) {
        this.flightID = flightID;
        this.departureTime = departureTime;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public Long getFlightID() {
        return flightID;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }
    public void setAvailableSeats(Integer availableSeats) {
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
