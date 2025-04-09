package com.flightbooking.dao;

import com.flightbooking.model.Booking;
import com.flightbooking.model.Flight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingDAOImpl implements BookingDAO{

    private List<Booking> bookings = new ArrayList<>();
    private String FILE_PATH = "bookings.dat";

    public BookingDAOImpl() {
        bookings = loadBookings();
    }

    private List<Booking> loadBookings() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Booking>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addBooking(Booking booking) {
        if(bookings.stream().noneMatch(fl -> fl.getBookingId().equals(booking.getBookingId()))) {
            bookings.add(booking);
            saveBookings();
        } else {
            System.out.println("Booking already exists: " + booking.getBookingId());
        }
    }

    @Override
    public List<Booking> findAllBookings() {
        return new ArrayList<>(bookings);
    }

    @Override
    public Booking findBookingsById(Integer Id) {
        return bookings.stream()
                .filter(booking -> booking.getBookingId().equals(Id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Booking> findBookingsByPassengerName(String fullName) {
        return bookings.stream()
                .filter(booking -> booking.getPassengerFullNames().contains(fullName))
                .collect(Collectors.toList());
    }

    @Override
    public void updateBooking(Integer bookingId, Flight newFlight, Integer seatNumber, Double newTotalPrice) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            bookings = (List<Booking>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Creating a new file.");
            bookings = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        if (bookings == null) {
            System.out.println("No bookings found.");
            return;
        }

        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {

                booking.setFlight(newFlight);
                booking.setSeatNumber(seatNumber);
                booking.setTotalPrice(newTotalPrice);

                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                    oos.writeObject(bookings);
                    System.out.println("Booking updated successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }

    @Override
    public boolean deleteBookingById(String Id) {
        boolean removed = bookings.removeIf(booking -> booking.getBookingId().equals(Id));

        if (removed) {
            saveBookings();
        }

        return removed;
    }

    @Override
    public void saveBookings() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(bookings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
