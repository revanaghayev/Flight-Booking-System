package com.flightbooking.dao;

import com.flightbooking.model.Flight;

import java.util.List;

public interface FlightDAO {
    List<Flight> getAllFlights();
    List<Flight> getUpcomingFlights();
    List<Flight> searchFlights(String destination, Integer requiredSeats);
    Flight getFlightById(Long flightId);
    boolean updateAvailableSeats(Long flightID, Integer seatsToBook);
    void saveFlights();
    void addFlight(Flight flight);
    void deleteFlight(Long flightID);
}
