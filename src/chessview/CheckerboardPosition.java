package chessview;

public class CheckerboardPosition {
    private int row;
    private int column;
    private String color;

    public CheckerboardPosition(int row, int column, String color){
        setRow(row);
        setColumn(column);
        setColor(color);
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
        return color;
    }

    public void setColor(String color) {
        if (color.equals("white") || color.equals("black")){
            this.color = color;
        } else {
            this.color = "black";
        }
    }
}
