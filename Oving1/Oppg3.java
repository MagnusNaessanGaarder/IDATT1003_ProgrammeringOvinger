package Oving1;
import java.util.Scanner;
import java.util.HashMap;

public class Oppg3 {
    
    static String TimeMet(int x) {

        int t, min, sek;
        String tid;

        if (x < 0) {
            System.out.println("Du må skrive et positivt heltall!");
            return x + "";
        }

        t = x / 3600;

        min = (x % 3600) / 60;

        sek = x % 60;
        
        tid = String.format("%02dt:%02dmin:%02dsek", t, min, sek);
        
        return tid;
    }

    public static boolean fortsCheck = true;
    public static void main(String[] args) {
        
        //testdata
        System.out.println("\nTestdatasett");
        
        HashMap<String, String> testData = new HashMap<String, String>();
        
        for (int i = 0; i < 10; i++) {
            int ranNum = (int)(Math.random() * 10001);
            testData.put(ranNum + " ", " " + TimeMet(ranNum));
        }

        System.out.println(testData);
        
        //Brukerinput
        System.out.println("\n***Brukerinput***");
                   
        Scanner input = new Scanner(System.in);
        int totalSek;

        System.out.println("Skriv et antall sekunder");
        totalSek = input.nextInt();
        input.close();
            
        System.out.println("\n" + totalSek + "sekunder kan konverteres til dette antallet timer, minutter og sekunder: \n" + TimeMet(totalSek) + "\n");
    }
}
