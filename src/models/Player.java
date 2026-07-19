package models;

public abstract class Player {
   private int id;
   private String name;
   private Symbol symbol;

    public Player(int id, String name, Symbol symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public abstract Move makeMove(Board board);
}
