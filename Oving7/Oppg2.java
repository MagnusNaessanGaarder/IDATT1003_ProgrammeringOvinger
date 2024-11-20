package Oving7;
/*
Lag en klasse for enkel tekstbehandling. Konstruktøren skal ta en tekst som argument. 
Klassen skal tilby følgende tjenester: 
    • Å finne antall ord i teksten. 
    • Å finne gjennomsnittlig ordlengde. Skilletegn er ikke en del av ordene. 
    • Å finne gjennomsnittlig antall ord per periode. Bruk punktum, utropstegn, kolon og 
    spørretegn som skilletegn mellom periodene. Anta at teksten er feilfri, slik at ikke to 
    eller flere slike tegn følger etter hverandre. 
    • Å skifte ut et ord med et annet gjennom hele teksten. For eksempel kan en ønske å 
    skifte ut ordet «finnes» med «fins». 
    • Å hente ut teksten slik den står, uten endringer. 
    • Å hente ut teksten, men slik at alle bokstaver er store. 
Lag en enkel testklient. Husk å prøve klassen for tekster som inneholder æ, ø og å.
 */

import java.util.*;

public class Oppg2 {
    
    public static String getInput(Scanner r) {
        String data = "";
        if (r.hasNextLine()) {
            return data = r.nextLine();
        }
        return data;
    }

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        clearScreen();
        Scanner myReader = new Scanner(System.in);
        
        boolean running = true; 
        
        while (running) {
            clearScreen();
            StringBuilder s = new StringBuilder();
            s.append("*********************************************************************************************************\n");            
            s.append("                                                                  Skriv en streng:\n");            
            s.append("*********************************************************************************************************\n");
            System.out.println(s);            
            
            
            //lager TextEdit objekt
            TextEdit str = new TextEdit(getInput(myReader));
            
            clearScreen();
            s = new StringBuilder();
            s.append("*********************************************************************************************************\n");            
            s.append("                                            Skriv et ord fra forrige streng som skal byttes:\n");            
            s.append("                                  Streng: \""+ str.getString() +"\"\n");            
            s.append("*********************************************************************************************************\n");            
            System.out.println(s);            
            
            String swapOrig = getInput(myReader);

            clearScreen();
            s = new StringBuilder();
            s.append("*********************************************************************************************************\n");            
            s.append("                                         Skriv en streng som skal erstatte \""+ swapOrig +"\"\n");            
            s.append("                                  Streng: \""+ str.getString() +"\"\n");            
            s.append("*********************************************************************************************************\n");            
            System.out.println(s);            
        

            String swapStr = getInput(myReader);

            //skriver ut diagnostikk av de forsjellige operasjonene 
            s = new StringBuilder();
            s.append("Tekst: " + str.getString() + "\n");
            s.append("Tekst uppercase: " + str.getStringUpper()+ "\n");
            s.append("Antall ord i teksten: " + str.wordCount()+ "\n");
            s.append("Gjennomsnittlig ordlengde: " + str.avrWordCount()+ "\n");
            s.append("Ord per periode: " + str.WPP()+ "\n");
            s.append("Bytt ut \""+swapOrig+"\" med \""+swapStr+"\": "  + str.swap(swapOrig, swapStr)+ "\n");
            System.out.println(s);
           

            //sjekker om brukeren ønsker å fortsette
            boolean e = true;
            while (e) {
                System.out.println("Vil du fortsette? \"y\" for JA og \"n\" for NEI.");
                String inp = getInput(myReader); 
                s = new StringBuilder();
                    
                if (inp.equals("Y") || inp.equals("y")) {
                    clearScreen();
                    e = false;
                }
                else if (inp.equals("N") || inp.equals("n")) {
                    e = false;
                    running = false;
                }
                else {
                    System.out.printf("\n\"%s\" er ikke en gyldig verdi for valget. Du må skrive enten \"y\" eller \"n\".\n", inp);
                }
            }
        }
        myReader.close();
    }
}
