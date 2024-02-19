package edu.iastate.cs228.hw1;

public class Reseller extends TownCell{
    public Reseller(Town p, int r, int c) {
        super(p, r, c);
    }

    @Override
    public State who() {
        return State.RESELLER;
    }

    @Override
    public TownCell next(Town tNew) {
        census(nCensus);

        if (nCensus[CASUAL] < 4) {
            return new Empty(tNew, row, col);

        } else if (nCensus[EMPTY] > 2) {
            return new Empty(tNew, row, col);

        } else if (nCensus[CASUAL] > 4) {
            return new Streamer(tNew, row, col);

        } else {
            return new Reseller(tNew, row, col);
        }
    }
}
