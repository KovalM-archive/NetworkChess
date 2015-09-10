package chessview.piece;

import chessview.CheckerboardPosition;
import constants.PieceConstants;

public class BishopView extends PieceView{
    public BishopView(String color, CheckerboardPosition startingPosition){
        super();
        setColor(color);
        goToPosition(startingPosition);
        setPiecePicture(color.equals("black") ? PieceConstants.BLACK_BISHOP : PieceConstants.WHITE_BISHOP);
    }
}
