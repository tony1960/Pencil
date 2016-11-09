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

    /*
    @Test
    public void testPriceReduction() {
        System.out.println("priceReduction");
        instance.initCondtions(10, 31);
        Boolean result = instance.priceReduction(9.0F);
        assertTrue("True means activation can occur", result);
    }

    @Test
    public void testPriceReductionUpperBound() {
        System.out.println("priceReductionUpperBound");
        instance.initCondtions(10, 31);
        Boolean result = instance.priceReduction(9.5F);
        assertTrue("True mean activation can occur", result);
    }

    @Test
    public void testPriceReductionFalseHigh() {
        System.out.println("testPriceReductionFalseHigh");
        instance.initCondtions(10, 31);
        Boolean result = instance.priceReduction(9.6F);
        assertFalse("True mean activation can not occur", result);
    }

    @Test
    public void testPriceReductionLow() {
        System.out.println("priceReductionLowerBound");
        instance.initCondtions(10, 31);

        Boolean result = instance.priceReduction(5.0F);
        assertFalse("True mean activation can not occur", result);
    }

    @Test
    public void testPriceReductionLowerBound() {
        System.out.println("testPriceReductionLowerBound");
        instance.initCondtions(10, 31);

        Boolean result = instance.priceReduction(7.5F);
        assertTrue("True mean activation can occur", result);
    }

    @Test
    public void testPriceReductiomDaysStable() {
        System.out.println("testPriceReductiomDaysStable");

        instance.initCondtions(10, 31);

        Boolean result = instance.priceReduction(8.5F);
        assertTrue("True mean activation can occur ", result);
    }

    @Test
    public void testPriceReductiomDaysStableFewer() {
        System.out.println("testPriceReductiomDaysStableFewer");

        instance.initCondtions(10, 29);

        Boolean result = instance.priceReduction(8.5F);
        assertFalse("True mean activation can not occur ", result);
    }

    @Test
    public void testCheckPromotion() {
        System.out.println("testCheckPromotion");
        Boolean expectedValue = true;
        instance.initCondtions(10, 29);

        Boolean valid = instance.promotionStillValid();
        assertTrue("True mean promotion is still valid", valid);
    }

    @Test
    public void testCheckPromotionFalse() {
        System.out.println("testCheckPromotionFalse");
        Boolean expectedValue = true;
        instance.initCondtions(10, 31);
        Boolean valid = instance.promotionStillValid();
        assertFalse("True mean promotion is not valid", valid);
    }

    @Test
    public void testPriceFurtherReduction() {
        System.out.println("testPriceFurtherReduction");
        instance.initCondtions(9, 29);
        int ExpectedValue = 1;
        Boolean result = instance.priceReduction(8.0F);
        int promotionDays = instance.daysRemaining();
        assertEquals(ExpectedValue, promotionDays);
    }

    @Test
    public void testPriceIncrease() {
        System.out.println("testPriceIncrease");
        instance.initCondtions(9, 29);
        Float expectedValue = 0F;
        instance.priceIncrease(11.0F);
        Float reductedPrice = instance.getReducedPrice();
        Boolean reducted = false;
        if (expectedValue.compareTo(reductedPrice) == 0) {
            reducted = true;
        }
        assertTrue("ReductedPrice is reset", reducted);
    }

    
    */
    
    
    @Test
    public void testPriceFurtherReductionLow() {
        System.out.println("testPriceFurtherReductionLow");
        instance.initCondtions(9.0F, 31);

        Float expectedValue = 9.0F;
        Boolean result = instance.priceReduction(8.0F);
        
        result = instance.priceReduction(1.0F);

        Boolean priceResult = false;
        Float price = instance.getCurrentPrice();
        if (expectedValue.compareTo(price) == 0) {
            priceResult = true;
        }
        int expectedDays  = 0;
        int days = instance.getDaysStable();
        assertEquals(expectedDays, days);
        assertTrue("ReductedPrice is reset", priceResult);
    }
    
    @Test
    public void testSetNewPromotion (){
        
        
    }

}
