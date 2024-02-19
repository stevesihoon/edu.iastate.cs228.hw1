package edu.iastate.cs228.hw1;

public class Casual extends TownCell{
    public Casual(Town p, int r, int c) {
        super(p, r, c);
    }

    @Override
    public State who() {
        return State.CASUAL;
    }

    @Override
    public TownCell next(Town tNew) {
        census(nCensus);
//        for (int i = 0; i < tNew.getLength(); i++){				// Initialize the grid
//            for(int j = 0; j < tNew.getWidth(); j++) {
//                if (tNew.grid[i][j].who().equals(State.CASUAL)){
//                    if (nCensus[RESELLER] > 0) {
//                        tNew.grid[i][j] = new Outage(tNew, tNew.getLength(), tNew.getWidth());
//                    } else if (nCensus[STREAMER] > 0) {
//                        tNew.grid[i][j] = new Streamer(tNew, tNew.getLength(), tNew.getWidth());
//                    }
//                }
//            }
//        }
        if (nCensus[RESELLER] > 0) {
            return new Outage(tNew, tNew.getLength(), tNew.getWidth());
        }
        else if (nCensus[STREAMER] > 0) {
            return new Streamer(tNew, tNew.getLength(), tNew.getWidth());
        }
        else if (nCensus[CASUAL] > 4) {
        return new Streamer(tNew, tNew.getLength(), tNew.getWidth());
        }
        else if (nCensus[OUTAGE] + nCensus[EMPTY] <= 1) {
            return new Reseller(tNew, tNew.getLength(), tNew.getWidth());
        }
        else {
            return new Casual(tNew, tNew.getLength(), tNew.getWidth());
        }
    }
}
