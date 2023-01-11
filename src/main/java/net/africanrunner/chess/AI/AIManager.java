package net.africanrunner.chess.AI;

public class AIManager implements Runnable
{
    private AI ai;

    public AIManager(AI ai)
    {
        this.ai = ai;
    }

    public void run()
    {
        ai.stop();
    }
}
