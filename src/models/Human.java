package models;

import java.util.Scanner;

public class Human extends Player{
    private Scanner scanner = new Scanner(System.in);

    public Human(int id, String name, Symbol symbol) {
        super(id, name, symbol);
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println(super.getName()+"'s turn to make a move");

        System.out.println("Please enter row");
        int row = scanner.nextInt();

        System.out.println("Please enter column");
        int column = scanner.nextInt();

        return new Move(this, new Cell(row,column));
    }
}
