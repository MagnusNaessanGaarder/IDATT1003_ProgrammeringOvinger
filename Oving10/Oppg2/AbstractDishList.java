package Oving10.Oppg2;

import java.util.*;

public abstract class AbstractDishList implements Dishlist {
    ArrayList<Dish> dishList = new ArrayList<>();

    abstract protected void sortOnType();

    @Override
    public void addDish(Dish dish) {
        dishList.add(dish);
    }

    @Override
    public List<Dish> findDish(String name) {
        return dishList.stream()
                .filter(d -> d.getName().equals(name))
                .toList();
    }
}
