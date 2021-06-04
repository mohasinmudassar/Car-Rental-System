
import java.io.IOException;
import java.time.LocalDate;

import java.util.*;
public class CarRentalTester {
    MenuDisplay menu;
    CarBooking carBooking;
    CarAndBookingDates carAndBookingDates;
    public static void main(String[] args) throws Exception{
        CarRentalTester o1 = new CarRentalTester();
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("*********************************************************");
            System.out.println("Welcome to Carrington Car Rental");
            System.out.println("Cars Available For Booking: ");
            System.out.println("---------------------------------------------------------");
            o1.menu = new MenuDisplay();
            int seats = o1.menu.displayCarList();
            System.out.println("---------------------------------------------------------");
            System.out.println("Total Cars Available: " + seats);
            System.out.println("\nSelect from one of the following options");
            System.out.println("\n1. To make a booking");
            System.out.println("2. To exit the system");
            System.out.print("\n\nEnter your selection: ");
            int selection = input.nextInt();
            if(selection == 1){
                System.out.println("To make a booking: ");
                
                int carNumber = 0;
                while(true){
                    System.out.print("\tSelect the car number from car list: ");
                    int c=0;
                    try{
                    carNumber = input.nextInt();
                    if(carNumber < 1 || carNumber > 6){
                        throw new InvalidNumber("Invalid Car Number. try again");
                    }
                    else{
                        c++;
                    }
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    if(c > 0){
                        break;
                    }
                }
                LocalDate carBookingStartDate = null;
                LocalDate carBookingEndDate = null;
                while(true){
                    int c=0;
                    System.out.println("\n\n\tEnter Booking Start date.");
                    o1.carAndBookingDates = new CarAndBookingDates();
                    carBookingStartDate = o1.carAndBookingDates.getCarBookingDateFull();
                    System.out.println("\n\tEnter Booking End Date: ");
                    carBookingEndDate = o1.carAndBookingDates.getCarBookingDateFull();
                    if((carBookingStartDate.compareTo(carBookingEndDate))<= 0){
                        break;
                    }
                    else{
                        System.out.println("Invalid Date. Please enter the dates again");
                    }
                }
                o1.carBooking = new CarBooking(carBookingStartDate,carBookingEndDate,carNumber);
                o1.carBooking.makeBooking();
                input.nextLine();
                System.out.print("\n\tYour Name: ");
                String name = input.nextLine();
                System.out.print("\n\tYour Email: ");
                String email = input.next();
                input.nextLine();
                System.out.print("\n\tYour Address: ");
                String address = input.nextLine();
                Customer customer = new Customer(name,email,address);
                System.out.println("---------------------------------------------------------\n");
                PrintBookingDetails p1 = new PrintBookingDetails();
                p1.printBookingDetails(o1.carBooking, customer);
                System.out.println("---------------------------------------------------------");
            }
            else if(selection == 2){
                break;
            }
            else{
                System.out.println("Invalid Selectin!");
            }
            
        }
    }
}

class InvalidNumber extends Exception{
        InvalidNumber(String s){
            super(s);
        }
}
