package models;

import Exceptions.CellAlreadyFilledException;
import Exceptions.InvalidCellException;
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
        this.currentPlayer = players.get(0);
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

    public Player getWinner() {
        return winner;
    }

    private void validateMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row < 0 || row >= this.board.getBoardSize() || col < 0 || col >= this.board.getBoardSize()){
            throw new InvalidCellException(row,col);
        }

        if(this.board.getCell(row,col).getCelltype().equals(CellType.FILLED)){
            throw new CellAlreadyFilledException(row,col);
        }
    }

    private boolean checkWinner(Move move){

        for(WiningStrategy winingStrategy : this.winingStrategies){
            if(winingStrategy.checkWinner(board, move)) return true;
        }

        return false;
    }

    private boolean checkDraw(){
        return moves.size() == board.getBoardSize() * board.getBoardSize();
    }

    private void updateGameWithMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellInBoard = board.getCell(row,col);
        cellInBoard.setPlayer(move.getPlayer());
        cellInBoard.setCellType(CellType.FILLED);

        int index  = players.indexOf(this.currentPlayer);
        index++;
        index %= players.size();
        this.currentPlayer = players.get(index);

        move.setCell(cellInBoard);
        moves.add(move);

    }

    public void makeMove(){

        Player current = currentPlayer;

        Move move = currentPlayer.makeMove(this.board);

        try {
            validateMove(move);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Please try again");
            return;
        }

        updateGameWithMove(move);

        if(checkWinner(move)){
            this.gameState = GameState.SUCCESS;
            this.winner = current;
        } else if(checkDraw()){
            this.gameState = GameState.DRAW;
        }

    }

}
