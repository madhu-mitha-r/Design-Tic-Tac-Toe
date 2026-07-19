package factories;

import models.BotDifficultyLevel;
import stratergies.BotDifficultStrategy;
import stratergies.EasyBotDifficultStrategy;
import stratergies.HardDifficultStrategy;
import stratergies.MediumBotDifficultlyStrategy;

public class BotDifficultlyStrategyFactory {

    // Factory method implementation
    public static BotDifficultStrategy getBotDifficultlyStrategy(BotDifficultyLevel level){
        return switch (level) {
            case EASY -> new EasyBotDifficultStrategy();
            case HARD -> new HardDifficultStrategy();
            case MEDIUM -> new MediumBotDifficultlyStrategy();
            default -> throw new IllegalArgumentException("Invalid Bot Difficulty Level");
        };
    }
}
