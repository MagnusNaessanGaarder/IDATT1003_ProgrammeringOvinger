package Oving6;

import java.util.Scanner;

public class Oppg3 {
    //henter input
    public static String getInput(Scanner r) {
        String data = "";
        if (r.hasNextLine()) {
            data = r.nextLine();
            return data;
        }
        return data;
    }

    //printer matrisen som et "array" (egt String) istedenfor et objekt
    public static String printMatrix(int[][] a) {
        if (a == null) {
            return null;
        }
        
        String res = "[";
        
        for (int i = 0; i < a.length; i++) {
            res += "[";
            for (int j = 0; j < a[i].length; j++) {
                if ((a[i].length - 1) == j) {
                    res += a[i][j];
                    continue;
                }
                res += a[i][j] + ", ";
            }
            res += "]";
        }
        
        res += "]";
        return res;
    }

    //tolker streng og returnerer array av matrisen, funker bare for 2x2 matriser
    public static int[][] interpretMatrix(String a) {
        //fjerner whitespace
        a = a.replaceAll("\\s+","");
        int row, col;
        
        int[][] res = new int[2][2];
        int[] deepArr = new int[2];
        
        col = 0;
        row = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '[') {
                col = 0;
                
                while (a.charAt(i) != ']') {
                    if (a.charAt(i) != ',' && a.charAt(i) != '[') {
                        deepArr[col] = a.charAt(i) - '0';
                        col++;
                    }
                    i++;
                }

                res[row] = deepArr;
                row++;
                i++;
                deepArr = new int[2];
            }
        }
        return res;
    }

    //lager ny matrise
    public static Matrise createMatrix(Scanner r) {
        StringBuilder s = new StringBuilder();
        s.append("**********************************************************************************\n");
        s.append("Skriv inn en 2x2 matrise på formen: \"[[a, b],[c, d]]\", der a, b, c og d er tall.\n\n");

        System.out.println(s);

        String a = getInput(r);
        int[][] newMatrix = interpretMatrix(a);
            
        Matrise m = new Matrise(newMatrix);

        return m;
    }

    //renser terminal
    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        clearScreen();
        Scanner myReader = new Scanner(System.in);

        boolean running = true; 
        Matrise mainMatrise, matrise;
        
        //lager matriser 
        mainMatrise = createMatrix(myReader);
        matrise = createMatrix(myReader);

        while (running) {
            clearScreen();
            
            //skriver ut diagnostikk av de forsjellige operasjonene 
            StringBuilder s = new StringBuilder();
            s.append("Hovedmatrise: "); s.append(printMatrix(mainMatrise.getMatrix()));
            s.append("\nOperasjonsmatrise: "); s.append(printMatrix(matrise.getMatrix()));
            s.append("\n\nSum:\n"); 
            
            s.append(printMatrix(mainMatrise.getMatrix())); 
            s.append(" + ");
            s.append(printMatrix(matrise.getMatrix()));
            s.append(" = ");
            s.append(printMatrix(mainMatrise.matAdd(matrise.getMatrix())));

            s.append("\n\nProdukt:\n");
            
            s.append(printMatrix(mainMatrise.getMatrix())); 
            s.append(" * ");
            s.append(printMatrix(matrise.getMatrix()));
            s.append(" = ");
            s.append(printMatrix(mainMatrise.matProd(matrise.getMatrix())));

            s.append("\n\nTransponering av Hovedmatrise:\n"); s.append(printMatrix(mainMatrise.getTransMatrix()));
            s.append("\n\nTransponering av Operasjonsmatrise:\n"); s.append(printMatrix(matrise.getTransMatrix()));

            System.out.println(s);

            //sjekker om brukeren ønsker å fortsette
            boolean e = true;
            while (e) {
                System.out.println("Vil du fortsette? \"y\" for JA og \"n\" for NEI.");
                String inp = getInput(myReader); 
                s = new StringBuilder();
                    
                if (inp.equals("Y") || inp.equals("y")) {
                    e = false;
                    clearScreen();
                    
                    //lager ny matrise dersom brukeren velger det
                    s.append("******************************************************************************\n");
                    s.append("Velg et alternativ under. Skriv et tall for å velge.\n");
                    s.append("[1] Test å endre på forrige til matrise.\n");
                    s.append("[2] Lag ny matrise.\n\n");
                    
                    System.out.println(s);
                
                    int b = Integer.parseInt(getInput(myReader));
                    if (b < 1 || b > 2) {
                        System.out.println("TypeError: Invalid input. Type in a valid value: 1 or 2.");
                        continue;
                    }
                    else if (b == 2) {
                        mainMatrise = createMatrix(myReader);
                        matrise = createMatrix(myReader);
                    }
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
        myReader.close();
    }
}
