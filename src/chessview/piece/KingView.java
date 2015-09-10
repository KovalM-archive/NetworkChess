package chessview.piece;

import chessview.CheckerboardPosition;
import constants.PieceConstants;

public class KingView extends PieceView {
    public KingView(String color, CheckerboardPosition startingPosition){
        super();
        setColor(color);
        goToPosition(startingPosition);
        setPiecePicture(color.equals("black") ? PieceConstants.BLACK_KING : PieceConstants.WHITE_KING);
    }
}
