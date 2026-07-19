package stratergies;

import models.Board;
import models.CellType;
import models.Move;
import models.Player;
import models.Cell;

public class EasyBotDifficultStrategy implements  BotDifficultStrategy {

    @Override
    public Move makeMove(Board board, Player player) {

        for(int i =0;i<board.getBoardSize();i++){
            for(int j =0;j<board.getBoardSize();j++){
                if(board.getCell(i,j).getCelltype().equals(CellType.EMPTY)){
                    return new Move(player, new Cell(i,j));
                }

            }
        }
        return null;
    }
}
