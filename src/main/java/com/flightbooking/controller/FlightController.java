package com.flightbooking.controller;

import com.flightbooking.model.Flight;
import com.flightbooking.service.FlightService;

import java.time.LocalDateTime;
import java.util.List;

public class FlightController {
    private final FlightService flightService;
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    public void showAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        if(flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            flights.forEach(System.out::println);
        }
    }
    public void showUpcomingFlights() {
        List<Flight> flights = flightService.getUpcomingFlights();
        if(flights.isEmpty()) {
            System.out.println("No available flights in the next 24 hours.");
        } else {
            flights.forEach(System.out::println);
        }
    }

    public void searchFlights(String destination, Integer requiredSeats) {
        List<Flight> flights = flightService.searchFlights(destination, requiredSeats);
        if(flights.isEmpty()) {
            System.out.println("No flights found matching your criteria.");
        } else {
            flights.forEach(System.out::println);
        }
    }

    public void bookFlight(Long flightID, Integer seatsToBook) {
        boolean success = flightService.bookFlight(flightID, seatsToBook);
        if(success) {
            System.out.println("Booking successful! " + seatsToBook + " seats booked.");
        } else {
            System.out.println("Booking failed!");
        }
    }
    public void addFlight(Long flightID, LocalDateTime departureTime, String destination, Integer totalSeats) {
        Flight newFlight = new Flight(flightID, departureTime, destination, totalSeats, totalSeats);
        flightService.addFlight(newFlight);
        System.out.println("New flight added successfully: " + newFlight);
    }
    public void deleteFlight(Long flightID) {
        try {
            flightService.deleteFlight(flightID);
            System.out.println("Flight deleted successfully: " + flightID);
        } catch (Exception e) {
            System.out.println("Error deleting flight: " + flightID);
        }
    }

    public void getFlightById(Long flightID) {
        Flight flight = flightService.getFlightById(flightID);
        if(flight != null) {
            System.out.println("Flight found: " + flight);
        } else {
            System.out.println("Flight not found!");
        }
    }
}
