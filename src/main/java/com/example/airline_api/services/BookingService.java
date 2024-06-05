package com.example.airline_api.services;


import com.example.airline_api.models.Booking;
import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    FlightService flightService;

    @Autowired
    PassengerService passengerService;


    public void bookPassenger(BookingDTO bookingDTO){
        Passenger passenger = passengerService.displayPassenger(bookingDTO.getPassengerId()).get();
        Flight flight = flightService.displayFlight(bookingDTO.getFlightId()).get();

        Booking booking = new Booking(flight,passenger, bookingDTO.getSeatNumber());
        flight.setCapacity(flight.getCapacity() -1 );

        this.bookingRepository.save(booking);




    }

    public List<Booking> getAllBookings(){
        return this.bookingRepository.findAll();
    }








}
