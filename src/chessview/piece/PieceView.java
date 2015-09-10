package chessview.piece;

import chessview.CheckerboardPosition;
import constants.PieceConstants;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;

public abstract class PieceView extends JLabel {
    private String color;
    private CheckerboardPosition currentPosition;

    protected PieceView(){
        setBackground(new Color(255, 255, 255, 0));
    }

    protected void setPiecePicture(ImageIcon piecePicture) {
        setIcon(piecePicture);
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
        setBounds(300 + newPosition.getColumn() * 90, newPosition.getRow() * 90, 90, 90);
        setCurrentPosition(newPosition);
    }

    public CheckerboardPosition getCurrentPosition() {
        return currentPosition;
    }

    protected void setCurrentPosition(CheckerboardPosition currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void choose(){
        setBorder(BorderFactory.createLineBorder(Color.green, 3));
    }

    public void notChoose(){
        setBorder(null);
    }
}
