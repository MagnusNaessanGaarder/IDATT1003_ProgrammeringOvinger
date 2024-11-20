package Oving7;
/*
Lag en klasse for enkel tekstbehandling. Konstruktøren skal ta en tekst som argument. 
Klassen skal tilby følgende tjenester: 
    • Å finne antall ord i teksten. 
    • Å finne gjennomsnittlig ordlengde. Skilletegn er ikke en del av ordene. 
    • Å finne gjennomsnittlig antall ord per periode. Bruk punktum, utropstegn, kolon og 
    spørretegn som skilletegn mellom periodene. Anta at teksten er feilfri, slik at ikke to 
    eller flere slike tegn følger etter hverandre. 
    • Å skifte ut et ord med et annet gjennom hele teksten. For eksempel kan en ønske å 
    skifte ut ordet «finnes» med «fins». 
    • Å hente ut teksten slik den står, uten endringer. 
    • Å hente ut teksten, men slik at alle bokstaver er store. 
Lag en enkel testklient. Husk å prøve klassen for tekster som inneholder æ, ø og å.
 */

import java.util.*; 

public class TextEdit {
    final private String str;
    final private String[] wordList;
    
    public TextEdit(String s) {
        this.str = s;
        this.wordList = this.str.split("([\\s+])");
    }

    public TextEdit() {
        this.str = "Dette er en åpenbar test, med mange gode øvingsord! Kan det anbefales? Kanskje.";
        this.wordList = this.str.split("([\\s+])");
    }

    public boolean find(String s) {
        return this.str.contains(s);
    }

    private String deepCopy() {
        String c = "";
        for (int i = 0; i < this.str.length(); i++) {
            c += this.str.charAt(i);
        }
        return c;
    }

    public String getString() {
        return deepCopy();
    }

    public String getStringUpper() {
        return deepCopy().toUpperCase();
    }

    public int wordCount() {
        return wordList.length;
    }

    public double avrWordCount() {
        double ss = Arrays.stream(this.wordList)
            .flatMapToInt(String::chars)
            .filter(Character::isLetter)
            //.peek(s -> System.out.println((char)s))   // debug
            .count();

        return ss / (double)wordList.length;
    }

    public double WPP() {
        double pCount = Arrays.stream(this.str.split("\\s+"))
        .filter(s -> s.indexOf(".") != -1 || s.indexOf(",") != -1 || s.indexOf("?") != -1 || s.indexOf("!") != -1)
        .count();

        if (pCount == 0) {
            return 0.0;
        }  
        return (double)this.wordList.length / pCount;
    }

    public String swap(String s, String replace) {
        if (!find(s)) {
            return "Error: String \"" + s + "\" is either not in main string, or is missspelled." ;
        }
        return String.join(replace, this.str.split(s));
    }
}
