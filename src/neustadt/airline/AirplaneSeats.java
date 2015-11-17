package neustadt.airline;

import java.util.ArrayList;
import java.util.HashMap;

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

	private HashMap<String, String> map;
	private int rows;
	private int columns;

	public AirplaneSeats(int rows, int columns) {
		this.map = new HashMap<String, String>();
		this.rows = rows;
		this.columns = columns;

		for (int i = 1; i <= rows; i++) {
			for (char c = 'A'; c < columns + 65; c++) {
				map.put((c + String.valueOf(i)), "o");
			}

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
	public void reserve(String seatName) throws AlreadyReservedException,
			SeatOutOfBoundsException {

		if (!map.containsKey(seatName)) {
			throw new SeatOutOfBoundsException();
		}
		if (isReserved(seatName)) {
			throw new AlreadyReservedException();
		}
		map.put(seatName, "#");
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		return map.get(seatName).equals("#");
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
	public void reserveAll(String... seatNames)
			throws AlreadyReservedException, SeatOutOfBoundsException {
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
		
		builder.append("  ");
		for (char c = 'A'; c < columns + 65; c++) {
			builder.append(c);
		}
		builder.append("\n");
		
		for (int i = 1; i <= rows; i++) {
			builder.append(i + " ");
		
			for (char c = 'A'; c < columns + 65; c++) {
				String seatName = c + String.valueOf(i);
				builder.append(map.get(seatName));
					}
		builder.append("\n");
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

	public ArrayList<String> reserveGroup(int numberOfSeatsTogether)
			throws NotEnoughSeatsException {
		ArrayList<String> spots = new ArrayList<String>();

		for (int i = 1; i <= rows; i++) {
			for (char c = 'A'; c < columns + 65; c++) {
				String seatName = c + String.valueOf(i);
				if (map.get(seatName).equals("o")) {
					spots.add(seatName);
					if (spots.size() == numberOfSeatsTogether) {
						return spots;
					}
				} else {
					spots.clear();
				}
			}
			spots.clear();
		}
		throw new NotEnoughSeatsException();
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		return !map.containsValue("o");
	}

}