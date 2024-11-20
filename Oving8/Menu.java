package Oving8;

import java.util.Scanner;
import java.lang.StringBuilder;
import java.time.LocalDate;
import java.util.ArrayList;

public class Menu {
    //global variables
    private final static Scanner myReader = new Scanner(System.in);
    private static StringBuilder s;
    public static boolean running = true;
    final private static ArrayList<Person> personList = new ArrayList<>();
    final private static ArrayList<ArbTaker> employeeList = new ArrayList<>();
    
    //Method for getting a input from user
    public static String getInput() {
        String data = "";
        if (myReader.hasNextLine()) {
            return data = myReader.nextLine();
        }
        return data;
    } 

    //clears screen in terminal
    private static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    
    //main method for the menu
    public static void start() {
        clearScreen();
        s = new StringBuilder();
        String topBar = "-------------------------------------------------------------------------------------------------------------------------\n";
        
        s.append(topBar).append("\n                                                  HOVEDMENY - OPPGAVE 8\n\n").append(topBar);
        s.append("\n                                                 Velg et menyvalg under:\n\n");
        s.append("          [1]  Legg til en ny person.\n");
        s.append("          [2]  Oversikt over personer.\n");
        s.append("          [3]  Legg til en ny arbeidstaker.\n");
        s.append("          [4]  Oversikt over arbeidstakere.\n");
        s.append("          [5]  Avslutt.\n");
        System.out.println(s);
        
        switch (getInput()) {
            case "1"-> {
                clearScreen();
                createPerson();
                break;
            }
            case "2"-> {
                clearScreen();
                displayPersons();
                break;
            }
            case "3"-> {
                clearScreen();
                System.out.println("\nVil du bruke en person som allerede er opprettet? \"y\" for JA og \"n\" for NEI.");
                String svar = getInput();
                Person personChoice;
                
                if (svar.equalsIgnoreCase("y")) {
                    personChoice = personListChoice();
                    createEmployee(personChoice);
                }
                else if (svar.equalsIgnoreCase("n")) {
                    personChoice = createPerson();
                    createEmployee(personChoice);
                }
                else {
                    System.err.println("Illegal argument: Type either \"y\" or \"n\".");
                }

                break;
            }
            case "4"-> {
                clearScreen();
                displayEmployee();
                break;
            }
            case "5" -> {
                clearScreen();
                checkContinue();
                break;
            }
            default -> {
                System.err.println("Invalid input: ");
                break;
            }
        }

        if (running) {
            System.out.println("\n          Skriv \"-e\" for å gå tilbake til hovedmenyen.");
            String escape = getInput();
            while (!escape.equals("-e")) {
                escape = getInput();
            } 
        }
    }

    private static void createEmployee(Person person) {
        clearScreen();
        s = new StringBuilder();
        String topBar = "-------------------------------------------------------------------------------------------------------------------------\n";
        s.append(topBar).append("                                                  OPPRETT ARBEIDSTAKER\n").append(topBar);
        s.append("                    Opprett en arbeidstaker ved å fylle ut feltene nedenfor for ").append(person.getFirstName()).append(" ").append(person.getLastName()).append(":");

        //checking valid input for startingYear
        int startingYear = 0;
        do {
            System.out.print("            Skriv ned året vedkommende startet/skal starte å jobbe (YYYY): ");
            startingYear = Integer.parseInt(getInput());
            
            //feilmelding
            if (startingYear < (16 + person.getBirthYear())) {
                System.err.println("\nPersonen må være minst 16 år da personen startet å jobbe. Da kan personen tidligst starte i "+ (person.getBirthYear()+16) + ".\n");
            }
        }
        while (startingYear < (16 + person.getBirthYear()));
        
        
        //checking valid input for salary
        double salary = 0.0;
        do {
            System.out.print("            Skriv en månedslønn (kr/mnd): ");
            salary = Double.parseDouble(getInput());
            
            //feilmelding
            if (salary < 140*8*4) {
                System.err.println("Personen må minst tjene intill " + (140*8*4) + " kr/mnd.\n");
            }
        }
        while (salary < 140*8*4); //looper hvis lønnen er mindre enn minstelønn (i dette tilfellet 140kr/t * 8t * 4 uker = ca. minstelønn/ måned)
        
        //checking valid input for tax in percent
        double tax = 0; 
        do {
            System.out.print("            Skriv inn skatten for vedkommende i prosent (%): ");
            tax = Double.parseDouble(getInput());
            
            //feilmelding
            if (tax < 15 || tax > 40) {
                System.err.println("Skatteprosenten må være innenfor intervallet [ 15% ,  40% ].\n");
            }
        }
        while (tax < 15 || tax > 40); //looper hvis skatteprosenten er høyere enn
       
        //instantize the employee class to an empolyee object
        ArbTaker employee = new ArbTaker(person, startingYear, salary, tax);

        //display employee
        displayEmployee(employee);
        
        //checking if user wants to store the created Employee
        boolean e = true;
        while (e) {
            System.out.println("Vil du sikker på at du vil opprette denne Arbeidstakeren? \"y\" for JA og \"n\" for NEI.");
            String inp = getInput(); 
                    
            if (inp.equalsIgnoreCase("y")) {
                employeeList.add(employee);
                e = false;
            }
            else if (inp.equalsIgnoreCase("n")) {
                e = false;
            }
            else {
                System.out.printf("\n\"%s\" er ikke en gyldig verdi for valget. Du må skrive enten \"y\" eller \"n\".\n", inp);
            }
        }
    }

