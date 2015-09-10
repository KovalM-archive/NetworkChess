package chessview;

import chessview.piece.BishopView;
import chessview.piece.KingView;
import chessview.piece.KnightView;
import chessview.piece.PawnView;
import chessview.piece.PieceView;
import chessview.piece.QueenView;
import chessview.piece.RookView;
import gameplay.ClickOnPieceListener;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class DeskView extends JPanel {
    private BufferedImage buffer;
    private PieceView currentPiece;

    public DeskView(){
        super();
        setLayout(null);
        buffer = new BufferedImage(1500, 1500, BufferedImage.TYPE_INT_ARGB);
        drawDesk();
        setInitialState();
        setVisible(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(buffer, null,null);
    }

    private void drawDesk(){
        Graphics2D painter = (Graphics2D)buffer.getGraphics();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i+j) % 2 ==0){
                    painter.setColor(Color.white);
                } else {
                    painter.setColor(Color.gray);
                }
                painter.fillRect(300+j*90, i * 90, 90, 90);
            }
        }
        painter.setColor(Color.gray);
        painter.drawRect(300, 0, 720, 720);
        Font font = new Font("Tahoma", Font.BOLD, 20);
        painter.setFont(font);
        painter.setColor(Color.black);
        for (int i = 0; i < 8; i++) {
            painter.drawString(Integer.toString(8-i), 270, i*90+55);
        }

        for (int i = 0; i < 8; i++) {
            painter.drawString("" + (char)('A'+i), 335+i*90, 740);
        }
        repaint();
    }

    public void setInitialState(){
        setInitialPositionPawns();
        setInitialPositionRook();
        setInitialPositionKnight();
        setInitialPositionBishop();
        setInitialPositionQueen();
        setInitialPositionKing();
        setListenersOnPiece();
        currentPiece = null;
    }

    private void setInitialPositionPawns(){
        for (int i = 0; i < 8; i++) {
            add(new PawnView("black", new CheckerboardPosition(1, i, "black")));
            add(new PawnView("white", new CheckerboardPosition(6, i, "white")));
        }
    }

    private void setInitialPositionRook(){
        add(new RookView("black",new CheckerboardPosition(0,0,"black")));
        add(new RookView("black",new CheckerboardPosition(0,7,"black")));
        add(new RookView("white",new CheckerboardPosition(7,0,"white")));
        add(new RookView("white",new CheckerboardPosition(7,7,"white")));
    }

    private void setInitialPositionKnight(){
        add(new KnightView("black",new CheckerboardPosition(0, 1, "black")));
        add(new KnightView("black",new CheckerboardPosition(0,6,"black")));
        add(new KnightView("white",new CheckerboardPosition(7,1,"white")));
        add(new KnightView("white",new CheckerboardPosition(7,6,"white")));
    }

    private void setInitialPositionBishop(){
        add(new BishopView("black",new CheckerboardPosition(0, 2, "black")));
        add(new BishopView("black",new CheckerboardPosition(0,5,"black")));
        add(new BishopView("white",new CheckerboardPosition(7,2,"white")));
        add(new BishopView("white",new CheckerboardPosition(7,5,"white")));
    }

    private void setInitialPositionQueen(){
        add(new QueenView("black", new CheckerboardPosition(0, 3, "black")));
        add(new QueenView("white",new CheckerboardPosition(7,3,"white")));
    }

    private void setInitialPositionKing(){
        add(new KingView("black", new CheckerboardPosition(0, 4, "black")));
        add(new KingView("white", new CheckerboardPosition(7, 4, "white")));
    }

    private void setListenersOnPiece(){
        PieceView currentPiece;
        int numberOfPiece = getComponentCount();
        System.out.print(numberOfPiece);
        for (int i = 0; i < numberOfPiece; i++) {
            //if (getComponent(i).getClass().getName().equals("JLabel")){
                currentPiece = (PieceView)getComponent(i);
                currentPiece.addMouseListener(new ClickOnPieceListener(this, currentPiece));
            //}
        }
    }

    public PieceView getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(PieceView currentPiece) {
        this.currentPiece = currentPiece;
    }
}
