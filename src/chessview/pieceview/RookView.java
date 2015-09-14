package chessview.pieceview;

import chessmodel.piecemodel.RookModel;
import chessmodel.CheckerboardPosition;

public class RookView extends PieceView{
    public RookView(String color, CheckerboardPosition startingPosition){
        super();
        pieceModel = new RookModel(color, startingPosition);
        setColor(color);
        goToPosition(startingPosition);
        setPiecePicture(color.equals("black") ? PieceConstants.BLACK_ROOK : PieceConstants.WHITE_ROOK);
    }
}
