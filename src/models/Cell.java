package models;


public class Cell {
   private int row;
   private int col;
   private CellType celltype;
   private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.celltype = CellType.EMPTY;
        this.player = null;
    }


    //setter
    public void setPlayer(Player player) {
        this.player = player;
    }


    //getters
    public Player getPlayer() {
        return this.player;
    }

    public CellType getCelltype() {
        return celltype;
    }

    public void display(){
        if(this.celltype.equals(CellType.EMPTY)){
            System.out.print("|-|");
        }else {
            System.out.print("|"+this.player.getSymbol().getPattern()+"|");
        }
    }
}
