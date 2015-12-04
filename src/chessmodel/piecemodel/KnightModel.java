package chessmodel.piecemodel;

import chessmodel.DeskModel;
import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

import java.util.ArrayList;
import java.util.List;

public class KnightModel extends PieceModel {
    public KnightModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
        setTitle(PieceModelConstants.KNIGHT_TITLE);
    }

    @Override
    public List<PositionWithPiece> getAllCandidate(DeskModel deskModel) {
        List<PositionWithPiece> allCandidate = new ArrayList<>();
        passNeighboringCells(1, 2, deskModel, allCandidate);
        passNeighboringCells(1, -2, deskModel, allCandidate);
        passNeighboringCells(-1, 2, deskModel, allCandidate);
        passNeighboringCells(-1, -2, deskModel, allCandidate);
        passNeighboringCells(2, 1, deskModel, allCandidate);
        passNeighboringCells(2, -1, deskModel, allCandidate);
        passNeighboringCells(-2, 1, deskModel, allCandidate);
        passNeighboringCells(-2, -1, deskModel, allCandidate);
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
