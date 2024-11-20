package Oving11;

/**
 * {@code Municipality} - An abstract and immutable class storing information about Municipalities. This class is abstract to create abstraction
 * and would in that regard hide complexity from the user. It's also immutable with constant datafields and get-methods for access to the variables.
 * The class also uses Encapsulation and Inheritance to create Object-oriented code.<br><br>
 * {@link Municipality#mNumber mNumber} - An integer representing the Municipality number.<br>
 * {@link Municipality#mName mName} - A String representing the name of the Municipality.
 */
public abstract class Municipality {
    /**
     *Datafield for the abstract class {@link Municipality}<br>
     *{@code mNumber} - An integer representing the Municipality number.
     */
    final private int mNumber;

    /**
     *Datafield for the abstract class {@link Municipality}<br>
     *{@code mName} - A String representing the name of the Municipality.
     */
    final private String mName;

    Municipality(int number, String name) {
        this.mNumber = number;
        this.mName = name;
    }

    /**
     * @return Returns the {@code mNumber} representing the Municipality number.
     */
    public int getMunicipalityNumber() {
        return this.mNumber;
    }

    /**
     * @return Returns the {@code mName} representing the Municipality name.
     */
    public String getMunicipalityName() {
        return this.mName;
    }
}
