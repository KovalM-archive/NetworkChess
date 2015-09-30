package clientserver;

import chessmodel.CheckerboardPosition;
import chessview.DeskView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionWithOpponent {
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private int passLeft;
    private DeskView deskView;

    public ConnectionWithOpponent(Socket socket, DeskView deskView){
        this.deskView = deskView;
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void sendMove(CheckerboardPosition start, CheckerboardPosition finish){
        passLeft--;
        System.out.println(start.getRow()+" "+start.getColumn());
        System.out.println(finish.getRow()+" "+finish.getColumn());
        try {
            outputStream.writeObject(start);
            outputStream.writeObject(finish);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (passLeft==0){
            waitMove();
        }
    }

    public void sendTypeMove(String typeMove){
        System.out.println(typeMove);
        passLeft = typeMove.equals("simple")?1:2;
        try {
            outputStream.writeObject(typeMove);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitMove(){
        String typeMove;
        CheckerboardPosition start, finish;
        while (true) {
            try {
                typeMove = (String) inputStream.readObject();
                System.out.println(typeMove);
                if (typeMove.equals("simple")){
                    start = (CheckerboardPosition)inputStream.readObject();
                    finish = (CheckerboardPosition)inputStream.readObject();
                    deskView.movePieceOnDesk(deskView.getPieceViewOnDesk(start), finish);
                    System.out.println(start.getRow()+" "+start.getColumn());
                    System.out.println(finish.getRow()+" "+finish.getColumn());
                    break;
                } else if (typeMove.equals("castling")){
                    start = (CheckerboardPosition)inputStream.readObject();
                    finish = (CheckerboardPosition)inputStream.readObject();
                    deskView.movePieceOnDesk(deskView.getPieceViewOnDesk(start), finish);
                    System.out.println(start.getRow()+" "+start.getColumn());
                    System.out.println(finish.getRow()+" "+finish.getColumn());
                    start = (CheckerboardPosition)inputStream.readObject();
                    finish = (CheckerboardPosition)inputStream.readObject();
                    deskView.movePieceOnDesk(deskView.getPieceViewOnDesk(start), finish);
                    System.out.println(start.getRow()+" "+start.getColumn());
                    System.out.println(finish.getRow()+" "+finish.getColumn());
                    deskView.changePlayer();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
