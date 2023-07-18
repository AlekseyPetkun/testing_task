package com.gridnine.testing.service.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FilterService;

import java.util.List;

/**
 * Бизнес-логика по работе с фильтрацией набора перелётов согласно различным правилам
 */
public class FilterServiceImpl implements FilterService {

    @Override
    public List<Flight> removeFlightUpToTheCurrentPointInTime(List<Flight> flightBuilder) {
        return null;
    }

    @Override
    public List<Flight> removeSegmentsWithAnArrivalDateEarlierThanTheDepartureDate(List<Flight> flightBuilder) {
        return null;
    }

    @Override
    public List<Flight> removeTimeSpentOnEarthExceedsTwoHours(List<Flight> flightBuilder) {
        return null;
    }
}
