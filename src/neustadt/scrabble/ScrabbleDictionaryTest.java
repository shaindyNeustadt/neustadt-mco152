package neustadt.scrabble;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testContainsTrue() throws IOException {
		ScrabbleDictionary sd = new ScrabbleDictionary();
		Assert.assertTrue(sd.contains("scientist"));
		}

	@Test
	public void ContainsFalse() throws IOException {
		ScrabbleDictionary sd = new ScrabbleDictionary();
		Assert.assertFalse(sd.contains("abcdefg"));
	}

}
