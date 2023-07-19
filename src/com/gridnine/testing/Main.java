package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.impl.FilterServiceImpl;

import java.util.List;

public class Main {

    private static final FilterServiceImpl filterService = new FilterServiceImpl();
    private static final List<Flight> flightList = FlightBuilder.createFlights();

    public static void main(String[] args) {

        allFlightList();

        removeFlightUpToTheCurrentPointInTime();

        removeSegmentsWithAnArrivalDateEarlierThanTheDepartureDate();

        removeTimeSpentOnEarthExceedsTwoHours();

//        List<Flight> flightList = FlightBuilder.createFlights();
//
//        FilterServiceImpl filterService = new FilterServiceImpl();

//        separator();
//        System.out.println(flightList);

//        separator();
//        System.out.println(filterService.removeFlightUpToTheCurrentPointInTime(flightList));

//        separator();
//        System.out.println(filterService.removeSegmentsWithAnArrivalDateEarlierThanTheDepartureDate(flightList));

//        separator();
//        System.out.println(filterService.removeTimeSpentOnEarthExceedsTwoHours(flightList));
    }



    private static void allFlightList() {

        separator();
        System.out.println(flightList);
    }

    private static void removeFlightUpToTheCurrentPointInTime() {

        separator();
        System.out.println(filterService.removeFlightUpToTheCurrentPointInTime(flightList));
    }

    private static void removeSegmentsWithAnArrivalDateEarlierThanTheDepartureDate() {

        separator();
        System.out.println(filterService.removeSegmentsWithAnArrivalDateEarlierThanTheDepartureDate(flightList));
    }

    private static void removeTimeSpentOnEarthExceedsTwoHours() {

        separator();
        System.out.println(filterService.removeTimeSpentOnEarthExceedsTwoHours(flightList));
    }

    private static void separator() {

        System.out.println("=======================================================================");
    }
}
