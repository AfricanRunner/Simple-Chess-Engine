package net.africanrunner.chess.Board;

public enum Status
{
    WHITE(), BLACK(), FREEZE(), CREATIVE();

    public String toString()
    {
        return this.name();
    }
}
