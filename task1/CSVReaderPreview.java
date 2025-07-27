package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    
    public static void main(String[] args) {
        String filePath = "dataset/dataset.csv"; 
        String line;
        int rc = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            if ((line = br.readLine()) != null) {
                String[] headers = line.split(",");
                System.out.println("Columns:");
                for (String col : headers) {
                    System.out.print(col + "\t");
                }
                System.out.println("\nTotal number of columns: " + headers.length);
            }

            System.out.println("\nFirst 5 records:");
            while ((line = br.readLine()) != null && rc < 5) {
                String[] values = line.split(",");
                for (String val : values) {
                    System.out.print(val + "\t");
                }
                System.out.println();
                rc++;
            }
            while ((line = br.readLine()) != null) {
                rc++;
            }
            System.out.println("\nTotal number of data rows (excluding header): " + rc);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
