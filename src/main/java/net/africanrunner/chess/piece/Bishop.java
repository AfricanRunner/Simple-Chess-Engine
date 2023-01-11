package net.africanrunner.chess.piece;

import net.africanrunner.chess.Board.Board;
import net.africanrunner.chess.move.Move;
import net.africanrunner.position.Position;

import java.util.LinkedList;

public class Bishop extends Piece
{
    public static final int SCORE = 3;
    public static final String ID = "B";
    public static final String NAME = "Bishop";

    public Bishop (Position position, boolean isWhite, Board board)
    {
        super(position, isWhite, board);
    }

    @Override
    public LinkedList<Move> getMoves()
    {
        LinkedList<Move> moves = new LinkedList<>();

        getMovesHelper(1, 1, moves, board);
        getMovesHelper(-1, 1, moves, board);
        getMovesHelper(-1, -1, moves, board);
        getMovesHelper(1, -1, moves, board);

        return moves;
    }

    private void getMovesHelper(int rowInc, int colInc, LinkedList<Move> moves, Board board)
    {
        Position temp = this.position.getPosition(rowInc, colInc);
        while(board.inBounds(temp))
        {
            if(board.hasFriendlyPieceAtPosition(temp, isWhite))
                break;
            else if(board.hasHostilePieceAtPosition(temp, isWhite))
            {
                moves.add(new Move(this, board, temp.getPosition()));
                break;
            }
            moves.add(new Move(this, board, temp.getPosition()));
            temp = temp.getPosition(rowInc, colInc);
        }
    }

    @Override
    public int getScore()
    {
        return SCORE;
    }

    @Override
    public String getID()
    {
        return ID;
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    public static Bishop parseBishop(String[] data, Board board)
    {
        Position position = Position.parsePosition(data[1] + data[2]);
        boolean isWhite = Boolean.parseBoolean(data[3]);

        return new Bishop(position, isWhite, board);
    }
}
