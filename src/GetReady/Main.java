package GetReady;

import Battle.SelectPokemons;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p1 = sc.nextLine();
        String p2 = sc.nextLine();
        Initialize trainer = new Initialize(p1);
        Initialize opponent = new Initialize(p2);
        SelectPokemons selectPokemons =new SelectPokemons(trainer,opponent);
        selectPokemons.PrepareBattle();

    }
}