package Oving11;

/**
 * {@code Property} - Represents a Property, and stores according values. Uses Inheritance from both the
 * abstract class {@link Municipality} and the interface {@link GloppenProperty} to create layers of abstraction.
 * Also uses Encapsulation with public set- and get-methods.<br><br>
 * {@code lotNum} - A constant {@code int} representing the lot number of the Property.<br>
 * {@code sectionNum} - A constant {@code int} representing the section number of the Property.<br>
 * {@code name} - A constant {@link String} representing the section number of the Property.<br>
 * {@code area} - A {@code double} (64-bit floating number) representing the area of the Property in square meters (m²).<br>
 * {@code ownerName} - A {@link String} representing the name of the owner of the Property.<br>
 */
public class Property extends Municipality implements GloppenProperty {
    final private int lotNum;
    final private int sectionNum;
    final private String name;
    private double area;//in m²
    private String ownerName;


    public Property(int mNumber, String mName, int lot, int section, String name, double area, String ownerName) {
        super(mNumber, mName);

        if (!checkValidMunicipality(mNumber)) {
            throw new IllegalArgumentException("");
        }

        this.lotNum = lot;
        this.sectionNum = section;
        this.name = name;
        this.area = area;
        this.ownerName = ownerName;

    }

    /**
     * A method checking the validity of a given municipality number.
     * @param num Supposed to represents the Municipality number that is being checked.
     * @return A boolean value. Returns true if the given Municipality number is between
     * {@link GloppenProperty#MN_START MN_START} and {@link GloppenProperty#MN_END MN_END}.
     */
    @Override
    public boolean checkValidMunicipality(int num) {
        return num >= GloppenProperty.MN_START && num <= GloppenProperty.MN_END;
    }

    /**
     * {@code getMunicipalityName()} - A get-method for the municipality name.
     * @return A {@link String} value. The String is supposed to represent the name of the municipality.
     */
    @Override
    public String getMunicipalityName() {
        return super.getMunicipalityName();
    }

    /**
     * {@code getMunicipalityNumber()} - A get-method for the municipality number.
     * @return A {@link String} value. The String is supposed to represent the name of the municipality.
     */
    @Override
    public int getMunicipalityNumber() {
        return super.getMunicipalityNumber();
    }

    /**
     * @return A string of the {@code Property} objects properties.
     */
    @Override
    public String toString() {
        String str = "    Klasse Property;" + System.lineSeparator();
        str += "        Kommunenummer, Gårdsnummer og bruksnummer: " + formatPropertyNums() + ";" +  System.lineSeparator();
        str += "        Navn på kommune: " + this.getMunicipalityName() + ";" + System.lineSeparator();
        str += "        Bruksnavn " + this.name + ";" + System.lineSeparator();
        str += "        Areal i m²: " + this.area + ";" + System.lineSeparator();
        str += "        Eier: " + this.ownerName + ";" + System.lineSeparator();

        return str;

    }

    /**
     * {@code getLotNum()} - Get-method for the lot number of the Property object.<br>
     * @return The datafield {@code lotNum}.
     */
    public int getLotNum() {
        return lotNum;
    }

    /**
     * {@code getSectionNum()} - Get-method for the lot number of the Property object.<br>
     * @return The datafield {@code sectionNum}.
     */
    public int getSectionNum() {
        return sectionNum;
    }

    /**
     * {@code getName()} - Get-method for the name of the Property object.<br>
     * @return The datafield {@code name}.
     */
    public String getName() {
        return name;
    }

    /**
     * {@code getArea()} - Get-method for the area of the Property object in square meters (m²).<br>
     * @return The datafield {@code area}.
     */
    public double getArea() {
        return area;
    }

    /**
     * {@code setArea()} - Set-method for the area of the Property object in square meters (m²).
     * Sets the datafield {@code area} to the new value {@code area}<br>
     * @param area A {@code double}-floatingpoint representing a new area in square meters (m²).
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * {@code getOwnerName()} - Get-method for the name of the owner of the Property object.<br>
     * @return The datafield {@code ownerName}.
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * {@code setOwnerName()} - Set-method for the name of the owner of the Property object.
     * Sets the datafield {@code ownerName} to the new value {@code ownerName}<br>
     * @param ownerName A {@link String} representing the new name of the owner.
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * {@code formatPropertyNums()} - Get-method for the formated {@link String} of "Municipality number-Lot number/Section number".<br>
     * @return The formated String.
     */
    public String formatPropertyNums() {
        return STR."\{this.getMunicipalityNumber()}-\{this.lotNum}/\{this.sectionNum}";
    }

}
