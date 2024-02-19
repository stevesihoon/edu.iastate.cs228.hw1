package edu.iastate.cs228.hw1;

/**
 * 
 * @author <<Sihoon Lee>>
 *	Also provide appropriate comments for this class
 *
 */
public abstract class TownCell {

	protected Town plain;
	protected int row;
	protected int col;
	
	
	// constants to be used as indices.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;
	
	public static final int NUM_CELL_TYPE = 5;
	
	//Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];

	public TownCell(Town p, int r, int c) {
		plain = p;
		row = r;
		col = c;
	}
	
	/**
	 * Checks all neigborhood cell types in the neighborhood.
	 * Refer to homework pdf for neighbor definitions (all adjacent
	 * neighbors excluding the center cell).
	 * Use who() method to get who is present in the neighborhood
	 *  
	 * @param counts of all customers
	 */
	public void census(int nCensus[]) {
		// zero the counts of all customers
		nCensus[RESELLER] = 0; 
		nCensus[EMPTY] = 0;
		nCensus[CASUAL] = 0; 
		nCensus[OUTAGE] = 0; 
		nCensus[STREAMER] = 0; 

		//TODO: Write your code here

		TownCell standardCell = plain.grid[row][col];	// set a standard Cell
		State cellType = standardCell.who();

		for(int i = row - 1; i < row + 1; i++){
			for(int j = col - 1; j < col + 1; j++){		// for


				TownCell sC = plain.grid[i][j];
				sC.who();

				switch(cellType){
					case RESELLER -> nCensus[RESELLER]++;
					case EMPTY -> nCensus[EMPTY]++;
					case CASUAL -> nCensus[CASUAL]++;
					case OUTAGE -> nCensus[OUTAGE]++;
					case STREAMER -> nCensus[STREAMER]++;
				}
			}
		}
	}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
}
