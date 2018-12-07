///////////////////////////////////////////////////////////////////
// [Samuele] [Gardin] [1143807]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

import java.util.List;

public class Total implements RestaurantBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        double toReturn = 0;
        for (MenuItem x : itemsOrdered) {
            toReturn += x.getPrice();
        }
        return toReturn;
    }
}