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
}
