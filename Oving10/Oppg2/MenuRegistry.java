package Oving10.Oppg2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class MenuRegistry{
    ArrayList<Menu> menuList;

    public MenuRegistry() {
        super();
        menuList = new ArrayList<>();
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    public void addMenu(Menu menu) {
        menuList.add(menu);
    }

    public ArrayList<Type> getValidTypes() {
        return new ArrayList<>(Arrays.asList(Type.values()));
    }

    public void addDish(Menu menu, Dish dish) {
        List<Menu> applicableMenu = menuList.stream().filter(m -> m.equals(menu)).toList();
        if (!applicableMenu.isEmpty()) {
            applicableMenu.get(0).addDish(dish);
        }
        else {
            menu.addDish(dish);
            addMenu(menu);
        }
    }

    public List<Dish> findDishType(Type type) {
        final ArrayList<Dish> dishList = new ArrayList<>();
        for (Menu menu : menuList) {
            List<Dish> searchedDish = menu.getDishList().stream()
                    .filter(d->d.getType().equals(type))
                    .toList();

            if (!searchedDish.isEmpty()) {
                dishList.addAll(searchedDish);
            }
        }
        return dishList;
    }

    public List<Dish> findDish(String name) {
        final ArrayList<Dish> dishList = new ArrayList<>();
        for (Menu menu : menuList) {
            List<Dish> searchedDish = menu.findDish(name);

            if (!searchedDish.isEmpty()) {
                dishList.addAll(searchedDish);
            }
        }

        return dishList;
    }

    public double totalPrice (double start, double end) {
        if ((start < 0 || end < 0) && end < start) {
            throw new IllegalArgumentException("Kan ikke ha start- og stop-verdier lavere enn null, eller stop-verdi lavere enn start-verdi.");
        }
        AtomicReference<Double> sum = new AtomicReference<>((double) 0);

        List<Menu> mList = getMenuList().stream().filter(m -> m.getTotalPrice() >= start && m.getTotalPrice() <= end).toList();
        if (!mList.isEmpty()) {
            mList.forEach(m -> {
                System.out.println(m.toString());
                sum.updateAndGet(v -> (v + m.getTotalPrice()));
            });
        }

        return sum.get();
    }

    public String toStringType(ArrayList<Dish> list) {
        String str = "";
        for (Menu menu : menuList) {
            str += "Class Menu;" + System.lineSeparator();
            str += "Content:" + System.lineSeparator();
            for (Dish dish : list) {
                str += dish.toString();
            }
        }
        return str;
    }

}
