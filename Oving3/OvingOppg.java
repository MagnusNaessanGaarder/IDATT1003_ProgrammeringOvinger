package Oving3;
import javax.swing.JOptionPane;

public class OvingOppg {
    public static void oppg1(int x) {
        for (int i = 0; i <= x; i++) {
            
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            
            System.out.print("\n");
        }

        return;
    }
    
    public static String oppg2(int x) {
        System.out.println("Oppgave 2");
        for (int i = 0; i < x; i++) {
            for (int f = 0; f < x - i - 1; f++) {
                System.out.print(" ");
            }
            

            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            
            System.out.print("\n");
        }

        return "";
    }


    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Skriv inn et antall, skriv 0 for å avslutte");
        while (input != "0" || input != "" || input != null) {
            int ant = Integer.parseInt(input);
            oppg1(ant);
            oppg2(ant);
            
            input = JOptionPane.showInputDialog("Skriv inn et antall, skriv 0 for å avslutte");
        }
    }
}