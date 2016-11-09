/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pencil;

/**
 * This object maintains price & the reduced Price. Its most of its methods
 * return true or false depending on if a red pencil price reduction and take
 * place.
 *
 * @author tonys
 */
public class Price {

    private float price;
    private float reducedPrice;
    private int daysStable;

    /**
     * Sets initial conditions
     *
     *
     * @param price The orig price of the item
     * @param daysStable The number of days at this price or reduced prise
     * @return true if the, otherwise false
     */
    public void initCondtions(float price, int daysStable) {
        this.price = price;
        this.daysStable = daysStable;
    }

    /**
     * Checks price reduction for validity
     * Price is valid if is reduced by at least  5% but at most 30% and 
     * The price has been stable at least 30 days.
     * Promotions last for 30 days
     * Further promotion don't extend time
     * If and additional promotion reduces price to less than 30% promotion is
     * canceled
     * 
     * 
     * 
     * @return true if activation is allowed , otherwise false
     */
    public Boolean priceReduction(Float reducedPrice) {

        Float high;
        Float low;
        high = price * .95F;
        low = price * .70F;

        if (reducedPrice.compareTo(low) < 0) {

            if (this.reducedPrice > 0) {
                this.reducedPrice = 0.0F;
                daysStable = 0;
            }
            return false;
        }

        if (reducedPrice.compareTo(high) > 0) {
            return false;
        }

        if (daysStable < 30) {
            return false;
        }

        this.reducedPrice = reducedPrice;
        return true;
    }

    /**
     * promotionStillValid true
     *
     *
     * @return true if the reduced price is still valid, otherwise false
     */
    public Boolean promotionStillValid() {

        if (daysStable > 30) {
            return false;
        }
        return true;
    }

    /**
     * Days remaining
     *
     *
     * @return number of days remaining in the promotion
     */
    public int daysRemaining() {

        return 30 - daysStable;
    }

    /**
     * PriceIncrease
     * Price is increase and promotion is canceled
     *  Days at stable price reset
     * @param New Price
     */
    public void priceIncrease(float price) {

        this.price = price;
        reducedPrice = 0.0F;
        daysStable = 0;
    }

    /**
     * getReducedPrice
     *
     * @return reduced price
     */
    public float getReducedPrice() {
        return reducedPrice;
    }

    /**
     * getPrice
     * Testing aid
     * @return current price
     */
    public float getCurrentPrice() {
        if ((reducedPrice > 0) && (daysStable <= 30)) {
            return reducedPrice;
        }

        return price;
    }

    /**
     * getPrice
     * Testing aid
     * @return price
     */
    
    public float getPrice() {

        return price;
    }
    
    /**
     * getDaysStable
     * Testing aid
     * @return daysStable
     */

    public int getDaysStable() {
        return daysStable;
    }

    
    /**
     * setSaysStable
     * @parem  daysStable
     * Testing aid
     */
    public void setDaysStable(int daysStable) {
        if (daysStable > 30) {
            reducedPrice = 0.0F;
        }
        this.daysStable = daysStable;
    }
}
