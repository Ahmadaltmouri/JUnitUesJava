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

public class PassengerIT {

    private Passenger instance;

    public PassengerIT() {
    }

    @Before
    public void setUp() {
        instance = new Passenger("Ismail Jaber", "12345");
    }

    @After
    public void tearDown() {
        instance = null;
    }

   
    @Test
    public void testGetName() {
        System.out.println("getName");

        String expResult = "Ismail Jaber";
        String result = instance.getName();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetPassportNumber() {
        System.out.println("getPassportNumber");

        String expResult = "12345";
        String result = instance.getPassportNumber();
        assertEquals(expResult, result);
    }

  
    @Test
    public void testGetNameCaseSensitivity() {
        System.out.println("testGetNameCaseSensitivity");

        instance = new Passenger("john doe", "12345");

        assertEquals("john doe", instance.getName());
    }
}
