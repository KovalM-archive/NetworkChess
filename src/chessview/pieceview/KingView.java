package chessview.pieceview;

import chessmodel.piecemodel.KingModel;
import chessmodel.CheckerboardPosition;

public class KingView extends PieceView {
    public KingView(String color, CheckerboardPosition startingPosition){
        super();
        pieceModel = new KingModel(color, startingPosition);
        setColor(color);
        goToPosition(startingPosition);
        setPiecePicture(color.equals("black") ? PieceConstants.BLACK_KING : PieceConstants.WHITE_KING);
    }
}
