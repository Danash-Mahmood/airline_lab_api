package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    // TODO: Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.displayAllFlights(), HttpStatus.OK);
    }

    // TODO: Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(long id){
        Optional<Flight> flight = flightService.displayFlight( id);
        if(flight.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

        else{
            return new ResponseEntity<>(flight.get(),HttpStatus.OK);
        }
    }

    // TODO: Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        flightService.addNewFlight(flight);
        return new ResponseEntity<>(flight,HttpStatus.OK);
    }

    // TODO: Extension - Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity cancelFlight(){
        return null;
    }

}
