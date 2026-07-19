package stratergies;

import models.Board;

public interface WiningStrategy {
    boolean checkWinner(Board board);
}
