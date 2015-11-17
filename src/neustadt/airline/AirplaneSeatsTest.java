package neustadt.airline;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class AirplaneSeatsTest {
	
	@Test
	/**
	 * Test the output of toString() on an empty plane. Do not modify this method.
	 */
	public void testToStringWithEmptyPlane() {
		AirplaneSeats seats = new AirplaneSeats(3, 4);
		Assert.assertEquals(
				"  ABCD\n" +
				"1 oooo\n" +
				"2 oooo\n" + 
				"3 oooo\n",
				seats.toString());
	}
	
	@Test
	/**
	 * Test the output of toString() on an full plane. Do not modify this method.
	 */
	public void testToStringWithFullPlane() throws AlreadyReservedException, SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(3, 4);
		seats.reserveAll("A1", "B1", "C1", "D1");
		seats.reserveAll("A2", "B2", "C2", "D2");
		seats.reserveAll("A3", "B3", "C3", "D3");
		Assert.assertEquals(
				"  ABCD\n" +
				"1 ####\n" +
				"2 ####\n" + 
				"3 ####\n",
				seats.toString());
	}

	@Test
	/**
	 * Tests that reserve() reserves a seat correctly.
	 */
	public void testReserve() throws AlreadyReservedException, SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(3, 4);
		seats.reserve("B1");
		Assert.assertEquals("  ABCD\n" + "1 o#oo\n" + "2 oooo\n" + "3 oooo\n", seats.toString());
	}
	
	@Test
	/**
	 * Tests that reserve() will throw an AlreadyReservedException if you attempt to reserve
	 * a seat twice. Do not modify this method.
	 */
	public void testReserveThrowsAlreadyReservedException() throws SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(1,1);
		try {
			seats.reserve("A1");
			seats.reserve("A1");
			Assert.fail("reserve() should've thrown an Exception");
		} catch (AlreadyReservedException e) {
			// This is expected so catch it so the test passes
		}
	}
	
	@Test
	/**
	 * Tests that reserve() will thrown a SeatOutOfBoundsException is you attempt to reserve
	 * a seat that is outside the bounds of the plane. 
	 */
	public void testReserveThrowsSeatOutOfBoundsException() throws AlreadyReservedException {
		AirplaneSeats seats = new AirplaneSeats(1,1);
		try {
			seats.reserve("A2");
			Assert.fail("reserve() should've thrown an Exception");
		} catch (SeatOutOfBoundsException e) {
			
		}
		
	}
	
	@Test
	/**
	 * Tests that isFullPlane() returns false if there are empty seats on the plane. 
	 */
	public void testIsPlaneFullReturnsFalse() throws AlreadyReservedException, SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(1, 4);
		seats.reserveAll("A1", "B1", "C1");
		Assert.assertFalse(seats.isPlaneFull());
	}
	
	@Test
	/**
	 * Tests that isFullPlane() returns true if there are no empty seats on the plane. 
	 */
	public void testIsPlaneFullReturnsTrue() throws AlreadyReservedException, SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(1, 4);
		seats.reserveAll("A1", "B1", "C1", "D1");
		Assert.assertTrue(seats.isPlaneFull());
	}
	
	@Test
	/**
	 * Tests that reserveGroup() reserves the correct seats when called on an empty plane.
	 */
	public void testReserveGroupOnEmptyPlane() throws NotEnoughSeatsException {
		AirplaneSeats seats = new AirplaneSeats(3,4);
		ArrayList<String> s = new ArrayList<String>();
		s.add("A1");
		s.add("B1");
		s.add("C1");
		s.add("D1");
		Assert.assertEquals(s, seats.reserveGroup(4));
	}

	@Test
	/**
	 * Tests that reserveGroup() reserves the correct seats when called on a plane that has
	 * seats already reserved. For instance, on a 3,4 airplane whose "A1" is occupied, 
	 * calling reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 */
	public void testReserveGroupOnPartiallyFilledPlane() throws NotEnoughSeatsException, AlreadyReservedException, SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(3,4);
		seats.reserve("A1");
		ArrayList<String> s = new ArrayList<String>();
		s.add("A2");
		s.add("B2");
		s.add("C2");
		s.add("D2");
		Assert.assertEquals(s, seats.reserveGroup(4));
	} 
	
	@Test
	/**
	 * Tests that reserveGroup() throws NotEnoughSeatsException if there are not enough 
	 * seats available together for the group.
	 */
	public void testReserveGroupThrowsNotEnoughSeatsException() {
		AirplaneSeats seats = new AirplaneSeats(3,4);
		try {
			seats.reserveGroup(5);
			Assert.fail("reserve() should've thrown an Exception");
		} catch (NotEnoughSeatsException e) {
			// This is expected so catch it so the test passes
		}
	}
	
}
