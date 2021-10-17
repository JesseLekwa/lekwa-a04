package baseline;

import java.io.File;
import java.util.Scanner;

public class Solution43 {
    public static void main(String[] args) {

//Input
        Scanner newScan = new Scanner(System.in);

        String siteName;
        String author;
        String wantCSS;
        String wantJS;

        System.out.print("Site name: ");
        siteName = newScan.nextLine();
        System.out.print("Author: ");
        author = newScan.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        wantJS = newScan.nextLine();
        System.out.print("Do you want a folder for CSS? ");
        wantCSS = newScan.nextLine();



        websiteGenerator newWebsite = new websiteGenerator();//Create a website generator


        newWebsite.siteName = siteName;//Set the attributes for the website
        newWebsite.author = author;
        newWebsite.path = "src/main/java/ex43/";


        System.out.println("Created " + newWebsite.createWebsite());
        System.out.println("Created " + newWebsite.createHTMl());


        if(wantJS.equals("y"))
            System.out.println("Created " + newWebsite.createJSFolder());

        if(wantCSS.equals("y"))
            System.out.println("Created " + newWebsite.createCSSFolder());

    }

}
