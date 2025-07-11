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

public class FlightIT {

    private Flight instance;

    public FlightIT() {
    }

    @Before
    public void setUp() {
        instance = new Flight("AI202", "Amman", "Dubai", 2);
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testBookSeat() {
        boolean result = instance.bookSeat();
        assertTrue(result); 
        assertEquals(1, instance.getAvailableSeats()); 

        instance.bookSeat(); 
        result = instance.bookSeat(); 
        assertFalse(result); 
        assertEquals(0, instance.getAvailableSeats()); 
    }

    @Test
    public void testAvailableSeatsDecrementAfterBooking() {
        assertEquals(2, instance.getAvailableSeats()); 
        instance.bookSeat();
        assertEquals(1, instance.getAvailableSeats()); 
        instance.bookSeat();
        assertEquals(0, instance.getAvailableSeats()); 
    }

    @Test
    public void testBookFlightWithOneSeatAvailable() {
        assertEquals(2, instance.getAvailableSeats());

        boolean result1 = instance.bookSeat();
        assertTrue(result1);  
        assertEquals(1, instance.getAvailableSeats());  

        boolean result2 = instance.bookSeat();
        assertTrue(result2);  
        assertEquals(0, instance.getAvailableSeats());  
    }

    @Test
    public void testGetFlightNumber() {
        String expResult = "AI202";
        String result = instance.getFlightNumber();
        assertEquals(expResult, result);
    }
}
