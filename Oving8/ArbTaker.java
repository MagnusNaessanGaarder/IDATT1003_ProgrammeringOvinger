package Oving8;

import java.time.LocalDate;

public class ArbTaker {
    static private int nextID = 1;
    final private int workerID;
    final private Person personalia;
    final private int startingYear;
    private double salary;
    private double tax; //prosent

    public ArbTaker(Person personalia, int startingYear, double salary, double tax) {
        this.workerID = advanceID();
        this.personalia = personalia;
        this.startingYear = startingYear;
        this.salary = salary;
        this.tax = tax; 
    }

    static int advanceID() {
        return nextID++;
    }
    
    public int getWorkerID() {
        return this.workerID;
    }

    public int getStartingYear () {
        System.out.println(this.startingYear);
        return this.startingYear;
    }

    public String getSalary() {
        return this.salary + " kr/mnd";
    }

    public String getTaxPercent() {
        return this.tax + "%";
    }

    public void setSalary(double newSalary) {
        this.salary = newSalary;
    }

    public void setTaxPercent(double newTax) {
        this.tax = newTax;
    }

    public double getTaxMoney() {
        return this.salary * (this.tax / 100);
    }

    public String getYearlySalary() {
        return (this.salary * 12) + " kr/mnd";
    }

    public double getTaxMoneyYearly() {
        return 10*getTaxMoney() + 0.5*getTaxMoney();
    }

    public String getFullName() {
        System.out.println(this.personalia.getLastName() + ", " + this.personalia.getFirstName());
        return this.personalia.getLastName() + ", " + this.personalia.getFirstName();
    }

    public int getEmployeAge() {
        return this.personalia.getAge();
    }
    
    public int getEmployeYearsWorked() {
        int year = LocalDate.now().getYear();
        return Math.max((year - startingYear), 0);
    }

    public boolean hasWorkedAmountYears(int amount) {
        return (getEmployeYearsWorked() - amount) > 0;
    }
}
