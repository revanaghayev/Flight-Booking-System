package com.flightbooking;
//
//import com.flightbooking.controller.FlightController;
//import com.flightbooking.service.FlightService;
//import com.flightbooking.dao.FlightDAOImpl;
//
//import java.time.LocalDateTime;
//import java.util.Scanner;
//
public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        FlightController flightController = new FlightController(new FlightService(new FlightDAOImpl()));
//
//        while (true) {
//            System.out.println("\n===== Flight Booking System =====");
//            System.out.println("1. Show all flights");
//            System.out.println("2. Show upcoming flights (next 24 hours)");
//            System.out.println("3. Search for a flight");
//            System.out.println("4. Book a flight");
//            System.out.println("5. Add a new flight");
//            System.out.println("6. Exit");
//            System.out.print("Choose an option: ");
//
//            int choice;
//            try {
//                choice = Integer.parseInt(scanner.nextLine());
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input! Please enter a number.");
//                continue;
//            }
//
//            switch (choice) {
//                case 1:
//                    flightController.showAllFlights();
//                    break;
//
//                case 2:
//                    flightController.showUpcomingFlights();
//                    break;
//
//                case 3:
//                    System.out.print("Enter destination: ");
//                    String destination = scanner.nextLine();
//                    System.out.print("Enter number of seats needed: ");
//                    int requiredSeats;
//                    try {
//                        requiredSeats = Integer.parseInt(scanner.nextLine());
//                        flightController.searchFlights(destination, requiredSeats);
//                    } catch (NumberFormatException e) {
//                        System.out.println("Invalid seat number. Please enter a valid integer.");
//                    }
//                    break;
//
//                case 4:
//                    System.out.print("Enter Flight ID: ");
//                    Long flightID;
//                    int seatsToBook;
//                    try {
//                        flightID = Long.parseLong(scanner.nextLine());
//                        System.out.print("Enter number of seats to book: ");
//                        seatsToBook = Integer.parseInt(scanner.nextLine());
//                        flightController.bookFlight(flightID, seatsToBook);
//                    } catch (NumberFormatException e) {
//                        System.out.println("Invalid input. Flight ID and seat count must be numbers.");
//                    }
//                    break;
//
//                case 5:
//                    System.out.print("Enter Flight ID: ");
//                    Long newFlightID;
//                    LocalDateTime departureTime;
//                    int totalSeats;
//                    try {
//                        newFlightID = Long.parseLong(scanner.nextLine());
//                        System.out.print("Enter departure date & time (yyyy-MM-dd HH:mm): ");
//                        String dateTimeInput = scanner.nextLine();
//                        departureTime = LocalDateTime.parse(dateTimeInput.replace(" ", "T"));
//                        System.out.print("Enter destination: ");
//                        String newDestination = scanner.nextLine();
//                        System.out.print("Enter total seats: ");
//                        totalSeats = Integer.parseInt(scanner.nextLine());
//
//                        flightController.addFlight(newFlightID, departureTime, newDestination, totalSeats);
//                    } catch (Exception e) {
//                        System.out.println("Invalid input! Please check your format.");
//                    }
//                    break;
//
//                case 6:
//                    System.out.println("Exiting application...");
//                    scanner.close();
//                    System.exit(0);
//                    break;
//
//                default:
//                    System.out.println("Invalid option! Please choose a valid number.");
//            }
//        }
//    }
}
