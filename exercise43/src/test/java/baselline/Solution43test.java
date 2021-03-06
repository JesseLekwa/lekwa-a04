package baselline;

import baseline.websiteGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Solution43test {
    @Test
    void createWebsite_works() {

//Use the function and save the return value.
        websiteGenerator wg = new websiteGenerator();

        wg.path = "src/main/java/ex43/";
        wg.siteName = "test.com";
        wg.author = "Jesse lekwa";

        String expected = "src/main/java/ex43/testwebsite.com";
        String actual = wg.createWebsite();

//Compare with the expected return value.
        assertEquals(expected, actual);

    }
}
