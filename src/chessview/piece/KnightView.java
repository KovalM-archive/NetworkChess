package chessview.piece;

import chessview.CheckerboardPosition;
import constants.PieceConstants;

public class KnightView extends PieceView {
    public KnightView(String color, CheckerboardPosition startingPosition){
        super();
        setColor(color);
        goToPosition(startingPosition);
        setPiecePicture(color.equals("black") ? PieceConstants.BLACK_KNIGHT : PieceConstants.WHITE_KNIGHT);
    }
}
