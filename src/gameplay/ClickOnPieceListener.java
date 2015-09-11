package gameplay;

import chessview.CheckerboardPosition;
import chessview.DeskView;
import chessview.piece.PieceView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickOnPieceListener implements MouseListener{
    private DeskView gameDesk;
    private PieceView choosePiece;

    public ClickOnPieceListener(DeskView gamesDesk, PieceView choosePiece){
        this.gameDesk = gamesDesk;
        this.choosePiece = choosePiece;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        PieceView currentPiece = gameDesk.getCurrentPiece();
        if (choosePiece.getColor().equals(gameDesk.getWalkethPlayer())){
            if (choosePiece.equals(currentPiece)){
                gameDesk.setCurrentPiece(null);
                currentPiece.notChoose();
            } else {
                if (currentPiece != null){
                    currentPiece.notChoose();
                    choosePiece.choose();
                    gameDesk.setCurrentPiece(choosePiece);
                } else{
                    gameDesk.setCurrentPiece(choosePiece);
                    choosePiece.choose();
                }
            }
        } else{
            if (currentPiece != null){
                currentPiece.goToPosition(choosePiece.getCurrentPosition());
                gameDesk.remove(choosePiece);
                gameDesk.changePlayer();
                currentPiece.notChoose();
                gameDesk.setCurrentPiece(null);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
