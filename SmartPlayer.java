package exercise3;

public class SmartPlayer extends BlockingPlayer{

	public SmartPlayer(String name, char mark) {
		super(name, mark);
		
	}
	
	
	protected void makeMove() {
		
		//check every row and col for a winning move
		
		for(int i = 0; i < 3; i++) {
			
			for(int j = 0; j < 3; j++) {
				
				if(testForWinning(i,j)) {
					board.addMark(i, j, this.mark);
					return;
				}
				
			}
		}
		
		//check every row and col for a blocking move
		
		for(int i = 0; i < 3; i++) {
			
			for(int j = 0; j < 3; j++) {
				
				if(super.testForBlocking(i,j)) {
					board.addMark(i, j, this.mark);
					return;
				}
				
			}
		}
		
		//check every row and col for a vacant spot
		
		super.makeMove();
		return;
	}
	
	
	protected boolean testForWinning(int row, int col) {
		//check for 2 of its own markers in a row col or diag.
		
		int counter=0;
		if(board.getMark(row, col)!=this.getMark() && board.getMark(row,col)!=this.getOpponent().getMark()) {
			
			//test rows
			for(int i = 0; i<3; i++){
				if(board.getMark(row, i)==this.getMark() && board.getMark(row,i)!=this.getOpponent().getMark()) {
					counter ++;
				}
			}
			
			if(counter == 2) {
				return true;
			}
			
			counter = 0;
			
			//test cols
			for(int i = 0; i<3; i++){
				if(board.getMark(i, col)==this.getMark() && board.getMark(i, col)!=this.getOpponent().getMark()) {
					counter ++;
				}
			}
			
			if(counter == 2) {
				return true;
			}
			
			counter = 0;
			
			//test diagonals
			
			if(row==col || (row==2&&col==0) || (row==0&&col==2)) {
				for(int i = 0; i< 3; i++) {
					if(board.getMark(i, i)==this.getMark() && board.getMark(i, i)!=this.getOpponent().getMark()) {
						counter ++;
					}
				}
				
				if(row==2&&col==0) {
					counter ++;
				}
				
				if(row==0&&col==2){
					counter ++;
				}
				
			}
			
			if(counter == 2) {
				return true;
			}
			
			
		}
		
		return false;
	

	}

}
