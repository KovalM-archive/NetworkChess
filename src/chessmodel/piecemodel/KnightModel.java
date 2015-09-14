package chessmodel.piecemodel;

import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

public class KnightModel extends PieceModel {

    public KnightModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
    }

    @Override
    public boolean gameLogic(PositionWithPiece newPosition) {
        return true;
    }
}
