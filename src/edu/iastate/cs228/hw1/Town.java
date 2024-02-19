package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import static edu.iastate.cs228.hw1.TownCell.CASUAL;
import static edu.iastate.cs228.hw1.TownCell.nCensus;


/**
 *  @author <<Sihoon Lee>>
 *
 */
public class Town {
	
	private int length, width;  //Row and col (first and second indices)
	public TownCell[][] grid;
	
	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		//TODO: Write your code here.
		this.length = length;
		this.width = width;

		grid = new TownCell[length][width];
	}
	
	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {
		//TODO: Write your code here.

	}
	
	/**
	 * Returns width of the grid.
	 * @return
	 */
	public int getWidth() {
		//TODO: Write/update your code here.
		return width;
	}
	
	/**
	 * Returns length of the grid.
	 * @return
	 */
	public int getLength() {
		//TODO: Write/update your code here.
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		//TODO: Write your code here.

		for (int i = 0; i < getLength(); i++){				// Initialize the grid
			for(int j = 0; j < getWidth(); j++){
				switch(rand.nextInt(5)){
					case 0:
						grid[i][j] = new Reseller(this, length, width);
						break;
					case 1:
						grid[i][j] = new Empty(this, length, width);
						break;
					case 2:
						grid[i][j] = new Casual(this, length, width);
						break;
					case 3:
						grid[i][j] = new Outage(this, length, width);
						break;
					case 4:
						grid[i][j] = new Streamer(this, length, width);
						break;
				}

			}
		}

	}
	
	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between 
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";
		//TODO: Write your code here.

		for (int i = 0; i < getLength(); i++){
			for(int j = 0; j < getWidth(); j++){
				if (grid[i][j].equals(new Reseller(this, length, width))) {
					s = "R";
				} else if (grid[i][j].equals(new Empty(this, length, width))) {
					s = "E";
				} else if (grid[i][j].equals(new Casual(this, length, width))) {
					s = "C";
				} else if (grid[i][j].equals(new Outage(this, length, width))) {
					s = "O";
				} else if (grid[i][j].equals(new Streamer(this, length, width))) {
					s = "S";
				}

			}
		}

		return s;
	}
}
