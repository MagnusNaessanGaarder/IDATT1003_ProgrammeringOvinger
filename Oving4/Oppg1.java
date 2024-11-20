package Oving4;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//import Java.Oving4.Valuta;
import java.util.Scanner;

public class Oppg1 {

    //Konstanter
    private static final float KURS_USD_TO_NOK = 10.81f;
    private static final float KURS_EUR_TO_NOK = 11.89f;
    private static final float KURS_SEK_TO_NOK = 1.042f;

    public static String getInput(Scanner myReader) {
        String data = "";
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            return data;
        }
        return data; 
    }
    
    public static void getValuta(List<Valuta> arr, int findVal, String type, Scanner reader) {
        System.out.println("\nSkriv et antall som skal konverteres (oppgi et desimaltall, eks. 10.0).");
        float a = Float.parseFloat(getInput(reader));

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).valType == type) {
                if (findVal == 1) {
                    arr.get(i).toNOK(a);
                    return;
                }
                else if (findVal == 2) {
                    arr.get(i).fromNOK(a);
                    return;
                }
                else {
                    System.out.println("Input for valg av funksjon er utenfor definisjonsområdet: [1, 2]");
                }
            }
        }

        return;
    }
    public static void main(String[] args) {
        boolean running = true;

        Scanner myReader = new Scanner(System.in);
        
        Valuta USD = new Valuta(KURS_USD_TO_NOK, "USD");
        Valuta EUR = new Valuta(KURS_EUR_TO_NOK, "EUR");
        Valuta SEK = new Valuta(KURS_SEK_TO_NOK, "SEK");

        List<Valuta> valList = new LinkedList<Valuta>(Collections.<Valuta>emptyList());
        valList.add(USD);
        valList.add(EUR);
        valList.add(SEK);

        while (running) {
            System.out.println(
                """
                
                Velg Valuta:
                1: Dollar.
                2: Euro.
                3. Svenske kroner.
                4. Avslutt.
                """
            );

            String uInp = getInput(myReader);

            String[] bs = {"1", "2", "3", "4"};
            
            if(Arrays.asList(bs).contains(uInp)) {
                if (uInp.equals("4")) {
                    running = false;
                    continue;
                }
                String[] val = {"USD", "EUR", "SEK"};
                String valutaType = val[Integer.parseInt(uInp) - 1];
                
                System.out.print(
                    String.format("""
                    \nVelg omgjøring.
                    1: Regn om fra %s til NOK.
                    2: Regn om fra NOK til %s.   
                    
                    """, valutaType, valutaType)
                );

                int kurs = Integer.parseInt(getInput(myReader));

                getValuta(valList, kurs, valutaType, myReader);

                boolean e = true;
                while (e) {
                    System.out.println("Vil du velge valuta igjen? \"y\" for JA og \"n\" for NEI.");
                    String inp = getInput(myReader); 
                    
                    if (inp.equals("Y") || inp.equals("y")) {
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
            else {
                System.out.println("Du må skrive et gyldig tall. Gyldige tall er \"1\", \"2\", \"3\" og \"4\".");
            }
        }
        myReader.close();
    }
}
