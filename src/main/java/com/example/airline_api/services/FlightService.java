package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;


    public List<Flight> displayAllFlights(){
        return this.flightRepository.findAll();
    }

    public Optional<Flight> displayFlight(long id ){
        return this.flightRepository.findById(id); //the controller will handle unwrappig the optional
    }

    public void addNewFlight(Flight flight){
        this.flightRepository.save(flight);
    }






}
