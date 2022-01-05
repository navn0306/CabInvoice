CabInvoiceGenerator

The Cab Service is a subscription based Cab Service, where the customer books a cab, and pays the bill at the end of the month.

UseCase1 - Calculate Fare
Given distance and time, the invoice generator should return the total fare for the journey.
Cost - Rs. 10 per kilometer + Rs. 1 per minute.
Minimum Fare - Rs. 5

UseCase2- Multiple Rides
The Invoice Generator should now take in multiple rides and calculate the aggregate total for all.

UseCase3- Enhanced Invoice
The Invoice Generator should now return the following as a part of the invoice.
- Total Number of rides.
- Total fare.
- Average Fare Per Ride.

UseCase4- Invoice Service 
Given a user id, the Invoice Service gets the List of rides from the RideRepository and returns the Invoice.

