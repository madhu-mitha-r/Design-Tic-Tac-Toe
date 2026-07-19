package Exceptions;

public class CellAlreadyFilledException extends RuntimeException {
    public CellAlreadyFilledException(int row, int col) {
        super("Cell index"+ row + " "+ col + " already filled");
    }
}
