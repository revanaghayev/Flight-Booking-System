package com.flightbooking.dao;

import com.flightbooking.model.Flight;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightDAOImpl implements FlightDAO {

    private static final String FILE_PATH = "flights.dat";
    private List<Flight> flights = new ArrayList<>();

    public FlightDAOImpl() {
        flights = loadFlights();
    }

    private List<Flight> loadFlights() {
        File file = new File(FILE_PATH);
        if(!file.exists()) return new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Flight>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading flights: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    @Override
    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights);
    }

    @Override
    public List<Flight> getUpcomingFlights() {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(f -> f.getDepartureTime().isAfter(now) && f.getDepartureTime().isBefore(now.plusHours(24)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> searchFlights(String destination, Integer requiredSeats) {
        return flights.stream()
                .filter(f -> f.getDestination().equalsIgnoreCase(destination) && f.getAvailableSeats() >= requiredSeats)
                .collect(Collectors.toList());
    }

    @Override
    public Flight getFlightById(Long flightId) {
        return flights.stream()
                .filter(flight -> flight.getFlightID().equals(flightId))
                .findFirst().orElse(null);
    }

    @Override
    public boolean updateAvailableSeats(Long flightID, Integer seatsToBook) {
        for(Flight flight : flights) {
            if(flight.getFlightID().equals(flightID) && flight.getAvailableSeats() >= seatsToBook) {
                flight.setAvailableSeats(flight.getAvailableSeats() - seatsToBook);
                saveFlights();
                return true;
            }
        }
        return false;
    }

    @Override
    public void saveFlights() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
            oos.writeObject(flights);
        } catch (IOException e) {
            System.out.println("Error saving flights: " + e.getMessage());
        }
    }

    @Override
    public void addFlight(Flight flight) {
        if(flights.stream().noneMatch(fl -> fl.getFlightID().equals(flight.getFlightID()))) {
            flights.add(flight);
            saveFlights();
        } else {
            System.out.println("Flight already exists: " + flight.getFlightID());
        }
    }

    @Override
    public void deleteFlight(Long flightID) {
        if(flights.stream().anyMatch(fl -> fl.getFlightID().equals(flightID))) {
            flights.remove(flightID);
            saveFlights();
        } else {
            System.out.println("Flight does not exist: " + flightID);
        }
    }
}
