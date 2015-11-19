package neustadt.ConnectFour;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConnectFourJFrame extends JFrame {
	public static void main(String[] args) {
		new ConnectFourJFrame().setVisible(true);
	}

	private PieceComponent[][] gameBoard;
	private JButton[] columns;
	private Game game;

	public ConnectFourJFrame() {
		game = new Game();
		gameBoard = new PieceComponent[6][7];
		columns = new JButton[7];
		setTitle("Connect Four");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final GridLayout layout = new GridLayout(7, 7);
		final Container container = getContentPane();
		container.setBackground(Color.BLUE);
		container.setLayout(layout);

		for (int c = 0; c < columns.length; c++) {
			container.add(columns[c] = new JButton("COLUMN " + (c + 1)));
			final int c1 = c;

			columns[c].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					try {
						int row = game.playMove(c1);
						gameBoard[row][c1].setColor(game.getCurrentPlayer());

						if (game.isOver() || game.isWinner(row, c1)) {
							gameOver();
						}
						game.nextPlayer();
					} catch (IllegalMoveException ex) {
						;
					}
				}
			});
		}

		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				container.add(gameBoard[i][j] = new PieceComponent(),
						getLayout());
			}
		}
	}

	public void gameOver() {
		Object[] opt = { "YES", "NO" };
		int choice = JOptionPane.showOptionDialog(null, "PLAY AGAIN?",
				"GAME OVER!", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opt, opt[0]);

		if (choice == 0) {
			game = new Game();
			for (int i = 0; i < gameBoard.length; i++) {
				for (int j = 0; j < gameBoard[i].length; j++) {
					gameBoard[i][j].setColor(Color.WHITE);
				}
			}
		} else {
			this.dispose();
		}
	}
}