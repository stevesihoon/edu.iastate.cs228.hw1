package edu.iastate.cs228.hw1;

public class Streamer extends TownCell{

    public Streamer(Town p, int r, int c) {
        super(p, r, c);
    }

    @Override
    public State who() {
        return State.STREAMER;
    }

    @Override
    public TownCell next(Town tNew) {
        return null;
    }
}
