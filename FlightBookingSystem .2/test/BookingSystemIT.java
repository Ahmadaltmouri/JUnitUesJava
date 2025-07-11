/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookingSystemIT {

    private BookingSystem instance;

    public BookingSystemIT() {
    }

    @Before
    public void setUp() {
        instance = new BookingSystem();
        instance.addFlight("AI202", "Amman", "Dubai", 2);
        instance.addFlight("AI203", "Amman", "Cairo", 3);
        instance.addPassenger("Ismail Jaber", "12345");
        instance.addPassenger("Mohammad Adnan", "67890");
    }

    @After
    public void tearDown() {
        instance = null;
    }


    @Test
    public void testBookFlightWhenNoSeatsAvailable() {
        System.out.println("testBookFlightWhenNoSeatsAvailable");

       
        instance.addFlight("AI206", "Amman", "London", 0); 

       
        boolean result = instance.bookFlight("AI206", "12345");
        assertFalse(result);  
    }


    @Test
    public void testBookFlightForNonExistentPassenger() {
        System.out.println("bookFlightForNonExistentPassenger");

     
        boolean result = instance.bookFlight("AI202", "nonexistent");
        assertFalse(result); 
    }




   
    @Test
    public void testPrintFlights() {
        System.out.println("printFlights");

       
        instance.printFlights();  
    }
}
