package com.flightbooking.dao;

import com.flightbooking.model.Passenger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAOImpl implements PassengerDAO{

    private List<Passenger> passengers;
    private final String FILE_PATH = "passengers.dat";

    public PassengerDAOImpl(){
        passengers = loadPassengers();
    }

    private List<Passenger> loadPassengers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Passenger>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void savePassengers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(passengers); // Save passengers to file
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        savePassengers();
    }

    @Override
    public Passenger findPassengerByEmail(String email) {
        return passengers.stream().filter(p -> p.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public Passenger findPassengerById(int id) {
        return passengers.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updatePassenger(Passenger passenger) {
        passengers.stream().filter(p -> p.getId() == passenger.getId()).findFirst().ifPresent(p -> {
            passengers.set(passengers.indexOf(p),passenger );
            savePassengers();
        });
    }

    @Override
    public void deletePassenger(int id) {
        passengers.removeIf(passenger -> passenger.getId() == id);
        savePassengers();
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengers;
    }
}
