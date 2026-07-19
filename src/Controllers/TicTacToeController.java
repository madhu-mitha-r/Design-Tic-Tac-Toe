package Controllers;

import models.*;
import stratergies.ColumnStrategy;
import stratergies.RowStrategy;
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
        winingStrategies.add(new RowStrategy());
        winingStrategies.add(new ColumnStrategy());

        this.game = new TicTacToeGame(boardSize, players, winingStrategies);

        while(game.getGameState() == GameState.IN_PROGRESS){
            game.makeMove();
            game.displayGame();

            System.out.println("Do you want to undo the last move? [Y/N]");
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("Y")) {
                game.undoLastMove();
                System.out.println("Undo completed");
                game.displayGame();
            }
        }

        if(game.getGameState().equals(GameState.SUCCESS)){
            System.out.println("GAME OVER !!"+ game.getWinner().getName()+" is the Winner!!");
        }else if(game.getGameState().equals(GameState.DRAW)){
            System.out.println("GAME OVER !!, Its a DRAW");
        }

        game.displayGame();
    }

    private int getBoardSize(){
        System.out.println("Please enter the size of the board");
        int size = sc.nextInt();
        sc.nextLine();
        return size;
    }

    private List<Player> getPlayers(int boardSize){
        List<Player> players = new ArrayList<>(boardSize);
        System.out.println("Let's add Players to the Board");
        System.out.println("Do you want Bot? [Y/N]");

        String input = sc.nextLine();
        int playerCount = boardSize-1;

        if(input.equalsIgnoreCase("Y")){

          players.add(new Bot(0,"Bot",new Symbol("B"), BotDifficultyLevel.EASY));
          playerCount--;
        }

        for(int i = 0; i < playerCount; i++){
            System.out.println("Please enter the name and the symbol of the player");
            String[] playerDetails = sc.nextLine().split(" ");
            players.add(new Human(1,playerDetails[0], new Symbol(playerDetails[1])));
        }

        return players;
    }

}
