package chessmodel.piecemodel;

import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

public class BishopModel extends PieceModel {

    public BishopModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
    }

    @Override
    public boolean gameLogic(PositionWithPiece newPosition) {
        return false;
    }
}
