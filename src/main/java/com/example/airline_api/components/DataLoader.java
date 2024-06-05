package com.example.airline_api.components;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.services.BookingService;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;



    @Autowired
    FlightService flightService;

    @Autowired
    PassengerService passengerService;

    // We only need to autowire the bookingRepositry and not the other two repositories as we need the booking repositry to save bookings, and the save bookings method ony requires the passenger service and flightservice classes


    @Override
    public void run(ApplicationArguments args) throws Exception{

        //Passengers

        Flight dortmund = new Flight("Athens", 100, "04/06/2024", "09:00");

        flightService.addNewFlight(dortmund);

        Passenger robbie = new Passenger("Robbie", "robbiemcilwaine99@gmail.com");

        passengerService.addPassenger(robbie);

        Passenger dan = new Passenger("Danash", "danashmahmood@gmail.com");
        passengerService.addPassenger(dan);
        Passenger charisma = new Passenger("Charisma", "charismak@hotmail.com");
        passengerService.addPassenger(charisma);

        Booking booking1 = new Booking(dortmund,robbie,1);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking(dortmund,dan,2);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking(dortmund,charisma,3);
        bookingRepository.save(booking3);














    }



}
