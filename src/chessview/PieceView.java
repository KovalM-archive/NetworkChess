package chessview;

import chessmodel.piecemodel.PieceModel;
import chessmodel.CheckerboardPosition;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;

public class PieceView extends JLabel {
    protected PieceModel pieceModel;

    public PieceView(PieceModel pieceModel){
        setPieceModel(pieceModel);
        goToPosition(pieceModel.getPiecePosition());
        setBackground(new Color(255, 255, 255, 0));
    }

    public int getTitle(){
        return pieceModel.getTitle();
    }
    public void setPiecePicture() {
        int colorSmeschenie = getColor().equals("white")?6:0; // change title of var
        ImageIcon piecePicture = PieceViewConstants.PIECE_ICONS[getTitle()+colorSmeschenie];
        setIcon(piecePicture);
    }

    public String getColor() {
        return pieceModel.getColor();
    }

    public void setColor(String color) {
        pieceModel.setColor(color);
    }

    public void goToPosition(CheckerboardPosition newPosition){
        setBounds(300 + newPosition.getColumn() * 90, newPosition.getRow() * 90, 90, 90);
        setCurrentPosition(newPosition);
    }

    public CheckerboardPosition getCurrentPosition() {
        return pieceModel.getPiecePosition();
    }

    public void setCurrentPosition(CheckerboardPosition currentPosition) {
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
        setPiecePicture();
    }
}
