package chessview.pieceview;

import chessmodel.piecemodel.KnightModel;
import chessmodel.CheckerboardPosition;

public class KnightView extends PieceView {
    public KnightView(String color, CheckerboardPosition startingPosition){
        super();
        pieceModel = new KnightModel(color, startingPosition);
        setColor(color);
        goToPosition(startingPosition);
        setPiecePicture(color.equals("black") ? PieceConstants.BLACK_KNIGHT : PieceConstants.WHITE_KNIGHT);
    }
}
