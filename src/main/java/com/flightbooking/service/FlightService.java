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

    public List<Flight> searchFlights(String destination, Integer requiredSeats) {
        return flightDAO.searchFlights(destination, requiredSeats);
    }

    public boolean bookFlight(Long flightID, Integer seatsToBook) {
        return flightDAO.updateAvailableSeats(flightID, seatsToBook);
    }

    public void addFlight(Flight flight) {
        flightDAO.addFlight(flight);
        flightDAO.saveFlights();
    }
    public void deleteFlight(Long flightID) {
        flightDAO.deleteFlight(flightID);
        flightDAO.saveFlights();
    }

    public Flight getFlightById(Long flightID) {
        return flightDAO.getFlightById(flightID);
    }
}
