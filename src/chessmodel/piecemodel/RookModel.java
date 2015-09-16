package chessmodel.piecemodel;

import chessmodel.DeskModel;
import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

import java.util.ArrayList;
import java.util.List;

public class RookModel extends PieceModel {
    private boolean using;

    public RookModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
        setUsing(false);
    }

    @Override
    public List<PositionWithPiece> getAllCandidate(DeskModel deskModel) {
        List<PositionWithPiece> allCandidate = new ArrayList<>();
        passDirection(1, 0, deskModel, allCandidate);
        passDirection(0, 1, deskModel, allCandidate);
        passDirection(-1, 0, deskModel, allCandidate);
        passDirection(0, -1, deskModel, allCandidate);
        return allCandidate;
    }

    public boolean isUsing() {
        return using;
    }

    public void setUsing(boolean using) {
        this.using = using;
    }
}
