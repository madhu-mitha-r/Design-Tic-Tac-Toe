package models;

import stratergies.WiningStrategy;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {

    private Board board;
    private List<Player> players;
    private Player winner;
    private Player currentPlayer;
    private List<WiningStrategy> winingStrategies;
    private List<Move> moves;
    private GameState gameState;

    public TicTacToeGame(int boardSize, List<Player> players, List<WiningStrategy> winingStrategies) {
        this.board = new Board(boardSize);
        this.players = players;
        this.winner = null;
        this.currentPlayer = null;
        this.winingStrategies = winingStrategies;
        this.gameState = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();
    }

    public void displayGame(){
      this.board.display();
    }

    public GameState getGameState() {
        return gameState;
    }

}
