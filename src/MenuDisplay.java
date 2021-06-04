import java.io.*;
import java.nio.*;
import java.util.*;
public class MenuDisplay {
    String carNames[];
    int seats[];

    int displayCarList() throws IOException{
        return(readCsv());
    }
    public int readCsv()  {
        int numberOfCars =0;
        try{        
        File file = new File("carlist.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String[] tokenizedLine;
        System.out.println("Car no. \tCar Name \t\tSeats \t\tTransmission \t\tCar Type \tRate/Day($) ");
        while ((line = bufferedReader.readLine()) != null) {
            tokenizedLine = parse(line);
            for(int i=0;i<tokenizedLine.length;i++){
                System.out.print(tokenizedLine[i]+ " \t\t");
            }
            System.out.println();
            numberOfCars++;
        }
        
        }catch(Exception e){
            System.out.println("File not found!");
        }
        
        return numberOfCars;
    }
    private String[] parse(String line) { 
        return line.split(",");
    }
    public static void main(String[] args) throws IOException{
        MenuDisplay mn1 = new MenuDisplay();
        mn1.displayCarList();
    }
}
