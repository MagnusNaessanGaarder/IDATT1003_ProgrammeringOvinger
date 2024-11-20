package Oving11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    // Constants representing the different menu choices
    private final int ADD_PROPERTY = 1;
    private final int LIST_ALL_PROPERTIES = 2;
    private final int FIND_PROPERTY = 3;
    private final int CALCULATE_AVERAGE_AREA = 4;
    private final int EXIT = 5;

    private Scanner sc = new Scanner(System.in);

    private final static ArrayList<Property> testPr = new ArrayList<>();
    static {
        testPr.add(new Property(1445, "Gloppen", 77, 631, "", 1017.6, "Jens Olsen"));
        testPr.add(new Property(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen"));
        testPr.add(new Property(1445, "Gloppen", 75, 19, "Fugletun", 650.6, "Evilyn Jensen"));
        testPr.add(new Property(1445, "Gloppen", 74, 188, "", 1457.2, "Karl Ove Bråten"));
        testPr.add(new Property(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Elsa Indregård"));
    }


    final private PropertyRegistry pr = new PropertyRegistry(testPr);


    private String getInput() {
        if (sc.hasNextLine()) {
            return sc.nextLine();
        }
        return "";
    }

    /**
     * Presents the menu for the user, and awaits input from the user. The menu
     * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1.
     * If 0 is returned, the user has entered a wrong value
     */

    private int showMenu()
    {
        int menuChoice;

        System.out.println("\n***** Property Register Application v0.1 *****\n");
        System.out.println("1. Add property");
        System.out.println("2. List all properties");
        System.out.println("3. Search property");
        System.out.println("4. Calculate average area");
        System.out.println("5. Quit");
        System.out.println("\nPlease enter a number between 1 and 9.\n");

        menuChoice = Integer.parseInt(getInput());

        return menuChoice;
    }

    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user,
     * and executing the selected functionality.
     */
    public void start() {
        boolean finished = false;
        // The while-loop will run as long as the user has not selected
        // to quit the application
        sc.reset();
        while (!finished) {
            int menuChoice = this.showMenu();
            switch (menuChoice) {
                case ADD_PROPERTY -> {
                    try {
                        System.out.println("\n---- Add a property ----\n");

                        System.out.println("Enter property Municipality name: ");
                        String muniName = getInput();

                        System.out.println("Enter property Municipality number: ");
                        int muniNum = Integer.parseInt(getInput());

                        System.out.println("Enter property Lot number: ");
                        int lot = Integer.parseInt(getInput());

                        System.out.println("Enter property Section number: ");
                        int section = Integer.parseInt(getInput());

                        System.out.println("Enter area: ");
                        double area = Double.parseDouble(getInput());

                        System.out.println("Enter the name of the property: ");
                        String name = getInput();

                        System.out.println("Enter the name of the owner of the property: ");
                        String ownerName = getInput();

                        Property property = new Property(muniNum, muniName, lot, section, name, area, ownerName);
                        pr.addProperty(property);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a valid number.");
                    }
                }
                case LIST_ALL_PROPERTIES -> {
                    System.out.println("\n---- List all properties ----\n");
                    pr.printAllProperties();
                }
                case FIND_PROPERTY -> {
                    try {
                        System.out.println("\n---- Search property ----\n");
                        System.out.println("Enter a property Municipality number: ");
                        int muniNum = Integer.parseInt(getInput());
                        System.out.println("Enter a property Lot number: ");
                        int lot = Integer.parseInt(getInput());
                        System.out.println("Enter a property Section number: ");
                        int section = Integer.parseInt(getInput());

                        List<Property> foundProperties = pr.searchForProperty(muniNum, lot, section);
                        if (foundProperties.isEmpty()) {
                            System.out.println("No properties found for with identification " + muniNum + "-" + lot + "/" + section + ".");
                        }
                        else {
                            System.out.println("Here are the properties found for with identification " + muniNum + "-" + lot + "/" + section + ":");
                            foundProperties.forEach(property -> System.out.println(property.toString()));
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a valid number.");
                    }
                }
                case CALCULATE_AVERAGE_AREA -> {
                    System.out.println("\n---- Calculate average area ----\n");
                    double averageArea = pr.averageArea();
                    if (averageArea > 0) {
                        String str = "The average area is " + averageArea + "m².";
                        System.out.println(str);
                    }
                    else {
                        System.out.println("No average area found.");
                    }
                }
                case EXIT -> {
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
                    end();
                }
                default -> System.out.println("Unrecognized menu selected..");
            }
        }
    }

    /**
     * closeing the {@link Scanner}
     */
    private void end() {
        sc.close();
    }
}
