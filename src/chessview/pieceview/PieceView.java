package chessview.pieceview;

import chessmodel.piecemodel.PieceModel;
import chessmodel.CheckerboardPosition;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;

public abstract class PieceView extends JLabel {
    private String color;
    protected PieceModel pieceModel;

    protected PieceView(){
        setBackground(new Color(255, 255, 255, 0));
    }

    public void setPiecePicture(ImageIcon piecePicture) {
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
        return pieceModel.getPiecePosition();
    }

    protected void setCurrentPosition(CheckerboardPosition currentPosition) {
        pieceModel.setPiecePosition(currentPosition);
    }

    public void choose(){
        setBorder(BorderFactory.createLineBorder(Color.green, 2));
    }

    public void notChoose(){
        setBorder(null);
    }

    public PieceModel getPieceModel() {
        return pieceModel;
    }

    public void setPieceModel(PieceModel pieceModel) {
        this.pieceModel = pieceModel;
    }
}
