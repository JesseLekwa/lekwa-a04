package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution42 {

    public void formatFile(String filename){
        try {
            // scan in file
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            //  loop to read and parse
            while(sc.hasNext()) {
                String s = sc.nextLine();
                String[] temp = s.split(",");
                //  output format
                System.out.printf("%-10s%-10s%-10s%n", temp[0], temp[1], temp[2]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error: File not found");
        }

    }
    public static void main(String[] args){
        Solution42 Employee = new Solution42();
        System.out.printf("%-10s%-10s%-10s%n", "Last", "First", "Salary");
        System.out.printf("---------------------------");
        Employee.formatFile("exercise42_input.txt");
    }
}