    private static void displayPersons() {
        s = new StringBuilder();
        String topBar = "-------------------------------------------------------------------------------------------------------------------------\n";
        s.append(topBar).append("                                                       PERSONLISTE\n").append(topBar);
        s.append("                                  Her er en liste med nåværende opprettede personer:\n\n");
       
        if (personList.isEmpty()) {
            s.append("          --- Ingen personer er opprettet ennå ---\n");
        }
        else {
            for (Person person : personList) {
                s.append("          -  ").append(person.getLastName()).append(", ").append(person.getFirstName()).append(" - ").append(person.getAge()).append(" år.\n");
            }
        }

        System.out.println(s);
    }

    //display info about a single person obtained through the argument "person"
    private static void displayPersons(Person person) {
        clearScreen();
        s = new StringBuilder();
        String topBar = "-------------------------------------------------------------------------------------------------------------------------\n";
        s.append(topBar).append("                                                       PERSON\n").append(topBar);
        s.append("                                  Her er informasjon om personen du oppga:\n\n");
       
        s.append("           Fornavn: ").append(person.getFirstName()).append("\n");
        s.append("           Etternavn: ").append(person.getLastName()).append("\n");
        s.append("           Fødselsår: ").append(person.getBirthYear()).append("\n");
        s.append("           Alder: ").append(person.getAge()).append("\n");
        System.out.println(s);
    }

    //display a list of created persons to choose from. Return chosen person
    private static Person personListChoice() {
        clearScreen();
        s = new StringBuilder();
        String topBar = "-------------------------------------------------------------------------------------------------------------------------\n";
        s.append(topBar).append("                                                       PERSONLISTE\n").append(topBar);
        s.append("                                       Velg en person under ved å skrive et tall:\n\n");
       
        int i = 1;
        for (Person person : personList) {
            s.append("          [").append(i).append("]  ").append(person.getLastName()).append(", ").append(person.getFirstName()).append(" - ").append(person.getAge()).append(" år.\n");
            i++;
        }
        System.out.println(s);

        int choice;
        do {
            choice = Integer.parseInt(getInput());
            if (!(choice < 0 && choice > i)) {
                System.err.println("Ugyldig verdi for valg av person: Velg et gyldig tall tilhørende en person ovenfor");
            }
        }
        while (choice < 0 && choice > i);

        return personList.get(choice - 1);
    }

    //creating a person
    private static Person createPerson() {
        System.out.print("Oppgi et fornavn: ");
        String firstName = getInput();
        
        System.out.print("\nOppgi et etternavn: ");
        String lastName = getInput();
        
        int birthYear;
        do {
            System.out.print("\nOppgi et fødselsår: ");
            birthYear  = Integer.parseInt(getInput());
        }
        while (birthYear < 1920 && birthYear > LocalDate.now().getYear() - 16); 

        Person person = new Person(firstName, lastName, birthYear);
        
        displayPersons(person);

        boolean e = true;
        while (e) {
            System.out.println("Vil du sikker på at du vil opprette denne personen? \"y\" for JA og \"n\" for NEI.");
            String inp = getInput(); 
                    
            if (inp.equalsIgnoreCase("y")) {
                personList.add(person);
                e = false;
            }
            else if (inp.equalsIgnoreCase("n")) {
                e = false;
            }
            else {
                System.out.printf("\n\"%s\" er ikke en gyldig verdi for valget. Du må skrive enten \"y\" eller \"n\".\n", inp);
            }
        }
        return person;
    }

