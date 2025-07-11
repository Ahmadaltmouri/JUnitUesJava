/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Flight> flights;
    private List<Passenger> passengers;

    public BookingSystem() {
        flights = new ArrayList<Flight>();
        passengers = new ArrayList<Passenger>();
    }

    public void addFlight(String flightNumber, String departure, String destination, int totalSeats) {
        flights.add(new Flight(flightNumber, departure, destination, totalSeats));
    }

    public void addPassenger(String name, String passportNumber) {
        passengers.add(new Passenger(name, passportNumber));
    }

    public boolean bookFlight(String flightNumber, String passportNumber) {
        Flight flight = null;
        for (Flight f : flights) {
            if (f.getFlightNumber().equals(flightNumber)) {
                flight = f;
                break;
            }
        }

        if (flight == null || flight.bookSeat() == false) {
            System.out.println("Sorry, no available seats on this flight.");
            return false;
        }

        for (Passenger p : passengers) {
            if (p.getPassportNumber().equals(passportNumber)) {
                System.out.println("Booking successful for " + p.getName());
                return true;
            }
        }

        System.out.println("Passenger not found.");
        return false;
    }

    public void printFlights() {
        for (Flight f : flights) {
            System.out.println("Flight " + f.getFlightNumber() + ": " + f.getDeparture() + " -> " + f.getDestination() + ", Available Seats: " + f.getAvailableSeats());
        }
    }
}
