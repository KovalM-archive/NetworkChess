package gameplay;

import chessview.DeskView;
import chessview.piece.PieceView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickOnPieceListener implements MouseListener{
    private DeskView gameDesk;
    private PieceView currentPiece;

    public ClickOnPieceListener(DeskView gamesDesk, PieceView currentPiece){
        this.gameDesk = gamesDesk;
        this.currentPiece = currentPiece;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (currentPiece.equals(gameDesk.getCurrentPiece())){
            gameDesk.setCurrentPiece(null);
            currentPiece.notChoose();
        } else{
            if (gameDesk.getCurrentPiece() != null){
                gameDesk.getCurrentPiece().notChoose();
            }
            gameDesk.setCurrentPiece(currentPiece);
            currentPiece.choose();
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
