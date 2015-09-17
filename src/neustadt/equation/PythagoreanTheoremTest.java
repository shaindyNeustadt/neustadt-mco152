package neustadt.equation;

import org.junit.Assert;
import org.junit.Test;


public class PythagoreanTheoremTest {

	
	@Test
	public void testSetAB() {
		PythagoreanTheorem pythagoreanTheorum = new PythagoreanTheorem();
		pythagoreanTheorum.setAB(3, 4);
		Assert.assertEquals(5, pythagoreanTheorum.getC(), 0.1);
	}

	@Test
	public void testSetAC() {
		PythagoreanTheorem pythagoreanTheorum = new PythagoreanTheorem();
		pythagoreanTheorum.setAC(3, 5);
		Assert.assertEquals(4, pythagoreanTheorum.getB(), 0.1);
	}

	@Test
	public void testSetBC() {
		PythagoreanTheorem pythagoreanTheorum = new PythagoreanTheorem();
		pythagoreanTheorum.setBC(4, 5);
		Assert.assertEquals(3, pythagoreanTheorum.getA(), 0.1);
	}
}