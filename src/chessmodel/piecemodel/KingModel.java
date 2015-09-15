package chessmodel.piecemodel;

import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

public class KingModel extends PieceModel {
    private boolean using;
    public KingModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
        setUsing(false);
    }

    @Override
    public boolean gameLogic(PositionWithPiece newPosition) {
        boolean answer = false;
        int row = newPosition.getRow();
        int column = newPosition.getColumn();
        if (Math.abs(piecePosition.getRow()-row)<=1 && Math.abs(piecePosition.getColumn()-column)<=1){
            answer = true;
        }
        if (newPosition.getPiece()!=null && newPosition.getPiece().getColor().equals(color)){
            answer = false;
        }
        return answer;
    }

    public boolean isUsing() {
        return using;
    }

    public void setUsing(boolean using) {
        this.using = using;
    }
}
