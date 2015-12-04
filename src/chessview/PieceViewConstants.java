package chessview;

import javax.swing.ImageIcon;

public final class PieceViewConstants {
    public final static ImageIcon BLACK_KING = new ImageIcon("image/blackKing.png");
    public final static ImageIcon BLACK_QUEEN = new ImageIcon("image/blackQueen.png");
    public final static ImageIcon BLACK_BISHOP = new ImageIcon("image/blackBishop.png");
    public final static ImageIcon BLACK_KNIGHT = new ImageIcon("image/blackKnight.png");
    public final static ImageIcon BLACK_ROOK = new ImageIcon("image/blackRook.png");
    public final static ImageIcon BLACK_PAWN = new ImageIcon("image/blackPawn.png");
    public final static ImageIcon WHITE_KING = new ImageIcon("image/whiteKing.png");
    public final static ImageIcon WHITE_QUEEN = new ImageIcon("image/whiteQueen.png");
    public final static ImageIcon WHITE_BISHOP = new ImageIcon("image/whiteBishop.png");
    public final static ImageIcon WHITE_KNIGHT = new ImageIcon("image/whiteKnight.png");
    public final static ImageIcon WHITE_ROOK = new ImageIcon("image/whiteRook.png");
    public final static ImageIcon WHITE_PAWN = new ImageIcon("image/whitePawn.png");
    public final static String[] PIECE_NAME = {"Queen", "Rook", "Bishop", "Knight"};
    public final static ImageIcon[] PIECE_ICONS = {
            BLACK_PAWN, BLACK_ROOK, BLACK_KNIGHT,
            BLACK_BISHOP, BLACK_QUEEN, BLACK_KING,
            WHITE_PAWN, WHITE_ROOK, WHITE_KNIGHT,
            WHITE_BISHOP, WHITE_QUEEN, WHITE_KING};
}
