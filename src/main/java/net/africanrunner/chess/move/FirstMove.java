package net.africanrunner.chess.move;

import net.africanrunner.chess.Board.Board;
import net.africanrunner.chess.piece.FirstMoveMatters;
import net.africanrunner.chess.piece.Piece;
import net.africanrunner.position.Position;

public class FirstMove extends Move
{
    FirstMoveMatters piece;

    public FirstMove(Piece movingPiece, Board board, Position endPos)
    {
        super(movingPiece, board, endPos);
        piece = (FirstMoveMatters)movingPiece;
    }

    @Override
    public void doMove(boolean isVisual)
    {
        piece.setHasMoved(true);
        super.doMove(isVisual);
    }

    @Override
    public void undoMove(boolean isVisual)
    {
        piece.setHasMoved(false);
        super.undoMove(isVisual);
    }
}
