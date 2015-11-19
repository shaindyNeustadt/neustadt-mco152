package neustadt.ConnectFour;

public class Board {
	private int[][] board;

	public Board(int rows, int columns) {
		this.board = new int[rows][columns];
	}

	public int insertPiece(int currPlayer, int column) {
		for (int row = board.length - 1; row > -1; row--) {
			if (board[row][column] == 0) {
				board[row][column] = currPlayer;
				return row;
			}
		}
		throw new IllegalMoveException();
	}

	public boolean isWinner(int currPlayer, int currRow, int currColumn) {
		int counter = 0;

		// checks if there are four consecutive ints of the same value
		// horizontally
		for (int column = 0; column < board[currRow].length; column++) {
			if (board[currRow][column] == currPlayer) {
				counter++;
			} 
			else {
				counter = 0;
			}
			if (counter == 4) {
				return true;
			}
		}

		// checks if there are four consecutive ints of the same value
		// vertically
		if (currRow < 4) {
			counter = 0;
			for (int row = currRow; row < board.length; row++) {
				if (board[row][currColumn] == currPlayer) {
					counter++;
				} 
				else {
					counter = 0;
				}
				if (counter == 4) {
					return true;
				}
			}
		}

		// checks if there are four consecutive ints of the same value
		// diagonally (positive slope)
		for (int row = 3; row < board.length; row++) {
			for (int column = 0; column < board[0].length - 3; column++) {
				if (board[row][column] == currPlayer
						&& board[row][column] == board[row - 1][column + 1]
						&& board[row - 1][column + 1] == board[row - 2][column + 2]
						&& board[row - 2][column + 2] == board[row - 3][column + 3]) {
					return true;
				}
			}
		}

		// checks if there are four consecutive ints of the same value
		// diagonally (negative slope)
		for (int row = 0; row < board.length - 3; row++) {
			for (int column = 0; column < board[0].length - 3; column++) {
				if (board[row][column] == currPlayer
						&& board[row][column] == board[row + 1][column + 1]
						&& board[row + 1][column + 1] == board[row + 2][column + 2]
						&& board[row + 2][column + 2] == board[row + 3][column + 3]) {
					return true;
				}
			}
		}
		return false;
	}

	//checks if all of the columns are full
	public boolean isOver() {
		for (int column = 0; column < board[0].length; column++) {
			if (board[0][column] == 0) {
				return false;
			}
		}
		return true;
	}
}
