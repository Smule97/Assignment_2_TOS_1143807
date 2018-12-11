////////////////////////////////////////////////////////////////////
// [Samuele] [Gardin] [1143807]
////////////////////////////////////////////////////////////////////

package it.unipd.tos;

import it.unipd.tos.business.RestaurantBill;
import it.unipd.tos.business.Total;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TotalTest {

    /**
     * Restituise il totale dell'ordinazione
     */
    @org.junit.Test
    public void TestCalcoloTotaleOdine() {

        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Primi, "Spaghetti alla carbonara", 9.50));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Primi, "Risotto ai porcini", 8.00));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Primi, "Risotto con radicchio", 10.50));
        Total bill = new Total();
        try {
            double tot = bill.getOrderPrice(itemsOrdered);
            assertEquals(28.0, tot, 0.0);
        } catch (RestaurantBillException e) {
            e.getMessage();
        }
    }

    /**
     * Rimuovo pizza meno cara se ordinazione supera 10 pizze
     */
    @org.junit.Test
    public void TestRimuovoPizzaMenoCara() {
        List<MenuItem> itemsOrdered = new ArrayList<>();
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Viennese", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Capricciosa", 6.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Viennese", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Capricciosa", 6.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Capricciosa", 6.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Capricciosa", 6.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 4.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Primi, "Capricciosa", 6.0));
        Total t = new Total();
        try {
            Total bill = new Total();
            double tot = bill.getOrderPrice(itemsOrdered);
            assertEquals((64), tot, 0.0);
        } catch (RestaurantBillException e) {
            e.getMessage();
        }
    }

    /**
     * 5% sconto sul totale se ordinazione supera 100 euro
     */
    @org.junit.Test
    public void TestScontoCinquePercento() {
        List<MenuItem> itemsOrdered = new ArrayList<>();
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Primi, "Capricciosa", 10.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Primi, "Margherita", 10.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Primi, "Capricciosa", 10.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Primi, "Margherita", 10.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Primi, "Capricciosa", 10.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Patatosa", 10.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 10.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 10.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 10.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 10.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Patatosa", 10.0));

        Total bill = new Total();
        try {
            double tot = bill.getOrderPrice(itemsOrdered);
            assertEquals(104.5, tot, 0.0);
        } catch (RestaurantBillException e) {
            e.getMessage();
        }
    }

    @org.junit.Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Ordinazione deve essere <= 20 items
     */
    @org.junit.Test
    public void TestOrdinazioneMinoreVentiItems() throws RestaurantBillException {
        exception.expect(RestaurantBillException.class);
        exception.expectMessage("Order contains > 20 items");

        List<MenuItem> itemsOrdered = new ArrayList<>();
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Pataosa", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Capricciosa", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Capricciosa", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Capricciosa", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Romana", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Romana", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Monti", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Viennese", 4.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Primi, "Viennese", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Romana", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Viennese", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Romana", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Monti", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Funghi", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Funghi", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Romana", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Margherita", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Romana", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Viennese", 5.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Pizze, "Patatosa", 4.0));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.Primi, "Funghi", 5.0));
        Total bill = new Total();
        double tot = bill.getOrderPrice(itemsOrdered);
    }
}