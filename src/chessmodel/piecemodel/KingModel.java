package chessmodel.piecemodel;

import chessmodel.DeskModel;
import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;

import java.util.ArrayList;
import java.util.List;

public class KingModel extends PieceModel {
    public KingModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
    }

    @Override
    public List<PositionWithPiece> getAllCandidate(DeskModel deskModel) {
        List<PositionWithPiece> allCandidate = new ArrayList<>();
        passNeighboringCells(1, 0, deskModel, allCandidate);
        passNeighboringCells(0, 1, deskModel, allCandidate);
        passNeighboringCells(-1, 0, deskModel, allCandidate);
        passNeighboringCells(0, -1, deskModel, allCandidate);
        passNeighboringCells(1, 1, deskModel, allCandidate);
        passNeighboringCells(-1, -1, deskModel, allCandidate);
        passNeighboringCells(-1, 1, deskModel, allCandidate);
        passNeighboringCells(1, -1, deskModel, allCandidate);
        //removeBrokenCells(deskModel,allCandidate);
        return allCandidate;
    }

    private void removeBrokenCells(DeskModel deskModel, List<PositionWithPiece> allCandidate){
        List<PositionWithPiece> allPosition = deskModel.getAllPosition();
        List<PositionWithPiece> aliensCandidate;
        int n = allPosition.size();
        PieceModel currentPiece;
        for (int i = 0; i < n; i++) {
            currentPiece = allPosition.get(i).getPiece();
            if (currentPiece != null && !currentPiece.getColor().equals(color)){
                aliensCandidate = currentPiece.getAllCandidate(deskModel);
            }
        }
    }
    private boolean isStartingPosition(){
        boolean answer = false;
        if (color.equals("white") && piecePosition.equalsPosition(new CheckerboardPosition(7, 4))){
            answer = true;
        } else if (color.equals("black") && piecePosition.equalsPosition(new CheckerboardPosition(0, 4))){
            answer = true;
        }
        return answer;
    }
}
