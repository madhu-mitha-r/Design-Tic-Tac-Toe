package models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int boardSize;
    private List<List<Cell>> grid;



    public Board(int boardSize) {
        this.boardSize = boardSize;
        grid = new ArrayList<>();

        // add cell for the board
        for (int i = 0; i < boardSize; i++) {
            grid.add(i,new ArrayList<>());
            for (int j = 0; j < boardSize; j++) {
                grid.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getBoardSize() {
        return this.boardSize;
    }

    public void display(){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                grid.get(i).get(j).display();
            }
            System.out.println("");
        }
    }
}
