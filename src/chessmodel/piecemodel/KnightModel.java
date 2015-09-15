package chessmodel.piecemodel;

import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

public class KnightModel extends PieceModel {

    public KnightModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
    }

    @Override
    public boolean gameLogic(PositionWithPiece newPosition) {
        boolean answer = false;
        int row = newPosition.getRow();
        int column = newPosition.getColumn();
        if ((Math.abs(piecePosition.getRow()-row)==2 && Math.abs(piecePosition.getColumn()-column)==1) ||
                (Math.abs(piecePosition.getRow()-row)==1 && Math.abs(piecePosition.getColumn()-column)==2)){
            answer = true;
        }
        if (newPosition.getPiece()!=null && newPosition.getPiece().getColor().equals(color)){
            answer = false;
        }
        return answer;
    }
}
