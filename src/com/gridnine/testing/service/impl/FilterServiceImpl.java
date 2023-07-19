package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FilterService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Бизнес-логика по работе с фильтрацией набора перелётов согласно различным правилам
 */
public class FilterServiceImpl implements FilterService {

    @Override
    public List<Flight> removeFlightUpToTheCurrentPointInTime(List<Flight> flightBuilder) {

        return flightBuilder.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now())))
                .collect(Collectors.toList());

        /*List<Flight> filter = new ArrayList<>();

        for (Flight flight : flightBuilder) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isAfter(LocalDateTime.now())) {
                    filter.add(flight);
                    break;
                }
            }
        }
        return filter;*/
    }

    @Override
    public List<Flight> removeSegmentsWithAnArrivalDateEarlierThanTheDepartureDate(List<Flight> flightBuilder) {

        return flightBuilder.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());

        /*List<Flight> filter = new ArrayList<>(flightBuilder);

        for (Flight flight : flightBuilder) {
            for (Segment segment : flight.getSegments()) {
                if (!segment.getArrivalDate().isAfter(segment.getDepartureDate())) {
                    filter.remove(flight);
                    break;
                }
            }
        }
        return filter;*/
    }


    @Override
    public List<Flight> removeTimeSpentOnEarthExceedsTwoHours(List<Flight> flightBuilder) {

        return flightBuilder.stream()
                .filter(flight -> {
                    if (flight.getSegments().size() > 1) {
                        for (int i = 0; i < flight.getSegments().size() - 1; ) {
                            if (flight.getSegments().get(i + 1).getDepartureDate().getHour()
                                    - flight.getSegments().get(i).getArrivalDate().getHour() > 2) {
                                return false;
                            } else {
                                i++;
                            }
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());

//        List<Flight> filter = new ArrayList<>(flightBuilder);
//
//        for (Flight flight : flightBuilder) {
//            if (flight.getSegments().size() > 1) {
//                for (int i = 0; i < flight.getSegments().size() - 1; i++) {
//                    if (flight.getSegments().get(i + 1).getDepartureDate().getHour() -
//                            flight.getSegments().get(i).getArrivalDate().getHour() > 2) {
//                        filter.remove(flight);
//                        break;
//                    }
//                }
//            }
//        }
//        return filter;
    }
}
