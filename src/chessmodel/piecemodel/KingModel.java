package chessmodel.piecemodel;

import chessmodel.DeskModel;
import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

import java.util.List;

public class KingModel extends PieceModel {
    private boolean using;
    public KingModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
        setUsing(false);
    }

    @Override
    public List<PositionWithPiece> getAllCandidate(DeskModel deskModel) {
        return null;
    }


    public boolean isUsing() {
        return using;
    }

    public void setUsing(boolean using) {
        this.using = using;
    }
}
