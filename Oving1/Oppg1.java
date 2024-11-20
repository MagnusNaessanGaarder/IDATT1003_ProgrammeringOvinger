package Oving1;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Feilkilde ved denne datasettet i hashmap-et ikke er sortert, resultatene av testdatasettet er imidlertid riktige
 * Jeg kunne også lagd en loop eller en ny metode for at man skal kunne skrive inn flere brukerinputs. Nå stopper den 
 * bare etter en runde.
 * Jeg har heller ingen håndtering av bokstaver når man skal skrive et inn brukerinput
 * Det står også at objektet myObj aldri lukkes, noe jeg ikke helt har skjønt hvordan jeg skal fikse.
 */


//metode som brukes tilnærmet lik en funksjon for testdatasettet
public class Oppg1 {
    
    //unngår void her for å kunne returnere en verdi av metoden 
    static float toCentimeter(float x){
       //Deklarerer variabler for å regne om fra tommer til cm
       float cm = x * 2.54f;
       return cm;
    }
    
    public static void main(String[] args) {
        
        System.out.println("Testdatasett:");
        
        //lager et hashmap med to strengeverdier som skal holde styr på testdata
        HashMap<String, String> testData = new HashMap<String, String>();

        //lager en enkel for-loop for å gå gjennom ulike verdier for tommer og tilsvarende verdier for cm
        for (int i = 0; i < 10; i++) {
            //her legges tommer og cm inn i hashmappet "testData"
            testData.put(i + " tommer", toCentimeter(i) + " centimeter");
        }

        //skriver ut hashmap, samt et linjeskift
        System.out.println(testData +  System.lineSeparator());


        System.out.println("Userinput");

        //bruker en importert klasse "Scanner" og lager et objekt for å hente bruker-input fra terminalen
        Scanner myObj = new Scanner(System.in);
        Float tommer;

        System.out.println("Skriv et antall tommer:");
        //gjør om fra String til Float vha Float.parseFloat() 
        tommer = Float.parseFloat(myObj.nextLine());

        myObj.close();
            
        //sjekker om brukerinput er mindre enn 0. Kan ikke ha en negativ lengde 
        if (tommer < 0) {
            System.out.println("Du må skrive et positivt antall tommer");
            return;
        }

        float cm = tommer * 2.54f;
            
        System.out.println(tommer + " tommer er " + cm + " centimeter.");
    }
}

    