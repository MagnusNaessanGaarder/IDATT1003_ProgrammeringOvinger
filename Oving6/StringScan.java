package Oving6;

import java.util.Arrays;

class StringScan {
    //globale variabler i scopet StringScan
    private String myStr;
    private int[] antallTegn = new int[30];
    
    public StringScan(String str) {
        //exception handler
        if (str == "") {
            throw new IllegalArgumentException("Illegal argument: An empty string is not a valid argument for the constructor of the object \"StringScan\".");
        }

        //initialisering/ konstruksjon av datafelter
        this.myStr = str;
        
        //initialiserer getCount i konstruktøren.
        this.getCount();
    }

    //Set-funksjon: bytte streng som sjekkes.
    public void setString(String input) {
        this.myStr = input;
        antallTegn = new int[30];
    }

    //Get funksjon: Får lengden av strengen.
    public int getLength() {
        return getString().length();
    }

    //Get funksjon: Henter strengen.
    public String getString() {
        return this.myStr;
    }

    //setter inn antall forekomster av en bokstav i antall-array.
    private void getCount() {
        String strLower = getString().toLowerCase();
        for (int i = 0; i < strLower.length(); i++) {
            char c = strLower.charAt(i);
            int index = (int)c;

            if (index >= (int)'a' && index <= (int)'z') {
                antallTegn[index - (int)'a'] += 1;
            }
            //har ikke fått til for æ, ø og å. Har ikke fått til å konvertere fra ASCII til UTF-8 / 16
            /*else if (c == (char)"æ") {
                antallTegn[26] += 1;
            }
            else if (c == (char)"ø") {
                antallTegn[27] += 1;
                }
            else if (c == (char)"å") {
                antallTegn[28] += 1;
            }*/
            else {
                antallTegn[antallTegn.length - 1] += 1;
            }
        }                
    }

    //Går gjennom antallTegn og teller alle verdier som ikke er null
    public int numOfDiffChar() {
        int counter = 0;
        for (int i = 0; i < antallTegn.length; i++) {
            if (antallTegn[i] != 0 && i < (antallTegn.length - 1)) {
                counter++;
            }
        }
        return counter;
    }

    //teller antall forekomster av et tegn ved hjelp av å hente indexen av bukstaven og sjekke den opp mot antallTegn.
    public int countInstance(char c) {
        int ant = 0;

        int i = ((int)c - (int)'a');
        ant = antallTegn[i];

        return ant;
    }

    //Sjekker prosent antallet av symboler mot antallet bokstaver og runder av til to desimaler 
    public String percentOfSymbols() {
        double charCount = 0;
        double symbolCount = antallTegn[antallTegn.length - 1];

        for (int i : antallTegn) {
            charCount += i;
        }

        double percent = ((symbolCount / charCount) * 100);
        String res = "%.2f";
        
        res = String.format(res, percent) + "%";
        return res;
    }

    //sjekker mest populære / mest brukte tegn i strengen
    public char[] popularChar() {
        int[] a = Arrays.copyOf(antallTegn, (antallTegn.length - 1));
        
        //maxAmount henter den største verdien i a-array
        int maxAmount = Arrays.stream(a).reduce(0, Math::max);
        
        // finner antallet bokstaver i a som har maxAmount som verdi
        int countMax = (int)Arrays.stream(a)
            .filter(antall -> antall == maxAmount)
            .count();
        
        //Lager et tomt Array med karakterer, som tar plassen countMax
        char[] charArr = new char[countMax];
        int i = 0;

        //setter inn karakterene i charArr
        for (int j = 0; j < antallTegn.length; j++) {
            if(antallTegn[j] == maxAmount) {
                charArr[i++] = (char)(j + (int)'a');
            }
        }
        //returnerer charArr
        return charArr; 
    }
}