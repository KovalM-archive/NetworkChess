package gameplay;

import chessmodel.CheckerboardPosition;
import chessview.DeskView;
import chessview.pieceview.PieceView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickOnDeskListener implements MouseListener {
    private DeskView deskView;

    public ClickOnDeskListener(DeskView deskView){
        this.deskView = deskView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        PieceView currentPiece = deskView.getCurrentPiece();
        if (currentPiece != null) {
            if (300 < x && x <= 1020 && 0 < y && y <= 720) {
                x -= 300;
                deskView.moveCurrentPiece(new CheckerboardPosition(y /= 90, x /= 90));
                deskView.changePlayer();
                deskView.setCurrentPiece(null);
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
