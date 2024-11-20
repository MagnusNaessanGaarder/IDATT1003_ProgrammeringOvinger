package Oving10.Oppg1;

import java.util.List;
import java.util.Scanner;

public class Menu {
    final private static Scanner myReader = new Scanner(System.in);
    private static StringBuilder str = new StringBuilder();
    private static boolean running = true;

    private final static ArrangementRegister ar = new ArrangementRegister();

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

    /**
     * @param userInput brukerinput av verdi String.
     */
    public static void menuOption(int userInput) {
        clearScreen();
        switch (userInput) {
            //legg til arrangementer
            case 1 -> addArrangement();

            //arrangementer på et sted
            case 2 -> displayLocationArr();

            //arrangementer på dato
            case 3 -> displayDateArr();

            //Arrangementer tidsintevall
            case 4 -> displayTimeIntervalArr();

            //Arrangementer sted, type og tidspunkt
            case 5 -> sortedList();

            //Arrangementer sted, type og tidspunkt
            case 6 -> stop();

            default -> System.err.println("Input er ugyldig. Brukerinputen må være i intervallet [1,6].");
        }
    }

    public static void addArrangement() {
        System.out.println("Hva heter arrangementet?");
        String name  = getInput();

        System.out.println("Hvor er arrangementet?");
        String location = getInput();

        System.out.println("Hvem er det som arrangerer?");
        String arranger = getInput();

        System.out.println("Når er arrangementet? (YYYYMMDDHHMM)");
        int time = Integer.parseInt(getInput());

        System.out.println("Hva slags arrangement er det");
        String type = getInput().toUpperCase();
        Type arrangement;
        if (!ar.getValidTypes().contains(Type.valueOf(type))){
            return;
        }
        else {
            arrangement = Type.valueOf(type);
        }

        ar.newArrangement(new Arrangement(name, location, arranger, arrangement, time));

    }

    public static void displayLocationArr() {
        clearScreen();
        str = new StringBuilder();

        final String menuStr = Table.createMenuTable("ARRANGEMENTER - STED", "Sett inn sted under:");
        str.append(menuStr);


        if (ar.getList().isEmpty()) {
            str.append("            --- Ingen arrangementer er lagt til for øyeblikket ---");
            System.out.println(str);
        }
        else {
            System.out.println(str);

            System.out.print("Skriv et sted: ");
            String sted = getInput();

            List<Arrangement> dateList = ar.arangementsLocationList(sted);

            str.append(Display.menuList(dateList, "Fant ingen arrangementer")).append("\n");
            clearScreen();
            System.out.println(str);
        }
        escape();
    }

    public static void displayDateArr() {
        clearScreen();
        str = new StringBuilder();

        final String menuStr = Table.createMenuTable("ARRANGEMENTER - DATO", "Sett inn dato under:");
        str.append(menuStr);


        if (ar.getList().isEmpty()) {
            str.append("            --- Ingen arrangementer er lagt til for øyeblikket ---");
            System.out.println(str);
        }
        else {
            System.out.println(str);

            System.out.print("Skriv en dato: ");
            int date = Integer.parseInt(getInput());

            List<Arrangement> dateList = ar.arangementsDateList(date);

            str.append(Display.menuList(dateList, "Fant ingen arrangementer")).append("\n");
            clearScreen();
            System.out.println(str);
        }
        escape();
    }

    public static void displayTimeIntervalArr() {
        clearScreen();
        str = new StringBuilder();

        final String menuStr = Table.createMenuTable("ARRANGEMENTER - TIDSINTERVAL", "Sett inn tidsintervaller under:");
        str.append(menuStr);


        if (ar.getList().isEmpty()) {
            str.append("            --- Ingen arrangementer er lagt til for øyeblikket ---");
            System.out.println(str);
        }
        else {
            System.out.println(str);

            System.out.print("Skriv en Startdato: ");
            int date1 = Integer.parseInt(getInput());
            System.out.print("Skriv en Startdato :");
            int date2 = Integer.parseInt(getInput());

            List<Arrangement> intervalList = ar.arangementsTimeList(date1, date2);

            str.append(Display.menuList(intervalList, "Fant ingen arrangementer")).append("\n");
            clearScreen();
            System.out.println(str);
        }

        escape();
    }

    public static void sortedList() {
        clearScreen();
        str = new StringBuilder();

        final String menuStr = Table.createMenuTable("SORTERT LISTE", "Under er en liste med sorterte eksisterende arrangementer etter sted, arrangement-type og tidspunkt:");
        str.append(menuStr);

        if(ar.getList().isEmpty()) {
            str.append("            --- Ingen arrangementer er lagt til for øyeblikket ---");
        }
        else {
            str.append(Display.menuList(ar.sortLocationTypeDate(ar.getList()), "Fant ingen arrangementer")).append("\n");
        }

        System.out.println(str);
        escape();
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
        Arrangement arr1 = new Arrangement("Fabelaktig Sirkus", "Trondheim", "Sigurd", Type.SIRKUS, 202002211830L);
        Arrangement arr2 = new Arrangement("Abakus Sirkus", "Trondheim", "Sigve", Type.SIRKUS, 202405171945L);
        Arrangement arr3 = new Arrangement("EttEllerAnnet", "Oslo", "Test", Type.FESTIVAL, 202412030126L);
        Arrangement arr4 = new Arrangement("Festival2", "Oslo", "Sigurd", Type.FESTIVAL, 200001302000L);
        Arrangement arr5 = new Arrangement("Ett eller annet", "Hole", "Magnus", Type.UTSTILLING, 20210860515L);
        Arrangement arr6 = new Arrangement("Bob Marley", "Trondheim", "KonsertFirma", Type.KONSERT, 202411131359L);

        //tester å legge til i arrangementregiseteret
        ar.newArrangement(arr1);
        ar.newArrangement(arr2);
        ar.newArrangement(arr3);
        ar.newArrangement(arr4);
        ar.newArrangement(arr5);
        ar.newArrangement(arr6);

        while (running) {
            // Menyvalg i konsollen
            clearScreen();
            str = new StringBuilder();

            final String menuStr = Table.createMenuTable("HOVEDMENY - ARRANGEMENTER", "Liste med tilgjengelige varer");
            str.append(menuStr);
            str.append(Display.menuList(ar.getList(), "Fant ingen arrangementer")).append("\n");

            str.append("            Velg fra listen nedenfor:").append("\n\n");

            str.append("                   [1] Legg til arrangement.\n");
            str.append("                   [2] Finn arrangementer på et sted.\n");
            str.append("                   [3] Finn arrangementer på en gitt dato.\n");
            str.append("                   [4] Finn arrangementer på et tidsintervall.\n");
            str.append("                   [5] Finn arrangementer sortert på sted, type og tidspunkt.\n");
            str.append("                   [6] Avslutt.\n");
            System.out.println(str);

            try {
                int userInput = Integer.parseInt(getInput());
                menuOption(userInput);
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
