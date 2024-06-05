package com.example.airline_api.models;

import java.util.List;

public class PassengerDTO {

    private String name;
    private String email;
    private List<Booking> bookingIds; //this is a payload class that will take in a List of bookingIds to the services. Also as passengers has a booking property which is a list of booking objects

    public PassengerDTO(String name, String email, List<Booking> bookingIds) {
        this.name = name;
        this.email = email;
        this.bookingIds = bookingIds;
    }

    public PassengerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Booking> getBookingIds() {
        return bookingIds;
    }

    public void setBookingIds(List<Booking> bookingIds) {
        this.bookingIds = bookingIds;
    }
}
