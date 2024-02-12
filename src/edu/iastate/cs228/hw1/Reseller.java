package edu.iastate.cs228.hw1;

public class Reseller extends TownCell{
    public Reseller(Town p, int r, int c) {
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
