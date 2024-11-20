package Oving3;
import javax.swing.JOptionPane;

public class Oppg1 {
    public static String printObj(Object[] obj, int ant) {
        String utskrift = "{";
        
        for (int i = 0; i < ant; i++) {
            if ((i+1) == ant) {
                utskrift += (i + 1) + ": " + obj[i];
            }
            else {
                utskrift += (i + 1) + ": " + obj[i] + ", ";
            }
        }
        utskrift += "}";
        
        return utskrift;
    }
    
    public static String gangetabellen(int antNum, int gangeRad) {
        Object[] gangeRekke = new Object[antNum];
        int i = 1;

        do {
            gangeRekke[i - 1] = i * gangeRad;
            i++;
        }
        while(i <= antNum);
        
        return printObj(gangeRekke, antNum);
    }
    
    public static void main(String[] args){
        
        int gangeNum =  Integer.parseInt(JOptionPane.showInputDialog("Hvilket tall skal vises gangetabell av?"));
        int antallNum = Integer.parseInt(JOptionPane.showInputDialog("Hvor mange tall skal vises?"));

        gangeNum = Integer.valueOf(gangeNum);
        antallNum = Integer.valueOf(antallNum);
        
        System.out.println(gangetabellen(antallNum, gangeNum));
    }
}