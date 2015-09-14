package chessmodel.piecemodel;

import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

public class RookModel extends PieceModel {
    private boolean using;

    public RookModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
        setUsing(false);
    }

    @Override
    public boolean gameLogic(PositionWithPiece newPosition) {
        return false;
    }

    public boolean isUsing() {
        return using;
    }

    public void setUsing(boolean using) {
        this.using = using;
    }
}
