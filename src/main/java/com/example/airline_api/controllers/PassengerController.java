package com.example.airline_api.controllers;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    //  Display details of all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){

        return new ResponseEntity<>(passengerService.displayAllPassengers(), HttpStatus.OK);
    }

    //  Display specific passenger details
    @GetMapping(value = "/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable long id ){
        Optional<Passenger> passenger = passengerService.displayPassenger(id);
        if(passenger.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(passenger.get(),HttpStatus.OK);
        }
    }

//    //
//    @PostMapping
//    public ResponseEntity<Passenger> addNewPassenger(){
//        return null;
//    }

}
