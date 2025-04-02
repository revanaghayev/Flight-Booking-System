package com.flightbooking.service;

import com.flightbooking.dao.FlightDAO;
import com.flightbooking.model.Flight;

import java.util.List;

public class FlightService {
    private final FlightDAO flightDAO;

    public FlightService(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public List<Flight> getAllFlights() {
        return flightDAO.getAllFlights();
    }

    public List<Flight> getUpcomingFlights() {
        return flightDAO.getUpcomingFlights();
    }

    public List<Flight> searchFlights(String destination, int requiredSeats) {
        return flightDAO.searchFlights(destination, requiredSeats);
    }

    public boolean bookFlight(Long flightID, int seatsToBook) {
        return flightDAO.updateAvailableSeats(flightID, seatsToBook);
    }

    public void addFlight(Flight flight) {
        flightDAO.addFlight(flight);
        flightDAO.saveFlights();
    }
}
