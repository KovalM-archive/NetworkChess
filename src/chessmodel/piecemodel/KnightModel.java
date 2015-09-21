package chessmodel.piecemodel;

import chessmodel.DeskModel;
import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

import java.util.ArrayList;
import java.util.List;

public class KnightModel extends PieceModel {
    public KnightModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
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
        return allCandidate;
    }

    @Override
    public List<PositionWithPiece> getAtackPositions(DeskModel deskModel) {
        return getAllCandidate(deskModel);
    }
}
