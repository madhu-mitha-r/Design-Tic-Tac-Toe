package models;

import factories.BotDifficultlyStrategyFactory;
import stratergies.BotDifficultStrategy;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;
    private BotDifficultStrategy botDifficultStrategy;

    public Bot(int id, String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botDifficultStrategy = BotDifficultlyStrategyFactory.getBotDifficultlyStrategy(botDifficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {
        return this.botDifficultStrategy.makeMove(board, this);
    }
}
