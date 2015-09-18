package neustadt.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testEncode() {
		MorseCode mc = new MorseCode();
		Assert.assertEquals(
				".... .- ...- .   .-   --. .-. . .- -   -.. .- -.--",
				mc.encode("Have a great day"));
	}

	@Test
	public void testDecode() {
		MorseCode mc = new MorseCode();
		Assert.assertEquals("good bye",
				mc.decode("--. --- --- -..   -... -.-- ."));
	}
}