package stratergies;

import models.Board;
import models.Move;
import models.Player;


public interface BotDifficultStrategy {
    Move makeMove(Board board, Player player);
}
