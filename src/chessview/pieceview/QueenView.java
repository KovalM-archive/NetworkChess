package chessview.pieceview;

import chessmodel.piecemodel.QueenModel;
import chessmodel.CheckerboardPosition;

public class QueenView extends PieceView{
    public QueenView(String color, CheckerboardPosition startingPosition){
        super();
        pieceModel = new QueenModel(color, startingPosition);
        setColor(color);
        goToPosition(startingPosition);
        setPiecePicture(color.equals("black") ? PieceConstants.BLACK_QUEEN : PieceConstants.WHITE_QUEEN);
    }
}
