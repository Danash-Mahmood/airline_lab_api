package com.example.airline_api.services;


import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;


    public void addPassenger(Passenger passenger){
        this.passengerRepository.save(passenger); //the booking table doesnt have a passneger column so we don't need to save to that table
    }

    public List<Passenger> displayAllPassengers(){
        return this.passengerRepository.findAll();

    }

    public Optional<Passenger> displayPassenger(Long id){

        return this.passengerRepository.findById(id); //the controller will handle unwrapping of the optional

    }




}
