package com.flightbooking.dao;

import com.flightbooking.model.Flight;

import java.util.List;

public interface FlightDAO {
    List<Flight> getAllFlights();
    List<Flight> getUpcomingFlights();
    List<Flight> searchFlights(String destination, int requiredSeats);
    boolean updateAvailableSeats(Long flightID, int seatsToBook);
    void saveFlights();
    void addFlight(Flight flight);
}
