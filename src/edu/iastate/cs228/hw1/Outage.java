package edu.iastate.cs228.hw1;

public class Outage extends TownCell{
    public Outage(Town p, int r, int c) {
        super(p, r, c);
    }

    @Override
    public State who() {
        return null;
    }

    @Override
    public TownCell next(Town tNew) {
        return null;
    }
}