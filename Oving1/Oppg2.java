package Oving1;
import java.util.Scanner;
import java.util.HashMap;

public class Oppg2 { 
    
    static int CalcSec(int t, int m, int s) {
        int res = 3600*t + 60*m + s;
        return res;
    }
    
    static String InputMethod() {
        Scanner userInput = new Scanner(System.in);
        
        int timer, minutter, sekunder;

        System.out.println("Skriv et antall timer:");
        timer = userInput.nextInt();
        
        System.out.println("Skriv et antall minutter:");
        minutter = userInput.nextInt();
        
        System.out.println("Skriv et antall sekunder:");
        sekunder = userInput.nextInt();
        userInput.close();

        
        String resultat = timer + " timer, " + minutter + " minutter og " + sekunder + " sekunder blir tilsammen " + CalcSec(timer, minutter, sekunder) + " sekunder";

        return resultat;
    }


    public static void main(String[] args){
        
        System.out.println(System.lineSeparator() + "TestDataSet:");
        
        HashMap<String, String> testData = new HashMap<String, String>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int z = 0; z < 3; z++) {
                    testData.put(i + "t " + j + "min " + z + "sek ", " " + CalcSec(i, j, z) + " sek");
                }
            }
        }

        System.out.println(testData);

        System.out.println(System.lineSeparator() + "Brukerinput:");

        System.out.println(InputMethod());
        
    }
}