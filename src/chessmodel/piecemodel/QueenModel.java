package chessmodel.piecemodel;

import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

public class QueenModel extends PieceModel {
    public QueenModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
    }

    @Override
    public boolean gameLogic(PositionWithPiece newPosition) {
        boolean answer = false;
        int row = newPosition.getRow();
        int column = newPosition.getColumn();
        if ((Math.abs(piecePosition.getRow()-row)==Math.abs(piecePosition.getColumn()-column) &&
                !newPosition.equalsPosition(piecePosition))|| row==piecePosition.getRow()
                || column==piecePosition.getColumn()){
            answer = true;
        }
        if (newPosition.getPiece()!=null && newPosition.getPiece().getColor().equals(color)){
            answer = false;
        }
        return answer;
    }
}
