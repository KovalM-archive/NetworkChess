package chessmodel.piecemodel;

import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

public abstract class PieceModel {
    protected String color;
    protected CheckerboardPosition piecePosition;

    public PieceModel(String color, CheckerboardPosition piecePosition){
        setColor(color);
        setPiecePosition(piecePosition);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract boolean gameLogic(PositionWithPiece newPosition);

    public CheckerboardPosition getPiecePosition() {
        return piecePosition;
    }

    public void setPiecePosition(CheckerboardPosition piecePosition) {
        this.piecePosition = piecePosition;
    }
}
