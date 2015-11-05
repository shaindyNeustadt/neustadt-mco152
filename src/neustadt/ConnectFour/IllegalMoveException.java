package neustadt.ConnectFour;

public class IllegalMoveException extends RuntimeException {
public IllegalMoveException(){
	super("Invalid Move.");
}
}
