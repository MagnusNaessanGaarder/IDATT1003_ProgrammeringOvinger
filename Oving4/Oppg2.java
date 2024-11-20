package Oving4;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

class Player {
    private String name;
    private int sumPoeng;
    private boolean isWinner;

    //konstruktør for klassen Player
    public Player(String name, int sumPoeng) {
        //sikrer at verdier for navn og poengsum er gyldig
        this.name = name;
        this.sumPoeng = sumPoeng;
        this.isWinner = false;
    } 

    //metode for å hilse på spilleren.
    public void greetPlayer() {
        System.out.println("Hei, "+ name +"!\n\n");
        return;
    }

    //metode for å hente navnet til spilleren
    public String getName() {
        return name;
    }

    //metode for å kaste terning.
    public int kast() {
        Random rand = new Random();
        int terningkast = rand.nextInt(6) + 1;
        System.out.println();
        return terningkast;
    }

    //Metode som sjekker om en spiller har vunnet
    public boolean checkWinner() {
        return isWinner;
    }

    //Metode som gratulerer vinneren
    public boolean winner() {
        System.out.println("Gratulerer " + name + "! Du vant 100 poeng-spillet!");
        return true;
    }

    //Metode som lager en ny poengsum til spilleren med parameteren kast(terningkastet)
    public int getSumPoeng(int kast) {
        if (kast != 1) {
            sumPoeng += kast;
            if (sumPoeng == 100) {
                isWinner = true;
            }
            else if (sumPoeng > 100) {
                sumPoeng -= kast;
            }
        }
        else {
            sumPoeng = 0;
        }
        
        return sumPoeng;
    }
}

//Trenger kanskje ikke en hel klasse for å lage en spiller-liste (kanskje nyttig om man skal spille flere ganger)
/* 
class PlayerList {
    private Player p;
    private List<Player>list = new LinkedList(Collections.<Player>emptyList());
    
    public PlayerList(Player p) {
        this.p = p;
    }

    public addPlayer(Player p) {
        list.add(p);
        return list;
    }

    public choosePlayer(int index) {
        return list.get(i);
    }
}
*/

class Oppg2 {
    //Lager en tom global variabel av typen liste, som tar inn Player-objekter. Skal holde styr på spillere. 
    private static List<Player> playerList = new LinkedList<Player>(Collections.<Player>emptyList());

    //Metode som rydder opp i terminalen.
    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    //Metode som lager en Scanner for å lete etter brukerinput (Bare hvis scannerObj.hasNextLine() er gitt).
    public static String getInput(Scanner myReader) {
        String data = "";
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            return data;
        }
        myReader.close();
        return data; 
    }

    //Metode som genererer spillere
    public static void playerGen(int n, Scanner reader) {
        String player_name;
        
        for (int i = 1; i <= n; i++) {
            System.out.printf("Hva heter du, Spiller %d?\n", i);
            player_name = getInput(reader);
            Player player = new Player(player_name, 0);

            playerList.add(player);
            clearScreen();
            player.greetPlayer();
        }

        //lager en try-catch-løkke for å håndtere feil ved ugyldige verdier for objektet TimeUnit
        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch(InterruptedException e) {
            System.err.println("Error: " + e);
        }
        return;
    }
    
    //Main-kodeblokk
    public static void main(String[] args) {
        Scanner myReader = new Scanner(System.in);
        
        clearScreen();
        System.out.println("Hvor mange spillere skal spille?");
        int antallSpillere = Integer.parseInt(getInput(myReader));
        playerGen(antallSpillere, myReader);

        clearScreen();

        boolean hasWinner = false;
        int turn = 1;
        
        //Spiller helt til ingen av spillerne har vunnet
        while (!hasWinner) {
            
            System.out.printf("""
            ****************************************************
            !                     Turn %d                       !
            ****************************************************
            """, turn); 

            //Går gjennom spillerne og oppdaterer kast og score
            for (int i = 0; i < playerList.size(); i++) {
                int val = playerList.get(i).kast();

                System.out.println("\nSpiller: " + playerList.get(i).getName());
                System.out.println("Kast: " + val);
                System.out.println("Poeng: " + playerList.get(i).getSumPoeng(val) + "\n");

                if (playerList.get(i).checkWinner()) {
                    hasWinner = playerList.get(i).winner();
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                }
                catch(InterruptedException e) {
                    System.err.println("Error: " + e);
                }
            }

            turn++;
        }
    }
}
