package net.africanrunner.chess.Player;

import net.africanrunner.chess.Board.Board;
import net.africanrunner.chess.Board.BoardController;
import net.africanrunner.chess.move.Move;
import net.africanrunner.position.Position;

public abstract class Player
{
    public static final String[] PLAYER_TYPES = {"Human", "Computer"};

    protected boolean isWhite;
    protected Board board;

    private BoardController boardController;

    public Player(boolean isWhite)
    {
        this.isWhite = isWhite;
    }

    public void setBoardController(BoardController boardController)
    {
        this.boardController = boardController;
    }

    public void setBoard(Board board)
    {
        this.board = board;
    }

    public void returnMove(Move move)
    {
        boardController.giveNextMove(move);
    }

    public abstract void calculateNextMove();
    public abstract void forwardBoardInput(Position position);
    public abstract void stop();
    public abstract String toString();
    public static Player parsePlayer(String playerType, boolean isWhite)
    {
        switch (playerType)
        {
            case "Human":
                return new HumanPlayer(isWhite);
            case "Computer":
                return new ComputerPlayer(isWhite);
        }
        return null;
    }
}
