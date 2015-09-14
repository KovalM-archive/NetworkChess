package chessmodel;

import chessmodel.piecemodel.PieceModel;

import java.util.ArrayList;
import java.util.List;

public class DeskModel {
    private String walkethPlayer;
    private List<PositionWithPiece> allPosition;
    private List<PositionWithPiece> allCandidate;

    public DeskModel(){
        setWalkethPlayer("white");
        createEmptyDesk();
        setAllCandidate(null);
    }

    public void createCandidateList(PieceModel currentPiece){
        allCandidate = new ArrayList<PositionWithPiece>();
        PositionWithPiece currentPosition;
        int n = allPosition.size();
        for (int i = 0; i < n; i++) {
            currentPosition = allPosition.get(i);
            if (currentPiece.gameLogic(currentPosition)){
                allCandidate.add(currentPosition);
            }
        }
    }

    public String getWalkethPlayer() {
        return walkethPlayer;
    }

    public void setWalkethPlayer(String walkethPlayer) {
        this.walkethPlayer = walkethPlayer;
    }

    public void changePlayer(){
        walkethPlayer = walkethPlayer.equals("white") ? "black" : "white";
    }

    public void addPosition(PositionWithPiece currentPosition){
        if (currentPosition != null) {
            allPosition.add(currentPosition);
        }
    }

    private void createEmptyDesk(){
        allPosition = new ArrayList<PositionWithPiece>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                addPosition(new PositionWithPiece(i, j));
            }
        }
    }

    public void addPieceOnPosition(PieceModel currentPiece){
        int n = allPosition.size();
        PositionWithPiece currentPosition;
        for (int i = 0; i < n; i++) {
            currentPosition = allPosition.get(i);
            if (currentPosition.equalsPosition(currentPiece.getPiecePosition())){
                currentPosition.setPiece(currentPiece);
            }
        }
    }

    public void removePieceFromPosition(PieceModel currentPiece){
        int n = allPosition.size();
        PositionWithPiece currentPosition;
        for (int i = 0; i < n; i++) {
            currentPosition = allPosition.get(i);
            if (currentPosition.getPiece()!=null && currentPosition.getPiece().equals(currentPiece)){
                currentPosition.setPiece(null);
            }
        }
    }

    public List<PositionWithPiece> getAllCandidate() {
        return allCandidate;
    }

    public void setAllCandidate(List<PositionWithPiece> allCandidate) {
        this.allCandidate = allCandidate;
    }
}
