package edu.iastate.cs228.hw1;

public class Empty extends TownCell{
    public Empty(Town p, int r, int c){
        super(p, r, c);
    }
    public State who(){
        return State.EMPTY;
    }
    public TownCell next(Town tnew){
        census(nCensus);
        if (nCensus[OUTAGE] + nCensus[EMPTY] <= 1) {
            return new Reseller(tnew, row, col);

        } else {
            return new Casual(tnew, row, col);
        }
    }
}
