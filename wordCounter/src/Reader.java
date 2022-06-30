import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {

    private FileReader fileReader;
    private Scanner scanner;
    public Reader(String path){
        try{
            fileReader = new FileReader(path);
            scanner = new Scanner(fileReader);
        }
        catch (IOException exception){
            System.err.println("path is not correct");
            System.exit(-1);
        }
    }

    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }

    public String getNextLine(){
        return scanner.nextLine();
    }

    public void close(){
        try{
            fileReader.close();
            scanner.close();
        }
        catch (IOException exception){
            System.err.println("cant close");
            System.exit(-1);
        }
    }

}
