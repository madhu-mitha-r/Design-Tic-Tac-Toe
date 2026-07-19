package Controllers;

import models.Human;
import models.Player;
import models.Symbol;
import models.TicTacToeGame;
import stratergies.WiningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeController {

    Scanner sc = new Scanner(System.in);
    private TicTacToeGame game;

    public void startGame() {

        int boardSize = getBoardSize();
        List<Player> players = getPlayers(boardSize);
        List<WiningStrategy> winingStrategies = new ArrayList<>();

        this.game = new TicTacToeGame(boardSize, players, winingStrategies);
    }

    private int getBoardSize(){
        System.out.println("Please enter the size of the board");
        int size = sc.nextInt();
        sc.nextLine();
        return size;
    }

    private List<Player> getPlayers(int boardSize){
        List<Player> players = new ArrayList<>(boardSize);

        for(int i = 0; i < boardSize-1; i++){
            System.out.println("Please enter the name and the symbol of the player");
            String[] playerDetails = sc.nextLine().split(" ");
            players.add(new Human(1,playerDetails[0], new Symbol(playerDetails[1])));
        }

        return players;
    }

    public void displayGame(){
        this.game.displayGame();
    }


}
