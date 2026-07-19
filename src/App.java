import Controllers.TicTacToeController;
import models.TicTacToeGame;

public class App {
    public static void main(String[] args) throws Exception {
        TicTacToeController controller = new TicTacToeController();
        controller.startGame();
    }
}
