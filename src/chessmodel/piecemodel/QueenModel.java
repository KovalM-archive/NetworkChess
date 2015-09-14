package chessmodel.piecemodel;

import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

public class QueenModel extends PieceModel {
    public QueenModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
    }

    @Override
    public boolean gameLogic(PositionWithPiece newPosition) {
        return false;
    }
}
