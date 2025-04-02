package com.flightbooking;

import com.flightbooking.controller.PassengerController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PassengerController passengerController = new PassengerController();


        while (true){
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3.Exit");
            System.out.println("Choose an option: ");

            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    passengerController.authenticatePassenger(sc);
                    break;

                case "2":
                    passengerController.registerPassenger(sc);
                    break;

                case "3":
                    System.out.println("Bye");
                    return;

                default:
                    System.out.println("Please choose from 1-3");
            }
        }
    }
}
