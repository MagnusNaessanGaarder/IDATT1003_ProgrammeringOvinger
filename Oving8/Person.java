package Oving8;

import java.time.LocalDate;

public class Person {
    final private String firstName; 
    final private String lastName;
    final private int birthYear;

    public Person(String n, String ln, int by) {
        this.firstName = n;
        this.lastName = ln;
        this.birthYear = by;
    } 

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public int getAge() {
        return LocalDate.now().getYear() - this.birthYear;
    }
}
