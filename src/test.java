
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class test {
    public void readCsv() throws IOException {
    File file = new File("carlist.csv");
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String line;
    String[] tokenizedLine;

    while ((line = bufferedReader.readLine()) != null) {
        tokenizedLine = parse(line);
        System.out.println(tokenizedLine[5]);
//        for(int i=0;i<tokenizedLine.length;i++){
//            System.out.print(tokenizedLine[i] + " ");
//        }
//        System.out.println();
    }
}
    private String[] parse(String line) { // use split or Scanner
    return line.split(",");
}
    public static void main(String[] args) throws IOException{
        test t1 = new test();
        t1.readCsv();
    }
}
