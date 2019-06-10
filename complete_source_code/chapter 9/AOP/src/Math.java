import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Math {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("input.txt")){
            Scanner scanner = new Scanner(fileReader);
            String line = scanner.nextLine();
            fileReader.close();
            String[] parts = line.split(" ");
            int first = Integer.parseInt(parts[0]);
            int second = Integer.parseInt(parts[1]);
            long result = first + second;
            try (FileWriter fileWriter = new FileWriter("output.txt")){
                fileWriter.write((int)result);
                fileWriter.close();
            }
        } catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}
