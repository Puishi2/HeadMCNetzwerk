package de.headmc.bedwars.countdown;

public abstract class Countdown {


    protected  int taskID;

    public abstract void run();
    public abstract void cancel();
}
