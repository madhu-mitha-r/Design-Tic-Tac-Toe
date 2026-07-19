package models;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;

    public Bot(int id, String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
