package Oving3;
import javax.swing.JOptionPane;

public class Oppg2 {
    public static void main(String[] args) {
        String startverdi = JOptionPane.showInputDialog("Skriv en startverdi for primtallsjekkingen."); 
        String sluttverdi = JOptionPane.showInputDialog("Skriv en sluttverdi for primtallsjekkingen."); 
        
        while(startverdi != null && sluttverdi != null) {
            int start = Integer.parseInt(startverdi);
            int slutt = Integer.parseInt(sluttverdi);
            
            if(start > slutt) {
                System.out.println("Startverdien kan ikke være større enn sluttverdien");
            }
            else if (start < 0 || slutt < 0) {
                System.out.println("Start og Slutttallet kan ikke være negativt!");
            }
            else {
                for(int i = start; i <= slutt; i++) {
                    Boolean flag = false;
                    
                    if (i == 0 || i == 1) {
                        flag = true;
                    }


                    for (int j = 2; j < i; j++) {
                        if (i % j == 0) {
                            flag = true;
                            break;
                        }
                    }
                        
                    if (!flag) {
                        System.out.println("Tallet " + i + " er et primtall");
                        continue;
                    }
                    System.out.println("Tallet " + i + " er ikke et primtall");
                }   
            }
            
            startverdi = JOptionPane.showInputDialog("Skriv en startverdi for primtallsjekkingen."); 
            sluttverdi = JOptionPane.showInputDialog("Skriv en sluttverdi for primtallsjekkingen.");
        }
    }
}
