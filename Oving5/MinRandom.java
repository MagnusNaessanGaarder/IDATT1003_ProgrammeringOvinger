package Oving5; 
import java.util.Random;
import java.lang.IllegalArgumentException;

public class MinRandom {
    private Random rand = new Random();
    
    private void printRand(String a) {
        System.out.println(a);
    }
    
    public int nesteHeltall(int nedre, int ovre) {
        if (nedre == ovre || ovre < nedre || ovre < 0 || nedre < 0) {
            throw new IllegalArgumentException("Ugyldige verdier for øvre og nedre grense!");
        }

        int randInt = rand.nextInt((ovre - nedre) + 1) + nedre;
        
        printRand("Tilfeldig generert heltall i intervallet ("+ nedre +", "+ ovre +"): " + randInt);
        return randInt;
    }
    public double nesteDesimaltall(double nedre, double ovre) {
        if (nedre < 0.0 || ovre >= 1.0 || ovre < 0 || ovre < nedre || nedre == ovre) {
            throw new IllegalArgumentException("Ugyldige verdier for øvre og nedre grense!");
        }
        
        double randDouble = rand.nextDouble()*(ovre - nedre) + nedre;
        
        printRand("Tilfeldig generert desimal i intervallet <"+ nedre +", "+ ovre +">: " + randDouble);
        return randDouble;
    }
}
