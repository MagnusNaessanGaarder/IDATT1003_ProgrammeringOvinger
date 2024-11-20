package Oving10.Oppg2;

import Oving10.Oppg1.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TestClient {
    final private static Scanner myReader = new Scanner(System.in);
    private static StringBuilder str = new StringBuilder();
    private static boolean running = true;

    private final static MenuRegistry mr = new MenuRegistry();
    private final static Menu menu1 = new Menu();
    private final static Menu menu2 = new Menu();

    /**
     * @return en tekststreng som velges av en {@code Scanner}
     * som her er kalt {@code myReader}. Metoden {@code .nextLine()} returnerer
     * en tekststreng av brukerens input ved linjeskift.
     *
     */
    private static String getInput() {
        if (myReader.hasNextLine()) {
            return myReader.nextLine();
        }
        return "";
    }

    /**
     *Clears screen in terminal.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void test() {
        System.out.println("LEGG TIL EN RETT\n\n");
        System.out.println("Hva heter retten?");
        String name  = getInput();

        System.out.println("Hva er prisen på retten?");
        double price = Double.parseDouble(getInput());

        System.out.println("Hva slags rett er det?");
        String typeStr = getInput().toUpperCase();
        Type type;

        if (!mr.getValidTypes().contains(Type.valueOf(typeStr))){
            return;
        }
        else {
            type = Type.valueOf(typeStr);
        }

        Menu menu3 = new Menu();
        mr.addDish(menu3, new Dish(name, type, price));
        System.out.println(menu3.toString());


        System.out.println("Test søk på rett vha navn:\n");
        String testSearch1 = "Pasta Carbonara";
        testSearch(testSearch1);

        String testSearch2 = "Mac and Cheese";
        testSearch(testSearch2);

        System.out.println("\n\nTest av henting av retter utifra type:\n");
        System.out.println("Forretter:");
        Type type1 = Type.FORRETT;
        testSearchType(type1);

        System.out.println("Hovedretter:");
        Type type2 = Type.HOVEDRETT;
        testSearchType(type2);

        System.out.println("Desserter:");
        Type type3 = Type.DESSERT;
        testSearchType(type3);

        System.out.println("Test av legge til meny med flere retter:\n");
        final Dish dish1 = new Dish("Bønnesuppe", Type.FORRETT, 17);
        final Dish dish2 = new Dish("Pasta Bolognese", Type.HOVEDRETT, 120);
        final Dish dish3 = new Dish("Ostetallerken", Type.DESSERT, 230);
        ArrayList<Dish> dishList = new ArrayList<>();
        dishList.add(dish1);
        dishList.add(dish2);
        dishList.add(dish3);

        Menu menu4 = new Menu(dishList);
        mr.addMenu(menu4);
        System.out.println(menu4.toString());

        System.out.println("Test av Totalpris:\n");
        System.out.println(mr.totalPrice(392,394)); // skal skrive ut meny 4 hvis den funker
    }

    public static void testSearch(String testSearch) {
        ArrayList<Dish> dish = (ArrayList<Dish>) mr.findDish(testSearch);
        if(dish.isEmpty()) {
            System.out.println("Retten " + testSearch + " finnes ikke i en meny.");
        }
        else {
            System.out.println("Retten " + testSearch + " er lagt til i en meny.");
        }
    }

    public static void testSearchType(Type testType) {
        ArrayList<Dish> type = (ArrayList<Dish>) mr.findDishType(testType);
        if(type.isEmpty()) {
            System.out.println("Ingen retter av typen" + testType + " eksisterer i en meny.");
        }
        else {
            System.out.println(mr.toStringType(type));
        }
    }


    public static void escape() {
        while (true) {
            String userInput = getInput();
            if (userInput.equals("-e") || userInput.isEmpty()) {
                break;
            }
        }
    }

    public static void stop() {
        running = false;
        myReader.close();
    }

    public static void main(String[] args) {
        //testarrangementer
        final Dish dish1 = new Dish("Kyllingsalat", Type.FORRETT, 49.50);
        final Dish dish2 = new Dish("Tapas", Type.FORRETT, 90);
        final Dish dish3 = new Dish("Bifftallerken", Type.HOVEDRETT, 249.90);
        final Dish dish4 = new Dish("Pasta Carbonara", Type.HOVEDRETT, 149.50);
        final Dish dish5 = new Dish("Lavakake", Type.DESSERT, 93.50);
        final Dish dish6 = new Dish("Créme Brulèe", Type.DESSERT, 60);


        menu1.addDish(dish5);
        menu1.addDish(dish1);
        menu1.addDish(dish3);

        menu2.addDish(dish2);
        menu2.addDish(dish4);
        menu2.addDish(dish6);

        mr.addMenu(menu1);
        mr.addMenu(menu2);

        while (running) {
            // Menyvalg i konsollen
            clearScreen();
            str = new StringBuilder();

            final String menuStr = Table.createMenuTable("TESTKLIENT", "Test av alle metodene til MenyRegister");
            str.append(menuStr);
            str.append(DisplayMenu.displayMenuList(mr.getMenuList())).append("\n");

            System.out.println(str);

            test();

            escape();
            stop();
        }
    }
}
