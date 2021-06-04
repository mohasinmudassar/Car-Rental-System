
public class PrintBookingDetails {
    void printBookingDetails(CarBooking carBooking,Customer customer ){
        System.out.println("Thank you for booking, " + customer.getCustomerName());
        System.out.println("Email: " + customer.customerEmail);
        System.out.println("Address: " + customer.customerAddress);
        System.out.println("......................................");
        System.out.println("Car Selected: " + carBooking.getCarName());
        System.out.println("Start Date: " + carBooking.getStartDate());
        System.out.println("End Date: " + carBooking.getEndDate());
        System.out.println("Number of Days Booked: " + carBooking.getTotalDays());
        System.out.println("Car Rate per Day: " + carBooking.getNewRate());
    }
}
