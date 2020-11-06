package exercise3;

import java.util.Scanner;

public class RandomPlayer extends Player{
	RandomGenerator ranGen;
	
	public RandomPlayer(String name, char mark) {
		super(name, mark);
		
	}
	
	
	protected void makeMove() {
	
		ranGen = new RandomGenerator();
		
		while(true) {
			//Randomly generate row and col
			int row=ranGen.discrete(0, 2);
			int col=ranGen.discrete(0, 2);

		
			//Check if random coordinates are vacant
			if(board.getMark(row, col)!=this.getMark() &&board.getMark(row, col)!=opponent.getMark() ) {
				board.addMark(row, col, this.mark);
				return;
			}
			
			//Else generate a new set of coordinates and try again
		}

	}

}