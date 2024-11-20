package Oving9;

import java.util.ArrayList;
import java.util.Arrays;

public class OppgaveOversikt {
    private Student[] studenter;  // tabellen opprettes i konstruktøren
    private int antStud = 0;   // økes med 1 for hver ny student

    public OppgaveOversikt() {
        studenter = new Student[]{};
    }

    public OppgaveOversikt(Student[] liste) {
        studenter = liste;
        antStud = liste.length;
    }

    public int getAntStud() {
        return antStud;
    }

    public Student[] getStudenter() {
        return studenter;
    }
    
    public String getStudNavn(Student s) {
        return s.getNavn();
    }

    public int getStudAntOppg(Student s) {
        return s.getAntOppg();
    }
    
    public void addNewStudent(Student s) {
        ++antStud;
        ArrayList<Student> studList = new ArrayList<>(Arrays.asList(studenter));
        studList.add(s);

        studenter = studList.toArray(new Student[studList.size()]);
    }
    
    public void increaseAntOppg(Student s, int økning) {
        int index = Arrays.asList(studenter).indexOf(s);
        if (index != -1) {
            studenter[index].økAntOppg(økning);
        }
    }

    @Override
    public String toString() {
        String str = "Klasse OppgaveOversikt; " + System.lineSeparator();
        str += "Studenttabell : " + System.lineSeparator();
        for (Student s : studenter) {
            str += s.toString();
        }
        str = "Antall studenter " + antStud + ";";
        return str;
    }
}
