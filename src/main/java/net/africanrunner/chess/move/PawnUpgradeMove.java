package net.africanrunner.chess.move;

import net.africanrunner.chess.Board.Board;
import net.africanrunner.chess.piece.Pawn;
import net.africanrunner.chess.piece.Piece;
import net.africanrunner.position.Position;

public class PawnUpgradeMove extends Move
{
    private Piece upgradePiece;
    private Pawn movingPiece;

    public PawnUpgradeMove(Piece movingPiece, Board board, Position endPos, Piece upgradePiece)
    {
        super(movingPiece, board, endPos);
        this.upgradePiece = upgradePiece;
        this.movingPiece = (Pawn)movingPiece;
    }

    public void doMove(boolean isVisual)
    {
        movingPiece.upgrade(upgradePiece, isVisual);
        super.doMove(isVisual);
    }

    public void undoMove(boolean isVisual)
    {
        movingPiece.downgrade(isVisual);
        super.undoMove(isVisual);
    }

    @Override
    public String toString()
    {
        return upgradePiece.getName();
    }
}
