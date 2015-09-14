package chessmodel.piecemodel;

import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

public class PawnModel extends PieceModel {
    public PawnModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
    }

    @Override
    public boolean gameLogic(PositionWithPiece newPosition) {
        boolean answer = false;
        int delta;
        if (color.equals("white")){
            if (newPosition.getPiece() != null){
                if (piecePosition.getRow()-newPosition.getRow()==1 &&
                        Math.abs(piecePosition.getColumn()-newPosition.getColumn())==1){
                    answer = true;
                }
            } else {
                delta = piecePosition.getRow()==6 ? 2 : 1;
                if (piecePosition.getRow() - newPosition.getRow()<=delta &&
                        piecePosition.getRow() - newPosition.getRow()>0 &&
                        piecePosition.getColumn() == newPosition.getColumn()){
                    answer = true;
                }
            }
        } else {
            if (newPosition.getPiece() != null){
                if (piecePosition.getRow()-newPosition.getRow()==-1 &&
                        Math.abs(piecePosition.getColumn()-newPosition.getColumn())==1){
                    answer = true;
                }
            } else {
                delta = piecePosition.getRow() == 1 ? 2 : 1;
                if (newPosition.getRow() - piecePosition.getRow() <= delta &&
                        newPosition.getRow() - piecePosition.getRow() > 0 &&
                        piecePosition.getColumn() == newPosition.getColumn()) {
                    answer = true;
                }
            }
        }
        return answer;
    }
}
