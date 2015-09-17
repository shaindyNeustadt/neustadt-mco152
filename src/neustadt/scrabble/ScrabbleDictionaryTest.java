package neustadt.scrabble;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testContainsTrue() throws FileNotFoundException {
		ScrabbleDictionary sd = new ScrabbleDictionary();
		Assert.assertTrue(sd.contains("scientist"));
	}

	@Test
	public void ContainsFalse() throws FileNotFoundException {
		ScrabbleDictionary sd = new ScrabbleDictionary();
		Assert.assertFalse(sd.contains("abcdefg"));
	}

}
