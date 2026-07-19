import Controllers.TicTacToeController;
import models.TicTacToeGame;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hi from Client !!");

        TicTacToeController controller = new TicTacToeController();
        controller.startGame();
        controller.displayGame();
    }
}
