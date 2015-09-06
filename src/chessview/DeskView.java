package chessview;

import constants.PieceConstants;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class DeskView extends JPanel {
    private BufferedImage buffer;

    public DeskView(){
        super();

        setLayout(null);
        buffer = new BufferedImage(1500, 1500, BufferedImage.TYPE_INT_ARGB);
        JLabel kol;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //kol = new JLabel(PieceConstants.BLACK_KING);
                //kol.setBackground(new Color(255,255,255,0));
                //kol.setBorder(BorderFactory.createLineBorder(Color.black));
                //kol.setBounds(300+j*90, i * 90, 90, 90);
                //add(kol);
            }
        }
        drawDesk();
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
            painter.drawString(Integer.toString(i+1), 270, i*90+55);
        }

        for (int i = 0; i < 8; i++) {
            painter.drawString("" + (char)('A'+i), 335+i*90, 740);
        }
        repaint();
    }
}
