package stratergies;

import models.Board;

public class RowStrategy implements WiningStrategy {

    @Override
    public boolean checkWinner(Board board) {
        return false;
    }
}
