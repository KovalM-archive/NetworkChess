package chessmodel.piecemodel;

import chessmodel.DeskModel;
import chessmodel.PositionWithPiece;
import chessmodel.CheckerboardPosition;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.util.ArrayList;
import java.util.List;

public class BishopModel extends PieceModel {

    public BishopModel(String color, CheckerboardPosition piecePosition) {
        super(color, piecePosition);
    }

    public List<PositionWithPiece> getAllCandidate(DeskModel deskModel){
        List<PositionWithPiece> allCandidate = new ArrayList<>();
        passDirection(1, 1, deskModel, allCandidate);
        passDirection(1, -1, deskModel, allCandidate);
        passDirection(-1, 1, deskModel, allCandidate);
        passDirection(-1, -1, deskModel, allCandidate);
        return allCandidate;
    }
}
