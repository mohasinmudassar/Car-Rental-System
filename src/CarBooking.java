import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import static java.util.concurrent.TimeUnit.DAYS;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
public class CarBooking {
    LocalDate startDate,endDate;
    int carNumber;
    long totalDays;
    double newRate,cost;
    car Car;
    String carName;
    CarBooking(LocalDate startDate, LocalDate endDate, int carNumber){
        this.startDate = startDate;
        this.endDate = endDate;
        this.carNumber = carNumber;
    }
    void makeBooking(){
        String[] tokenizedLine = null;
        try{
            File file = new File("carlist.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                tokenizedLine = parse(line);
                if(String.valueOf(carNumber).equals(tokenizedLine[0])){
                    break;
                }
            }
            this.carNumber = Integer.parseInt(tokenizedLine[0]);
            this.carName = tokenizedLine[1] + " " + tokenizedLine[2];
            if(tokenizedLine[4].equals("Premium")){
                this.newRate = calPremiumRate(tokenizedLine[5]);
            }
            else{
                this.newRate = Double.parseDouble(tokenizedLine[5]);
            }
            this.calTotalDays();
            this.calCost(newRate, totalDays);
        }catch(Exception e){
            System.out.println("An error has occured while reading the file. Try again.");
        }
    }
    private String[] parse(String line) { 
        return line.split(",");
    }
    double calPremiumRate(String rate){
        double nR = Double.parseDouble(rate);
        nR *= 5;
        nR /= 100;
        nR += Double.parseDouble(rate);
        return nR;
    }
    void calTotalDays(){
        this.totalDays = ChronoUnit.DAYS.between(startDate, endDate);    
    }
    
    void calCost(double newRate, long totalDays){
        this.cost = newRate * totalDays;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public long getTotalDays() {
        return totalDays;
    }

    public double getNewRate() {
        return newRate;
    }

    public double getCost() {
        return cost;
    }
    String getCarName(){
        return carName;
    }
}
