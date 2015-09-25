package neustadt.equation;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetPosistiveX() {
		QuadraticEquation quadraticEquation = new QuadraticEquation(2, 5, -3);
		Assert.assertEquals(0.5, quadraticEquation.getPositiveX(), 0.1);
	}

	@Test
	public void testGetNegativeX() {
		QuadraticEquation quadraticEquation = new QuadraticEquation(2, 5, -3);
		Assert.assertEquals(-3, quadraticEquation.getNegativeX(), 0.1);

	}

	@Test
	public void testConstructorThrowsInvalidRootException() {
		try {
			QuadraticEquation quadraticEquation = new QuadraticEquation(0, 5,-3);
			Assert.fail();
		} catch (InvalidRootException ex) {
		}
	}
	
	@Test
	public void testGetPositiveXThrowsInvalidRootException() {
		QuadraticEquation quadraticEquation = new QuadraticEquation(2, 1, 3);
		try {
			double answer = quadraticEquation.getPositiveX();
			Assert.fail();
		} catch (InvalidRootException ex) {
		}
	}
	
	@Test
	public void testGetNegativeXThrowsInvalidRootException() {
		QuadraticEquation quadraticEquation = new QuadraticEquation(2, 1, 3);
		try {
			double answer = quadraticEquation.getNegativeX();
			Assert.fail();
		} catch (InvalidRootException ex) {
		}
	}
}