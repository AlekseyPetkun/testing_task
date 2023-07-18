package com.gridnine.testing;

import com.gridnine.testing.model.Flight;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();

        System.out.println(flightList);


    }
}
