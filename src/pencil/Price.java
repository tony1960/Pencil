/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pencil;

/**
 *
 * @author tonys
 */
public class Price {

    float price;
    float reducedPrice;
    int daysStable;

    /**
     * Sets initial conditions
     *
     *
     * @param price The orig price of the item
     * @return true if the, otherwise false
     */
    public void initCondtions(float price, int daysStable) {
        this.price          = price;
        this.daysStable     = daysStable;
    }

    /**
     * Checks price reduction for validity
     *
     *
     * @param reducedPrice The new reduced price
     * @return true if activation is allowed , otherwise false
     */
    public Boolean priceReduction(Float reducedPrice) {

        Float high;
        Float low;
        high = price * .95F;
        low = price * .70F;

        if (reducedPrice.compareTo(low) < 0) {
            return false;
        }

        if (reducedPrice.compareTo(high) > 0) {
            return false;
        }

        if (daysStable < 30) {
            return false;
        }
        
        return true;
    }
    
    public Boolean promotionStillValid() {

        if (daysStable > 30) {
            return false;
        }
        return true;
    }
    
      /**
     *   Days remaining
     *
     *
     * @return  number of days remaining in the promotion
     */
    public int daysRemaining() {

        return 30 - daysStable;
    }


public void priceIncrease  (float price){
    reducedPrice = 0.0F;
}  


public float getReducedPrice(){
    return reducedPrice;
}
}

