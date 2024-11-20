package Oving10.Oppg2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Menu extends AbstractDishList {
    ArrayList<Dish> dishList;

    public Menu(ArrayList<Dish> list) {
        this.dishList = list;
        sortOnType();
    }

    public Menu(Dish dish) {
        this.dishList = new ArrayList<>();
        this.dishList.add(dish);
        sortOnType();
    }

    public Menu() {
        this.dishList = new ArrayList<>();
        sortOnType();
    }

    public ArrayList<Dish> getDishList() {
        return dishList;
    }

    public List<Dish> findDishType(Type type) {
        return dishList.stream()
                .filter(d -> d.getType().equals(type))
                .toList();
    }

    public double getTotalPrice() {
        return dishList.stream().mapToDouble(Dish::getPrice).sum();
    }

    @Override
    public void addDish(Dish dish) {
        this.dishList.add(dish);
        sortOnType();
    }

    @Override
    protected void sortOnType() {
        this.dishList.sort(Comparator.comparing(Dish::getType));
    }

    @Override
    public List<Dish> findDish(String name) {
        return this.dishList.stream()
                .filter(d -> d.getName().equals(name))
                .toList();
    }

    @Override
    public String toString() {
        String str = "Class Menu;" + System.lineSeparator();
        str += "Content:" + System.lineSeparator();
        for (Dish dish : dishList) {
            str += dish.toString();
        }

        return str;
    }
}