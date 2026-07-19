package stratergies;
import models.Board;
import models.Move;


public class DiagonalStrategy implements WiningStrategy {

    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
