import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class CarAndBookingDates {
    int year,month,day;
    Scanner input = new Scanner(System.in);
    CarAndBookingDates(){
        this.year = 2020;
        this.month =10;
        this.day = 13;
        
    }
    int carSelection(int carsAvailable[]){
        while(true){
            int check =0;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the car you want to select: ");
            int selection = input.nextInt();
            for(int i=0;i<carsAvailable.length;i++){
                if(selection == carsAvailable[i]){
                    check++;
                }
            }
            if(check==0){
                System.out.println("Car not found. Please choose again");
                
            }
            else{
                return selection;
                
            }
        }
    }
    LocalDate getCarBookingDateFull(){
        this.year = promptForYear();
        this.month = promptForMonth();
        this.day = promptForDay();
        String yearS = String.valueOf(year);
        String dayS,monthS;
        if(month <10){
            monthS = "0" + String.valueOf(month);
        }
        else{
            monthS = String.valueOf(month);
        }
        if(day <10){
            dayS = "0" + String.valueOf(day);
        }
        else{
            dayS = String.valueOf(day);
        }
        
        String str = yearS + "-" + monthS + "-" + dayS;
        LocalDate dateTime = LocalDate.parse(str);

        return dateTime;
    }
    
    int promptForYear(){
        while(true){
            System.out.print("\tEnter the Year: ");
            int year = input.nextInt();
            if(validateYearString(year)){
                return year;
                
            }
            else{
                System.out.print("Invalid Year. Try Again.");
            }
        }
        
        
    }
    int promptForMonth(){
        while(true){
            System.out.print("\tEnter the month: ");
            int month = input.nextInt();
            if(validateMonthString(month)){
                return month;
            }
            else{
                System.out.println("\tInvalid Month. Try Again.");
            }
        }
    }
    int promptForDay(){
        while(true){
            System.out.print("\tEnter the day: ");
            int day = input.nextInt();
            if(validateDayString(day)){
                return day;
            }
            else{
                System.out.println("Invalid Day. Try again!");
            }
        }
    }
    boolean validateYearString(int year){
        if(year > 2020 || year <=1920){
            System.out.println("year not valid");
            return false;
        }
        else{
            return true;
        }
    }
    boolean validateMonthString(int month){
        if(month > 12 || month <=0){
            System.out.println("Month not valid");
            return false;
        }
        else{
            return true;
        }
    }
    boolean validateDayString(int day){
        if(day > 31 || day <=0){
            System.out.println("Day not valid");
            return false;
        }
        else{
            return true;
        }
    }
    
    public static void main(String[] args){
        CarAndBookingDates c1 = new CarAndBookingDates();
        int [] carsAvailable = {1,2,3};
        c1.carSelection(carsAvailable);
        c1.getCarBookingDateFull();
    }
}
