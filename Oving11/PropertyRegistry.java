package Oving11;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code PropertyRegistry} - A Class to organize Property-Objects in an {@link ArrayList}<br><br>
 * {@code propertyList} - A list of type {@link ArrayList} containing Property objects. The list in an ArrayList
 * to make it more flexible for adding or removing Objects from the list, instead of an Array of fixed length.
 * Although more flexible, an ArrayList also takes more space in the computer's memory.
 */
public class PropertyRegistry {
    private final ArrayList<Property> propertyList;

    //constructor for no passed argument.
    public PropertyRegistry() {
        propertyList = new ArrayList<>();
    }

    //constructor for single Property objects passed as a parameter
    public PropertyRegistry(Property p) {
        propertyList = new ArrayList<>();
        propertyList.add(p);
    }

    //constructor for multiple Property objects stored in an ArrayList. Passed as a parameter.
    public PropertyRegistry(ArrayList<Property> propertyList) {
        this.propertyList = propertyList;
    }

    /**
     * {@code addProperty()} - Method for adding a {@link Property} to the {@link ArrayList} containing Property objects, {@code propertyList}.
     * @param p An object of type {@link Property}.
     */
    public void addProperty(Property p) {
        propertyList.add(p);
    }

    /**
     * {@code printAllProperties} - Prints all {@code Property}-objects in the {@link ArrayList}, {@code propertyList}
     */
    public void printAllProperties() {
        this.propertyList.forEach(p -> System.out.println(p.toString()));
    }

    /**
     * {@code searchForProperties} - Method for searching after a specified {@code Property}, based on the given
     * Municipality number, lot number and section number. These numbers are then formated and compared to a list.
     * The search is done through the {@link ArrayList} {@code propertyList} which stores {@code Property} objects.<br>
     * @param muniNum Parameter representing the Municipality number.
     * @param lot Parameter representing the Lot number.
     * @param section Parameter representing the Section number.
     * @return A {@link List} of all {@code Property} objects passing the search-conditions.
     */
    public List<Property> searchForProperty(int muniNum, int lot, int section) {
        final String inFormat = muniNum + "-" + lot + "/" + section;
        return this.propertyList.stream()
                .filter(p -> p.formatPropertyNums().equals(inFormat))
                .toList();
    }

    /**
     * {@code searchForProperties} - Method for searching after a specified {@code Property}, based on the given lot number.
     * This number are then compared to a list.
     * The search is done through to the {@link ArrayList} {@code propertyList} which stores {@code Property} objects.<br>
     * @param lot Parameter representing the Lot number.
     * @return A {@link List} of all {@code Property} objects passing the search-conditions.
     */
    public List<Property> searchForProperty(int lot) {
        return this.propertyList.stream()
                .filter(p -> p.getLotNum() == lot)
                .toList();
    }

    /**
     * {@code averageArea} - Creates a sum of all the {@code Property} object's areas in the {@code propertyList}
     * using a {@link ArrayList#stream() stream()}. The sum is the checked if is equal or lower than zero. In that
     * case, 0 is returned. Zero will also be returned if the propertyList is empty to avoid any {@link Exception}
     * when dividing by zero.
     *
     * @return A formatted {@code double} with 2 digits.
     */
    public double averageArea() {
        double sum = this.propertyList.stream()
                .mapToDouble(Property::getArea)
                .sum();

        if (propertyList.isEmpty() || sum <= 0) {
            return 0;
        }

        return (double) Math.round((sum / propertyList.size()) * 100) / 100;
    }

    /**
     * @return A {@code String} of the class and it's content.
     */
    @Override
    public String toString() {
        String str = "Klasse PropertyRegister" + System.lineSeparator();
        str += "    Innhold:" + System.lineSeparator();
        for (Property p : propertyList) {
            str += p.toString();
        }

        return str;
    }

}
