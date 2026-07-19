package stratergies;

import models.Board;
import models.Move;

import java.util.HashMap;

public class ColumnStrategy implements WiningStrategy {
    private HashMap<Integer, HashMap<String,Integer>> colMap;

    public ColumnStrategy(){
        this.colMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        String pattern = move.getCell().getPlayer().getSymbol().getPattern();

        if(!colMap.containsKey(col)){
            colMap.put(col,new HashMap<String,Integer>());
        }

        if(!colMap.get(col).containsKey(pattern)){
            colMap.get(col).put(pattern,0);
        }

        colMap.get(col).put(pattern,colMap.get(col).get(pattern) + 1);

        return colMap.get(col).get(pattern) == board.getBoardSize();
    }
}
