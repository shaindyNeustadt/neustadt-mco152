package neustadt.PI;

import javax.swing.JLabel;

public class PiCalculationThread extends Thread{
private JLabel label;

	public PiCalculationThread(JLabel label){
		this.label = label;
	}
	
	public void run(){
		//will execute on a different thread than the main thread
		CalculatePi calc = new CalculatePi();
		double pi = calc.calculate(10000000000L);
		label.setText(String.valueOf(pi));
	}
}
