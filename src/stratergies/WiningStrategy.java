package stratergies;

import models.Board;
import models.Move;


public interface WiningStrategy {
    boolean checkWinner(Board board, Move move);
    void handleUndo(Move move);
}
