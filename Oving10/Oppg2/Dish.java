package Oving10.Oppg2;

public class Dish implements MenuItem {
    final private String name;
    final private Type type;
    final private double price;

    public Dish(String name, Type type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String str = "Class Dish;" + System.lineSeparator();
        str += "Name " + name + ";" + System.lineSeparator();
        str += "type " + type + ";" + System.lineSeparator();
        str += "price " + price + ";" + System.lineSeparator();
        str += System.lineSeparator();
        return str;
    }
}
