package com.flightbooking.controller;

import com.flightbooking.dao.PassengerDAOImpl;
import com.flightbooking.model.Passenger;
import com.flightbooking.service.PassengerService;

import java.util.Scanner;

public class PassengerController {
    private  PassengerService passengerService;
    private Passenger currentPassenger;

    public PassengerController() {
        this.passengerService = new PassengerService(new PassengerDAOImpl());
    }

    public Passenger getCurrentPassenger(){
        return currentPassenger;
    }

    public void authenticatePassenger(Scanner sc){
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();

        try {
            currentPassenger = passengerService.authenticate(email,password);
            System.out.println("Welcome, " + currentPassenger.getFirstName());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void registerPassenger(Scanner sc){
        System.out.println("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();

        try {
            passengerService.registerPassenger(firstName, lastName, email,password);
            System.out.println("Registered successfully!");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
