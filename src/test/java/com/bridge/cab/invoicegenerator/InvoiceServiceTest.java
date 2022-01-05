package com.bridge.cab.invoicegenerator;

import com.bridge.cab.invoicegenerator.model.InvoiceSummary;
import com.bridge.cab.invoicegenerator.model.Ride;
import com.bridge.cab.invoicegenerator.service.InvoiceService;
import com.bridge.cab.invoicegenerator.service.UserAccount;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InvoiceServiceTest {

    @Test
    public void givenDistanceAndTime_whenCalculateFare_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        double totalFare = invoiceService.calculateFare(2.0, 5);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeTest2_whenCalculateFare_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        double totalFare = invoiceService.calculateFare(1.0, 5);
        Assert.assertEquals(15, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeTest2_whenFareIsLessThan5_ShouldReturnMinFare() {
        InvoiceService invoiceService = new InvoiceService();
        double totalFare = invoiceService.calculateFare(0.1, 1);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_whenCalculateFare_ShouldReturnAggregateTotalFare() {
        InvoiceService invoiceService = new InvoiceService();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(1.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummary expectedSummary = new InvoiceSummary(3,45);
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedSummary,summary);
    }

    @Test
    public void givenUserID_whenCalculateFare_shouldReturnAggregareSummery() {
        InvoiceService invoiceService=new InvoiceService();

        String userName="Navneet";
        List<Ride> rideList=new ArrayList<>();

        rideList.add(new Ride(1.0,5));
        rideList.add(new Ride(2.0,5));
        rideList.add(new Ride(0.1,1));
        new UserAccount(userName,rideList);
        InvoiceSummary actualSummary= invoiceService.GetInvoiceSummary(userName);
        InvoiceSummary expectedSummery= new InvoiceSummary(3,45);
        //  InvoiceSummery actualSummery=invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedSummery,actualSummary);
    }
}
