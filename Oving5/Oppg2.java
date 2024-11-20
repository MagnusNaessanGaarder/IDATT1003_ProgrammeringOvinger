package Oving5;
import java.util.Scanner;
import java.util.HashMap;

public class Oppg2 {
    
    //skal rense terminalen
    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    
    //henter input fra brukeren med scanner-objektet s
    public static String getInput(Scanner s) {
        String data = "";
        while (s.hasNextLine()) {
            data = s.nextLine();
            return data;
        } 
        return data;
    }
    
    public static void main(String[] args) {
        //lager et scannerobjekt ved start
        Scanner myReader = new Scanner(System.in);
        
        //lokale variabler innenfor main-scopet
        boolean keepRunning = true;

        //genererer et MinRandom objekt rand. Se MinRandom.java
        MinRandom rand = new MinRandom();

        //testdata heltall, sjekker for start- og stopp-verdier nært opp med hverandre
        HashMap<Integer, Integer> testDataHeltall = new HashMap<Integer, Integer>();
        for (int i = 0; i < 50; i++) {
            testDataHeltall.put(i , rand.nesteHeltall(9, 10));
        }
        System.out.println(testDataHeltall);

        //testdata desimaltall, sjekker for start- og stopp-verdier nært opp med hverandre
        HashMap<Integer, Double> testDataDesimaltall = new HashMap<Integer, Double>();
        for (int i = 1; i <= 50; i++) {
            testDataDesimaltall.put(i , rand.nesteDesimaltall(0.998, 0.999));
        }
        System.out.println(testDataDesimaltall);

        //while-løkke som kjører så lenge brukeren ønsker å fortsette
        while (keepRunning) {  
            clearScreen();
            String s = """
            ******************************************************************************
            Velg et alternativ under. Skriv et tall for å velge.

                [1] Få et tilfeldig heltall, med start og sluttverdi.
                [2] Få et tilfeldig desimaltall, med start og sluttverdi.

            """;
            System.out.println(s);

            //henter brukerinput
            int a = Integer.parseInt(getInput(myReader));
            
            //håndtering av brukerinput
            switch (a) {
                //bruker metoden nesteHeltall, hvis a == 1
                case 1 -> {
                    clearScreen();
                    System.out.println("Skriv inn to heltall etter hverandre:\n\n");
                    rand.nesteHeltall(Integer.parseInt(getInput(myReader)), Integer.parseInt(getInput(myReader)));
                }
                //bruker metoden nesteDesimaltall, hvis a == 2
                case 2 -> {
                    clearScreen();
                    System.out.println("Skriv inn to desimaltall etter hverandre:\n\n");
                    rand.nesteDesimaltall(Double.parseDouble(getInput(myReader)), Double.parseDouble(getInput(myReader)));
                }
                //hvis a ikke er 1, eller 2
                default -> { 
                    clearScreen();
                    continue;
                }
            }
            
            //Sjekk om brukeren ønsker å fortsette
            boolean e = true;
            while (e) {
                System.out.println("Vil du fortsette? \"y\" for JA og \"n\" for NEI.");
                String inp = getInput(myReader); 
                
                //hvis inp == "Y" eller "y", fortsett
                if (inp.equals("Y") || inp.equals("y")) {
                    e = false;
                }
                //hvis inp == "N" eller "n", slutt ytre while-loop
                else if (inp.equals("N") || inp.equals("n")) {
                    e = false;
                    keepRunning = false;
                }
                //hvis inp ikke er gyldig.
                else {
                    clearScreen();
                    System.out.printf("\n\"%s\" er ikke en gyldig verdi for valget. Du må skrive enten \"y\" eller \"n\".\n", inp);
                }
            }
            //skal rense terminal ved oppstart
            clearScreen();
        }
        //lukker scanner etter while-løkke
        myReader.close();
    }
}
