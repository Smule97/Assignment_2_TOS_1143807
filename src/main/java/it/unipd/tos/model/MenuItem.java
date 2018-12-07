///////////////////////////////////////////////////////////////////
// [Samuele] [Gardin] [1143807]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
    private enum itemType{
        Pizze,
        Primi;
    }

    itemType type;

    String name;

    double price;

    public MenuItem(itemType type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getType() {
        return type.toString();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}