package neustadt.ConnectFour;

public class ConnectFour {
	private char[][] board;

	private int turn;
	private char player1;
	private char player2;

	public ConnectFour() {
		this.player1 = 'r';
		this.player2 = 'y';
		this.board = new char[6][7];
		this.turn = 0;
	}
	
	public char getCurrentPlayer() {
		if (turn % 2 == 1) {
			return player1;
		}
		return player2;
	}

	public int playMove(int column) {
		int row = -1;

		while (isValidMove(row + 1, column)) {
			row++;
		}
		if (row < 0 || row > 5) {
			throw new IllegalMoveException();
		}
		board[row][column] = getCurrentPlayer();
		
		return row;
	}
	public char[][] getBoard(){
		return board;
	}
	
	public void nextTurn() {
		this.turn++;
	}

	public int getTurn() {
		return turn;
	}

	public boolean isValidMove(int row, int column) {
		return (row < 6 && board[row][column] == 0);
	}

	public boolean isOver() {
		return (turn == 42);
	}

	public boolean won() {
		char currPlayerColor = getCurrentPlayer();
		int counter;

		// checks if there are four consecutive chars of the same value
		// horizontally
		for (int row = 0; row < board.length; row++) {
			counter = 0;
			for (int column = 0; column < board[row].length; column++) {
				if (board[row][column] == currPlayerColor) {
					counter++;
				} else {
					counter = 0;
				}
				if (counter == 4) {
					return true;
				}
			}
		}

		// checks if there are four consecutive chars of the same value
		// vertically
		for (int column = 0; column < board[0].length; column++) {
			counter = 0;
			for (int row = 0; row < board.length; row++) {
				if (board[row][column] == currPlayerColor) {
					counter++;
				} else {
					counter = 0;
				}
				if (counter == 4) {
					return true;
				}
			}
		}

		// checks if there are four consecutive char of the same value
		// diagonally (positive slope)
		for (int row = 3; row < board.length; row++) {
			for (int column = 0; column < board[0].length - 3; column++) {
				if (board[row][column] == currPlayerColor
						&& board[row][column] == board[row - 1][column + 1]
						&& board[row - 1][column + 1] == board[row - 2][column + 2]
						&& board[row - 2][column + 2] == board[row - 3][column + 3]) {
					return true;
				}
			}
		}

		// checks if there are four consecutive chars of the same value
		// diagonally (negative slope)
		for (int row = 0; row < board.length - 3; row++) {
			for (int column = 0; column < board[0].length - 3; column++) {
				if (board[row][column] == currPlayerColor
						&& board[row][column] == board[row + 1][column + 1]
						&& board[row + 1][column + 1] == board[row + 2][column + 2]
						&& board[row + 2][column + 2] == board[row + 3][column + 3]) {
					return true;
				}
			}
		}
		return false;
	}
}
