///////////////////////////////////////////////////////////////////
// [Samuele] [Gardin] [1143807]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;


public class RestaurantBillException extends Throwable {

    public RestaurantBillException()
    {
        super("Order contains > 20 items");
    }

}