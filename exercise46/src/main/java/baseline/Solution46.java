package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution46 {
    public static void main(String[] args) throws FileNotFoundException {




        ReadInputFile rf = new ReadInputFile();


        rf.readfile();

        // method to get map

        HashMap<String, Integer> map = rf.getMap();

        // method to create an object of PrintReport class and

        PrintReport pr = new PrintReport(map);

        // print

        pr.printScreen();

    }

}



class ReadInputFile{



    private Scanner sc;
    private File file;
    private HashMap<String, Integer> map;



    public ReadInputFile() throws FileNotFoundException {



        // path to the file as a parameter
        file = new File("C:\\lekwa-a04\\exercise46\\exercise46_input.txt");
        sc = new Scanner(file);
        map = new HashMap<String,Integer>();

    }

    // function to read file

    public void readfile() {



        try
        {

            while( sc.hasNext() )
            {



                String input = sc.nextLine();



                String arr[] = input.split(" ");

                // for loop

                for(int i=0;i<arr.length;i++) {

                    String key = arr[i];



                    if(map.containsKey(key)) {



                        int value = map.get(key);

                        value++;

                        map.put(key, value);

                    }

                   //else to put in map

                    else {

                        map.put(key, 1);

                    }

                }


            }
        }
        finally
        {
            sc.close();
        }

    }

//   method for return map

    public HashMap<String, Integer> getMap(){

        return map;

    }

}



class PrintReport{



    private HashMap<String, Integer> map;



    public PrintReport( HashMap<String, Integer> map) {



        this.map = map;

    }


    // method for print histogram on screen

    public void printScreen() {

        // declare arrays

        String keys[] = new String[map.size()];

        Integer values[] = new Integer[map.size()];

        int k=0;

        // iterate map

        for (Entry<String, Integer> entry : map.entrySet()) {

            keys[k] = entry.getKey();

            values[k++] = entry.getValue();

        }



        int tempvalues[] = new int[map.size()];

        String tempkeys[] = new String[map.size()];



        for(int i=0;i<values.length;i++) {

            tempvalues[i] = values[i];

        }




        Arrays.sort(values, Collections.reverseOrder());


        // sort keys array according to values array

        for(int i=0; i<map.size();i++) {

            int value = values[i];

            for(int j=0; j<tempvalues.length;j++) {

                if(value == tempvalues[j]) {

                    tempkeys[i] = keys[j];

                    break;

                }

            }

        }

        System.out.println();

        // print the histogram

        for(int i=0;i<map.size();i++) {

            int value = map.get(tempkeys[i]);


            System.out.print(tempkeys[i]+" : \t");


            for(int j=0; j<value; j++) {

                System.out.print("*");

            }

            System.out.println();

        }


    }

}
