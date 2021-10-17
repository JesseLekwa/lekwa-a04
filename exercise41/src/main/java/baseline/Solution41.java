package baseline;

import java.io.*;
import java.util.*;

public class Solution41{

    public static void readNames(Scanner input, ArrayList<String> names) {// defining the readNames() function to read the data from Scanner object to the ArrayList


        while (input.hasNextLine()) {


            names.add(input.nextLine());
        }
    }


    public static void outputNames(ArrayList<String> names) throws IOException {// defining the function to print the names in the file


        FileWriter output = new FileWriter("exercise41_output.txt");

        // writing the header of the output file about how many names are read from the input file
        output.write("Total of " + names.size() + " names\n");
        output.write("--------------------\n");

        // writing the names in the file after the header and separator

        for (String i : names) {
            output.write(i + "\n");
        }

        // closing the output FileWriter to avoid memory leakage
        output.close();
    }

    public static void main(String[] args) throws FileNotFoundException {


        Scanner inputFile = new Scanner(new File("exercise41_input.txt"));


        ArrayList<String> names = new ArrayList<>();


        readNames(inputFile, names);


        names.sort(String.CASE_INSENSITIVE_ORDER);

        
        inputFile.close();

        // writing the required data to the output file
        try {
            outputNames(names);
        }

        // if any exception is raised in writing to the output file then printing the exception on the console
        catch (Exception e) {
            System.out.println("Something went wrong while writing to the file");
        }
    }


}
