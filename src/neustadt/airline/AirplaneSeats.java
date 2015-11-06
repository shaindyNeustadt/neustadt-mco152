package neustadt.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */

	private HashMap<Integer, ArrayList<String>> map;
	private HashMap<Character, Integer> conversion;

	public AirplaneSeats(int rows, int columns) {
		this.map = new HashMap<Integer, ArrayList<String>>();
		this.conversion = new HashMap<Character, Integer>();

		for (int i = 1; i <= rows; i++) {
			ArrayList<String> current = new ArrayList<String>();
			for (int x = 0; x < columns; x++) {
				current.add("o");
			}
			map.put(i, current);
		}
		setConversion();
	}

	private void setConversion() {
		String base26Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int c = 0; c < 25; c++) {
			conversion.put(base26Chars.charAt(c), c);
		}
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException, SeatOutOfBoundsException {

		int column = conversion.get(seatName.charAt(0));
		Integer row = Integer.parseInt(seatName.substring(1));
		ArrayList<String> string = new ArrayList<String>(map.get(row));
		if (string.get(column).equals("#")) {
			throw new AlreadyReservedException();
		}
		if (column >= string.size() || column < 0 || !map.containsKey(row)) {
			throw new SeatOutOfBoundsException();
		}

		string.set(column, "#");
		map.put(row, string);

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		int column = conversion.get(seatName.charAt(0)) - 1;
		Integer row = Integer.parseInt(seatName.substring(1));
		return map.get(row).get(column).equals("#");

	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames) throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		String base26Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		builder.append("  ");
		for (int i = 0; i < map.get(0).size(); i++) {
			builder.append(base26Chars.charAt(i));
		}
		builder.append("\n/n");
		for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
			builder.append(entry.getKey() + " " + entry.getValue().toString() + "\n/n");
		}
		return builder.toString();
	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 */
	/*public ArrayList<String> reserveGroup(int numberOfSeatsTogether) throws NotEnoughSeatsException {
		ArrayList<String> spots = new ArrayList<String>();

		for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
			spots = null;
			for (int i = 0; i < entry.getValue().size(); i++) {
				if (entry.getValue().get(i).equals("o")) {
					spots.append(conversion.get(key) + entry.getKey());
				}
			}
		}

	}*/

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
			for (int i = 0; i < entry.getValue().size(); i++) {
				if (entry.getValue().get(i).equals("o")) {
					return false;
				}
			}
		}
		return true;
	}

}
