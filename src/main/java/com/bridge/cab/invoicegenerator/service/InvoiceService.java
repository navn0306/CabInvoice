package com.bridge.cab.invoicegenerator.service;

import com.bridge.cab.invoicegenerator.model.InvoiceSummary;
import com.bridge.cab.invoicegenerator.model.Ride;

import java.util.List;

public class InvoiceService {

    private final double COST_PER_KM = 10.0;
    private final int COST_PER_MIN = 1;
    private final double MIN_FARE = 5.0;
    private final double PREMIUM_COST_PER_KM = 15.0;
    private final int PREMIUM_COST_PER_MIN = 2;
    private final double PREMIUM_MIN_FARE = 20;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
        return Math.max(totalFare, MIN_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return new InvoiceSummary(rides.length, (int) totalFare);
    }

    public double calculateFare(double distance, int time, String rideType) {
        if (rideType.equals("Normal")) {
            return calculateFare(distance, time);
        } else {
            double fare = distance * PREMIUM_COST_PER_KM + time * PREMIUM_COST_PER_MIN;
            return Math.max(fare, PREMIUM_MIN_FARE);
        }
    }

    public InvoiceSummary GetInvoiceSummary(String userName) {

        List<Ride> list = UserAccount.userMap.get(userName);
        double totalFare = 0.0;
        int rideCount = 0;
        for (Ride ride : list) {
            totalFare+=calculateFare(ride.getDistance(),ride.getTime(),ride.getRideType());
            rideCount++;
        }

        return new InvoiceSummary(rideCount, (int) totalFare);
    }
}
