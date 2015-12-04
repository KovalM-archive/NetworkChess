package chessmodel.piecemodel;

import chessmodel.DeskModel;
import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

import java.util.ArrayList;
import java.util.List;

public class BishopModel extends PieceModel {
    public BishopModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
        setTitle(PieceModelConstants.BISHOP_TITLE);
    }

    public List<PositionWithPiece> getAllCandidate(DeskModel deskModel){
        List<PositionWithPiece> allCandidate = new ArrayList<>();
        passDirection(1, 1, deskModel, allCandidate);
        passDirection(1, -1, deskModel, allCandidate);
        passDirection(-1, 1, deskModel, allCandidate);
        passDirection(-1, -1, deskModel, allCandidate);
        if (deskModel.getWalkethPlayer().equals(color)) {
            checkForOccurrenceShah(deskModel, allCandidate);
        }
        return allCandidate;
    }

    @Override
    public List<PositionWithPiece> getAttackedPositions(DeskModel deskModel) {
        return getAllCandidate(deskModel);
    }
}
