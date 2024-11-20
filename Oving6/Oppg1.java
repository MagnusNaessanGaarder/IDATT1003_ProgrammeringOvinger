package Oving6;

import java.util.Scanner;

public class Oppg1 {
    
    //henter brukerinput
    public static String getInput(Scanner s) {
        String data = "";
        if (s.hasNextLine()) {
            data = s.nextLine();
            return data;
        }
        return data;
    }
    
    //rydder terminal
    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    //Skriver en utskrift av et array
    public static void printArr(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            if (i == (arr.length-1)) {
                System.out.print(arr[i] + " ");
            }
            else {
                System.out.print(arr[i] + ", ");
            }
           
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        clearScreen();
        Scanner myReader = new Scanner(System.in);
        
        java.util.Random random = new java.util.Random();
        int n = 1000;
        int[] antall = new int[n];
        
        System.out.println("Skriv et tall som skal sjekkes i intervallet (0, 9): \n\n");
        int a = Integer.parseInt(getInput(myReader));
        boolean e = true;
        
        //sjekker om brukerinput er gyldig ift. intervall helt til det er gyldig.
        while (e) {
            try {
                if (a < 10 && a >= 0) {
                    e = false;
                }
                else {
                    System.out.println("Error: Value is outside of range (0, 9).");
                    
                    System.out.println("Skriv et tall som skal sjekkes i intervallet (0, 9): \n\n");
                    a = Integer.parseInt(getInput(myReader));
                }
            }
            catch (NumberFormatException ex) {
                System.err.println(ex);
            }
        }
        
        //lager en verdi som teller hvor mange ganger et tall er forekommet. Denne skal rundes opp senere.
        //For å ha mer presisjon på avrundingen (siden vi deler på 1/10 av antall iterasjoner n) har vi double datatype
        double numCounter = 0.0;

        //fyller opp antall og sjekker om tallet brukeren sjekker forekommer
        for (int i = 0; i < n; i++) {
            antall[i] = random.nextInt(10);
            if (antall[i] == a) {
                numCounter++;
            }
        }
        //skriver ut tabell
        System.out.println("Tabell:");
        printArr(antall);


        //ekstradel i oppgaven
        //skriver ut tallet som sjekkes, hvor mange ganger det forekommer og et antall stjerner (10% av n) som forekommer rundet opp.
        System.out.print("\n\n" + a + " ");
        System.out.print((int)numCounter + " ");
        String star = "";
        
        int starNum = (int)Math.ceil(numCounter / (n/100));
        for (int i = 0; i < starNum; i++) {
            star += "*";
        }

        System.out.print(star);
    }
}
