package chessmodel;

public class DeskModel {
    private String walkethPlayer;

    public DeskModel(){
        setWalkethPlayer("white");
    }

    public String getWalkethPlayer() {
        return walkethPlayer;
    }

    public void setWalkethPlayer(String walkethPlayer) {
        this.walkethPlayer = walkethPlayer;
    }

    public void changePlayer(){
        walkethPlayer = walkethPlayer.equals("white") ? "black" : "white";
    }
}
