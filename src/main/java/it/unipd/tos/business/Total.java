///////////////////////////////////////////////////////////////////
// [Samuele] [Gardin] [1143807]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

import java.awt.*;
import java.util.List;

public class Total implements RestaurantBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        double toReturn = 0, minPricePizza=0, contPizze=0;

        for (MenuItem x : itemsOrdered) {
            if(x.getType() == "Pizze"){
                contPizze++;
                if(x.getPrice() < minPricePizza)
                    minPricePizza = x.getPrice();
            }
            toReturn += x.getPrice();
        }

        if(contPizze > 10)
            toReturn -= minPricePizza;

        if(toReturn > 100)
            toReturn = toReturn - (toReturn/100*5);

        return toReturn;
    }
}