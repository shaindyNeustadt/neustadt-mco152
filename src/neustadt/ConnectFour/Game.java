package neustadt.ConnectFour;

import java.awt.Color;

public class Game {

	private Board board;
	private Player player1, player2, currPlayer;

	public Game() {
		this.board = new Board(6, 7);
		this.player1 = new Player(1, Color.RED);
		this.player2 = new Player(2, Color.YELLOW);
		this.currPlayer = player1;
	}

	public Color getCurrentPlayer() {
		return currPlayer.getColor();
	}

	public int playMove(int column) {
		int row = this.board.insertPiece(currPlayer.getNumber(), column);
		return row;
	}

	public void nextPlayer() {
		currPlayer = (currPlayer == player1 ? player2 : player1);
	}

	public boolean isOver() {
		return board.isOver();
	}

	public boolean isWinner(int row, int column) {
		return board.isWinner(currPlayer.getNumber(), row, column);
	}
}