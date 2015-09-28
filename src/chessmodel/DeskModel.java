package chessmodel;

import chessmodel.piecemodel.KingModel;
import chessmodel.piecemodel.PieceModel;

import java.util.ArrayList;
import java.util.List;

public class DeskModel {
    private String walkethPlayer;
    private List<PositionWithPiece> allPosition;
    private List<PositionWithPiece> allCandidate;
    private String colorOfPlayer;

    public DeskModel(){
        setWalkethPlayer("white");
        createEmptyDesk();
        setAllCandidate(null);
    }

    public void createCandidateList(PieceModel currentPiece){
        allCandidate = currentPiece.getAllCandidate(this);
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

    public PositionWithPiece getEqualElement(CheckerboardPosition currentPossition){
        int n = allPosition.size();
        PositionWithPiece answerPosition;
        for (int i = 0; i < n; i++) {
            answerPosition = allPosition.get(i);
            if (answerPosition.equalsPosition(currentPossition)){
                return answerPosition;
            }
        }
        return null;
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
                break;
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
    public List<PositionWithPiece> getAllPosition(){ return allPosition;}
    public void setAllCandidate(List<PositionWithPiece> allCandidate) {
        this.allCandidate = allCandidate;
    }
    public boolean checkDeskBorder(int x, int y) {
        if (0 <= x && x <= 7 && 0 <= y && y <= 7) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkShahThreat(String playerColor, List<PositionWithPiece> allPositionFutureState){
        boolean answer = false;
        PositionWithPiece kingPosition = null;
        PieceModel enemyPiece;
        List<PositionWithPiece> attackedPosition;

        for (PositionWithPiece currentPosition : allPositionFutureState){
            if (currentPosition.getPiece()!=null && currentPosition.getPiece().getColor().equals(playerColor) &&
                    currentPosition.getPiece() instanceof KingModel){
                kingPosition = currentPosition;
                break;
            }
        }

        for (PositionWithPiece currentPosition : allPositionFutureState){
            enemyPiece = currentPosition.getPiece();
            if (enemyPiece!=null && !enemyPiece.getColor().equals(playerColor) &&
                    enemyPiece != null){
                attackedPosition = enemyPiece.getAttackedPositions(this);
                if (attackedPosition.contains(kingPosition)) {
                    answer = true;
                    break;
                }
            }
        }
        return answer;
    }

    public boolean checkForCheckmate(){
        boolean answer = true;
        PieceModel currentPiece;
        for(PositionWithPiece currentPosition : allPosition){
            currentPiece = currentPosition.getPiece();
            if (currentPiece != null && currentPiece.getColor().equals(walkethPlayer)){
                if (currentPiece.getAllCandidate(this).size()>0){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

    public String getColorOfPlayer() {
        return colorOfPlayer;
    }

    public void setColorOfPlayer(String colorOfPlayer) {
        this.colorOfPlayer = colorOfPlayer;
    }
}
