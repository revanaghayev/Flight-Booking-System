package com.flightbooking.dao;

import com.flightbooking.model.Passenger;
import java.util.List;

public interface PassengerDAO {
    void addPassenger(Passenger passenger);
    Passenger findPassengerByEmail(String email);
    Passenger findPassengerById(int id);
    void updatePassenger(Passenger passenger);
    void deletePassenger(int id);
    void savePassengers();
    List<Passenger> getAllPassengers();
}
