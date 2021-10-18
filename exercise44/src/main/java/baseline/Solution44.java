package baseline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution44 {
    private static final Scanner in = new Scanner(System.in);

    private String input() {
        // Prompt the user for input
        System.out.println("What is the product name?");


        return in.nextLine();
    }

    public Inventory readJSON() throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        // Buffered reader for reading Json
        BufferedReader reader = new BufferedReader(new FileReader("exercise44_input.json"));

        Inventory inventory = gson.fromJson(reader, Inventory.class);

        reader.close();


        return inventory;
    }

    private boolean output(Product search) {
        // If statement if the product is not in stock
        if (search == null) {
            System.out.println("Sorry, that product was not found in our inventory. ");
            return false;
        }
       //if statement if the product is in stock
        else {
            System.out.printf("Name: %s%nPrice: %.2f%nQuantity: %d%n", search.getName(), search.getPrice(), search.getQuantity());
            return true;
        }
    }

    public static void main(String[] args) throws IOException
    {
        Solution44 main = new Solution44();

        try
        {

            Inventory currentInventory = main.readJSON();//function to read the json and store it

            while(true)
            {

                String search = main.input();//function to find the product the user inputs

                Product searchedProduct = currentInventory.search(search);

                if(main.output(searchedProduct))
                {
                    break;
                }
            }
        } catch(IOException ioException)
        {
            ioException.printStackTrace();
        }

    }
}

class Inventory
{
    private List<Product> products = new ArrayList<>();

    private void product(String name, double price, int quantity)
    {

        this.products.add(new Product(name, price, quantity));
    }

    public Product search(String name)
    {

        for(Product temp : products)//loop to serch the product names
        {
            if(temp.getName().equals(name))
            {
                return temp;
            }
        }

        return null;
    }


}

class Product
{
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity)
    {
        //  information of  each product
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }
}
