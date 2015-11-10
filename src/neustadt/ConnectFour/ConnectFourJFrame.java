package neustadt.ConnectFour;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ConnectFourJFrame extends JFrame {
	public static void main(String[] args) {

		new ConnectFourJFrame().setVisible(true);
	}

	private PieceComponent[][] gameBoard;
	private JButton[] columns;
	public ConnectFour cf;

	public ConnectFourJFrame() {
		cf = new ConnectFour();
		gameBoard = new PieceComponent[6][7];
		columns = new JButton[7];
		setTitle("Connect Four");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBackground(Color.BLUE);

		final GridLayout layout = new GridLayout(7, 7);
		final Container container = getContentPane();
		container.setLayout(layout);

		for (int c = 0; c < columns.length; c++) {
			container.add(columns[c] = new JButton("COLUMN " + (c + 1)));
			final int c1 = c;
		
			columns[c].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					
					if(cf.isOver() || cf.won()){
						return;
					}
					int row = cf.playMove(c1);
					Color c;
					if(cf.getCurrentPlayer() == 'r'){
						c  = Color.RED;
					}
					else{
						c = Color.YELLOW;
					}
					gameBoard[row][c1].setColor(c);
					if(cf.isOver() || cf.won()){
						return;
					}
					cf.nextTurn();
					
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
	
	}