package stratergies;

import models.Board;
import models.Move;

import java.util.HashMap;

public class RowStrategy implements WiningStrategy {
    private HashMap<Integer, HashMap<String,Integer>> rowMap;

    public RowStrategy(){
        this.rowMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        String pattern = move.getCell().getPlayer().getSymbol().getPattern();

        if(!rowMap.containsKey(row)){
            rowMap.put(row,new HashMap<String,Integer>());
        }

        if(!rowMap.get(row).containsKey(pattern)){
            rowMap.get(row).put(pattern,0);
        }

        rowMap.get(row).put(pattern,rowMap.get(row).get(pattern) + 1);

        return rowMap.get(row).get(pattern) == board.getBoardSize();
    }

    @Override
    public void handleUndo(Move move) {
        int row = move.getCell().getRow();
        String pattern = move.getPlayer().getSymbol().getPattern();

        rowMap.get(row).put(pattern,rowMap.get(row).get(pattern) -1);
    }
}
