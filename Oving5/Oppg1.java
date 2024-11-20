package Oving5;
import java.util.Scanner;

//import Oving5.Fraction;

public class Oppg1 {

    //skal rense terminal
    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    //Metode som lager en Scanner for å lete etter brukerinput (Bare hvis scannerObj.hasNextLine() er gitt).
    public static String getInput(Scanner myReader) {
        String data = "";
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            return data;
        }
        return data; 
    }
    
    //genererer Fraction objekt
    public static Fraction fracGen(Scanner reader) {
        clearScreen();
        String s = "Skriv telleren i broken";
        System.out.println(s);
        int n = Integer.parseInt(getInput(reader));
        
        s = "Skriv nevneren i broken";
        System.out.println(s);
        int d = Integer.parseInt(getInput(reader));

        return new Fraction(n, d);
    }

    //bestemmer hvilken metode for Fraction som kjører ved hjelp av brukerinput
    public static void fractionAction(int a, int n, int d, Fraction fraction) {
        clearScreen();
        switch (a) {
            case 1 -> {fraction.sum(n,d);}
            case 2 -> {fraction.diff(n,d);}
            case 3 -> {fraction.product(n,d);}
            case 4 -> {fraction.quotient(n,d);}
            
            default -> {System.out.println("TypeError: Type in a valid value: 1, 2, 3 or 4.");}
        }
    }

    public static void main(String[] args) {
        clearScreen();
        
        Scanner myReader = new Scanner(System.in);
        
        //genererer fraction
        Fraction fraction = fracGen(myReader);
        
        //while løkke som kjører så lenge keepRunning er true
        boolean keepRunning = true;
        while (keepRunning) {
            String s = """
            ******************************************************************************
            Velg et alternativ under. Skriv et tall for å velge.

                [1] Sum av brøker.
                [2] Differanse av brøker.
                [3] Multiplikasjon av brøker.
                [4] Divisjon av brøker.

            """;
            System.out.println(s);
            
            //henter verdien brukerinput a, som bestemmer metoden som skal brukes på Fraction objektet
            int a = Integer.parseInt(getInput(myReader));
            
            s = """
            ******************************************************************************
            Skriv inn den andre brøken: 

            """;
            System.out.println(s);
            
            //får inn brukerinput for teller, n, og nevner, d.
            System.out.println("Skriv telleren i den andre brøken");
            int n = Integer.parseInt(getInput(myReader));
        
            System.out.println("Skriv nevneren i den andre brøken");
            int d = Integer.parseInt(getInput(myReader));

            //velger metode fra Fraction objektet
            fractionAction(a, n, d, fraction);
            
            //Fortsetter å kjøre så lenge brukeren øsnker det
            boolean e = true;
            while (e) {
                System.out.println("Vil du fortsette? \"y\" for JA og \"n\" for NEI.");
                String inp = getInput(myReader); 
                    
                if (inp.equals("Y") || inp.equals("y")) {
                    e = false;
                    clearScreen();
                    s = """
                    ******************************************************************************
                    Velg et alternativ under. Skriv et tall for å velge.
                
                        [1] Behold forrige brøk til objekt.
                        [2] Lag nytt brøk-objekt.

                    """;
                    System.out.println(s);
                
                    int b = Integer.parseInt(getInput(myReader));
                    if (b < 1 || b > 2) {
                        System.out.println("TypeError: Type in a valid value: 1 or 2.");
                        continue;
                    }
                    else if (b == 2) {
                        fraction = fracGen(myReader);
                    }
                }
                else if (inp.equals("N") || inp.equals("n")) {
                    e = false;
                    keepRunning = false;
                }
                else {
                    System.out.printf("\n\"%s\" er ikke en gyldig verdi for valget. Du må skrive enten \"y\" eller \"n\".\n", inp);
                }
            }
        }
        //lukker scanner etter while-løkke.
        myReader.close();
    }
}

