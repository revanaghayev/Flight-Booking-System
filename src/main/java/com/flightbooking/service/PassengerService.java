package com.flightbooking.service;

import com.flightbooking.dao.PassengerDAO;
import com.flightbooking.model.Passenger;

public class PassengerService {
    private final PassengerDAO passengerDAO;

    public PassengerService(PassengerDAO passengerDAO) {
        this.passengerDAO = passengerDAO;
    }

    public void registerPassenger(String firstName, String lastName, String email, String password){
        if (passengerDAO.findPassengerByEmail(email) != null){
            throw new RuntimeException("Passenger with this email already exists.");
        }
        Passenger passenger = new Passenger(passengerDAO.getAllPassengers().size() + 1, firstName, lastName, email, password);
        passengerDAO.addPassenger(passenger);
    }

    public Passenger authenticate(String email, String password){
        Passenger passenger = passengerDAO.findPassengerByEmail(email);
        if (passenger != null && passenger.getPassword().equals(password)){
            return passenger;
        }
        throw new RuntimeException("Invalid email or password.");
    }

}
