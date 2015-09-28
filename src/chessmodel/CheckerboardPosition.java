package chessmodel;

import java.io.Serializable;

public class CheckerboardPosition implements Serializable {
    private int row;
    private int column;

    public CheckerboardPosition(int row, int column){
        setRow(row);
        setColumn(column);
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getColor() {
        if ((row+column) % 2==0) {
            return "white";
        } else {
            return "black";
        }
    }

    public boolean equalsPosition(CheckerboardPosition anotherPosition){
        if (row == anotherPosition.getRow() && column == anotherPosition.getColumn()){
            return true;
        } else {
            return false;
        }
    }
}
