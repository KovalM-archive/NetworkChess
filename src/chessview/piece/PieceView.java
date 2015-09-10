package chessview.piece;

import chessview.CheckerboardPosition;
import constants.PieceConstants;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;

public abstract class PieceView {
    private JLabel piece;
    private String color;
    private CheckerboardPosition currentPosition;

    protected PieceView(){
        piece = new JLabel();
        piece.setBackground(new Color(255, 255, 255, 0));
    }

    protected void setPiecePicture(ImageIcon piecePicture) {
        piece.setIcon(piecePicture);
    }

    public JLabel getPiece(){
        return piece;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    protected ImageIcon getPiecePictureByColor(ImageIcon blackVersion, ImageIcon whiteVersion){
        return color.equals("black")?blackVersion:whiteVersion;
    }

    public void goToPosition(CheckerboardPosition newPosition){
        piece.setBounds(300+newPosition.getColumn() * 90, newPosition.getRow() * 90, 90, 90);
        setCurrentPosition(newPosition);
    }

    public CheckerboardPosition getCurrentPosition() {
        return currentPosition;
    }

    protected void setCurrentPosition(CheckerboardPosition currentPosition) {
        this.currentPosition = currentPosition;
    }
}
