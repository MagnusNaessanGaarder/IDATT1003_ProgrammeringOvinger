package Oving2;
import java.util.Scanner;
import java.util.HashMap;

public class O2Oppg1 {
    
    public static String func(int x){
        
        if (x < 0) {
            System.out.println("Året må være positivt");
            return "feil";
        }  
        
        if (!(x == 0)) {
            if (x % 400 == 0 || x % 4 == 0) {
                return "Året er et skuddår";
            }
            return "Året er ikke et skuddår";
        }
        return "Året er ikke et skuddår";
    }
    
    public static void main(String[] args) {
        System.out.println("TestDataSet");
        HashMap<String, String> testData = new HashMap<>();
        for (int t = 0; t < 401; t++) {
            if (t == 0) {
                testData.put("År: " + t + " ", func(t));
            }
        }
        System.out.println(testData);
        

        Scanner userInput = new Scanner(System.in);
        int n;
       
        System.out.println("Et hvilket som helst år (positivt heltall):");
        n = userInput.nextInt();
        
        System.out.println(func(n));
        userInput.close();
    } 
}
