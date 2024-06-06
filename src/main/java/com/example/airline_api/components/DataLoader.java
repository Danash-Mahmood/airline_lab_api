package com.example.airline_api.components;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
public class DataLoader implements ApplicationRunner {



    @Autowired
    FlightService flightService;

    @Autowired
    PassengerService passengerService;

    @Autowired
    BookingRepository bookingRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception{

        Flight dortmund = new Flight("Dortmund", 136, "03/06/2024", "13:00");
        flightService.addNewFlight(dortmund);

        Passenger robbie = new Passenger("Robbie", "robbiemcilwaine99@gmail.com");
        passengerService.addPassenger(robbie);

        Passenger dan = new Passenger("Danash", "danashmahmood@yahoo.com");
        passengerService.addPassenger(dan);
        Passenger charisma = new Passenger("Charisma", "charismak@hotmail.com");
        passengerService.addPassenger(charisma);

        Booking booking = new Booking(dortmund,robbie,1);
        bookingRepository.save(booking);












    }














}
