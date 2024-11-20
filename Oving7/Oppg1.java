package Oving7;

public class Oppg1 {
    public static void main(String[] args) {
        String test = "The quick brown fox jumps over the lazy dog!";
        String userInput = " brown";

        NyString streng = new NyString(test);
        StringBuilder s = new StringBuilder();

        s.append("***********************************************************************************************\n");
        s.append("|               Streng                |     Forkortet    |                 Fjernet \"" + 
            String.format("%s", userInput)  
            + "\"          |\n");
        s.append("***********************************************************************************************\n");
        s.append("| " + String.format("%s", streng.getString()) + " ");
        s.append("| " + String.format("%s", streng.getShort()) +  " |");
        s.append(" " + String.format("%s", streng.cutString(userInput)) +  " |\n");
        s.append("***********************************************************************************************\n");

        System.out.println(s);
    }
}

