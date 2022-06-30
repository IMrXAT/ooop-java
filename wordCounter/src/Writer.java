import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private FileWriter writer;

    public Writer(String path){
        try{
            writer = new FileWriter(path);
        } catch (IOException exception) {
            System.err.println("wrong path");
            System.exit(-1);
        }
    }

    public void println(String string) throws IOException {
        writer.write(string);
        writer.write('\n');
    }

    public void close(){
        try{
            writer.close();
        }
        catch (IOException exception){
            System.err.println("cant close");
            System.exit(-1);
        }
    }
}
