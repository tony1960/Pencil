/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pencil;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tonys
 */
public class PriceTest {

    Price instance;

    public PriceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Price();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPriceReduction() {
        System.out.println("priceReduction");
        instance.initCondtions(10);
        Boolean result = instance.priceReduction(9.0F);
        assertTrue("True means activation can occur", result);
    }

       @Test
    public void testPriceReductionUpperBound() {
        System.out.println("priceReductionUpperBound");
        instance.initCondtions(10);
        Boolean result = instance.priceReduction(9.5F);
        assertTrue("True mean activation can occur", result);
    }

    @Test
    public void testPriceReductionFalseHigh() {
        System.out.println("priceReduction");
        instance.initCondtions(10);
        Boolean result = instance.priceReduction(9.6F);
        assertFalse("True mean activation can not occur", result);
    }

    @Test
    public void testPriceReductionLow() {
        System.out.println("priceReductionLowerBound");
        instance.initCondtions(10);

        Boolean result = instance.priceReduction(5.0F);
        assertFalse("True mean activation can not occur", result);
    }

    @Test
    public void testPriceReductionLowerBound() {
        System.out.println("priceReductionLowerBound");
        instance.initCondtions(10);

        Boolean result = instance.priceReduction(7.5F);
        assertTrue("True mean activation can occur", result);
    }
}
