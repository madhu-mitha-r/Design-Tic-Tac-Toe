package Exceptions;

public class InvalidCellException extends RuntimeException {

    public InvalidCellException(int row, int col) {
        super("Invalid cell at row " + row + ", col " + col);
    }
}
