package Oving9;

public class Student {
    final private String navn;    // entydig(!)
    private int antOppg;

    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }

    public String getNavn() {
        return navn;
    }
    public int getAntOppg() {
        return antOppg;
    }
    public void økAntOppg(int økning) {
        antOppg += økning;
    }

    @Override
    public String toString() {
        return "Klasse Student;" + System.lineSeparator() +
               "Navn " + navn + ";" +  System.lineSeparator() +
               "Godkjente oppgaver " + antOppg + ";";
    }
}
