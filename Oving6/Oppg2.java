package Oving6;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.concurrent.TimeUnit;


public class Oppg2 {
    //henter brukerinput
    public static String getInput(Scanner r) {
        String data = "";
        if(r.hasNextLine()) {
            data = r.nextLine();
            return data;
        }
        return data; 
    }
    
    //henter en streng som skal sendes til StringScan objekt.
    public static String stringObjGen(Scanner r) {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------------\n");
        sb.append("                Skriv en streng:                \n");
        sb.append("------------------------------------------------\n");
        sb.append("\n");
        
        System.out.println(sb);
        
        String newStr = getInput(r);

        return newStr;
    }

    //Rydder terminalen
    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        clearScreen();
        Scanner myReader = new Scanner(System.in);
        String text = stringObjGen(myReader);

        //lager objekt
        StringScan tekstAnalyse = new StringScan(text);

        boolean running = true;

        //kjører mens running er true
        while (running) {
            clearScreen();

            //henter en bokstav som skal sjekkes av bruker.
            System.out.println("Oppgi en en bokstav (datatype: char):");
            String ui = getInput(myReader);
            char userInput = ui.charAt(0); 

            //kort pause for visning av tabell
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            catch(InterruptedException e) {
                System.err.println("Error: " + e);
            }

            clearScreen();
            //Tabell
            StringBuilder tabell = new StringBuilder();
            tabell.append("------------------------------------------------------------------------------------------------------------------\n");
            tabell.append("|       Din tekst                |   Antall forskjellige  |  Prosentandel |  Forekomster av |   Bokstaver som    |\n");
            tabell.append("|                                |       bokstaver        |    symboler   |        \""); 
            tabell.append(userInput);
            tabell.append("\"      |  forekommer oftest |\n");
            tabell.append("------------------------------------------------------------------------------------------------------------------\n");
            tabell.append("|       "); tabell.append(tekstAnalyse.getString()); tabell.append("      |          ");
            tabell.append(tekstAnalyse.numOfDiffChar()); tabell.append("            |    ");
            tabell.append(tekstAnalyse.percentOfSymbols()); tabell.append("      |        ");
            tabell.append(tekstAnalyse.countInstance(userInput)); tabell.append("        |      ");
            
            char[] charArr = tekstAnalyse.popularChar();

            //skriver ut én eller flere karakterer som er den/de mest populære karakteren/e i strengen som sjekkes 
            for (int i = 0; i < charArr.length; i++) {
                tabell.append(charArr[i]);
                if (i != (tekstAnalyse.popularChar().length - 1)) {
                    tabell.append(", ");
                }
            } 

            tabell.append("       |\n");
            tabell.append("------------------------------------------------------------------------------------------------------------------\n");
            
            //skriver ut tabellen
            System.out.println(tabell);

            //kort pause før siste sjekk
            try {
                TimeUnit.MILLISECONDS.sleep(2500);
            }
            catch(InterruptedException e) {
                System.err.println("Error: " + e);
            }

            //sjekker om brukeren ønsker å fortsette
            boolean e = true;
            while (e) {
                System.out.println("Vil du fortsette? \"y\" for JA og \"n\" for NEI.");
                String inp = getInput(myReader); 
                    
                if (inp.equals("Y") || inp.equals("y")) {
                    //Sjekker om brukeren ønkser å lage en ny streng som skal sjekkes, eller beholde den gamle
                    System.out.println("Vil du lage en ny streng?\"y\" for JA og \"n\" for NEI.");
                    inp = getInput(myReader);
                    
                    if (inp.equals("Y") || inp.equals("y")) {
                        //setter en ny streng som skal sjekkes i StringScan
                        tekstAnalyse.setString(stringObjGen(myReader));
                    }

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
        //lukker scanner
        myReader.close();
    }   
}