    private static void displayEmployee() {
        s = new StringBuilder();
        String topBar = "-------------------------------------------------------------------------------------------------------------------------\n";
        s.append(topBar).append("                                                     ARBEIDSTAKERLISTE\n").append(topBar);
        s.append("                               Nedenfor er en liste med alle opprettede arbeidstakere:\n\n");

        if (employeeList.isEmpty()) {
            s.append("          --- Ingen arbeidstakere er lagt til ennå ---");
        }
        else {
            for (ArbTaker employee : employeeList) {
                s.append(topBar);
                s.append("              •  Arbeidstakers ID: ").append(employee.getWorkerID()).append("\n");
                s.append("              •  Fullt name: ").append(employee.getFullName()).append("\n");
                s.append("              •  Startet/ Starter: ").append(employee.getStartingYear()).append("\n");
                s.append("              •  Antall år jobbet: ").append(employee.getEmployeYearsWorked()).append("\n");
                s.append("              •  Alder: ").append(employee.getEmployeAge()).append("\n\n");
    
                s.append("              •  Månedslønn (netto): ").append(employee.getSalary()).append("\n");
                s.append("              •  Årslønn (netto): ").append(employee.getYearlySalary()).append("\n");
                s.append("              •  Skatt: ").append(employee.getTaxPercent()).append("\n");
                s.append("              •  Skatt i penger per måned: ").append(String.format("%.2f", employee.getTaxMoney())).append("\n");
                s.append("              •  Skatt i penger per år: ").append(String.format("%.2f", employee.getTaxMoneyYearly())).append("\n");
                s.append(topBar);
            }
        }
        
        System.out.println(s);
    }

    private static void displayEmployee(ArbTaker employee) {
       clearScreen();
        s = new StringBuilder();
        String topBar = "-------------------------------------------------------------------------------------------------------------------------\n";
        s.append(topBar).append("                                                     ARBEIDSTAKERLISTE\n").append(topBar);
        s.append("                               Nedenfor er informasjon over den valgte arbeidstakeren:");
        
        s.append("\n\n");
        s.append("              •  Arbeidstakers ID: ").append(employee.getWorkerID()).append("\n");
        s.append("              •  Fullt name: ").append(employee.getFullName()).append("\n");
        s.append("              •  Startet/ Starter: ").append(employee.getStartingYear()).append("\n");
        s.append("              •  Antall år jobbet: ").append(employee.getEmployeYearsWorked()).append("\n");
        s.append("              •  Alder: ").append(employee.getEmployeAge()).append("\n\n");

        s.append("              •  Månedslønn (netto): ").append(employee.getSalary()).append("\n");
        s.append("              •  Årslønn (netto): ").append(employee.getYearlySalary()).append("\n");
        s.append("              •  Skatt: ").append(employee.getTaxPercent()).append("\n");
        s.append("              •  Skatt i penger per måned: ").append(String.format("%.2f", employee.getTaxMoney())).append("\n");
        s.append("              •  Skatt i penger per år: ").append(String.format("%.2f", employee.getTaxMoneyYearly())).append("\n");
        s.append("\n");
        
        System.out.println(s);
    }

    public static void checkContinue() {
        boolean e = true;
        while (e) {
            System.out.println("Er du sikker på at du vil avslutte? \"y\" for JA og \"n\" for NEI.");
            String inp = getInput(); 
                    
            if (inp.equalsIgnoreCase("y")) {
                running = false;
                e = false;
            }
            else if (inp.equalsIgnoreCase("n")) {
                e = false;
            }
            else {
                System.out.printf("\n\"%s\" er ikke en gyldig verdi for valget. Du må skrive enten \"y\" eller \"n\".\n", inp);
            }
        }
    }

    public static void end() {
        myReader.close();
    }
}
