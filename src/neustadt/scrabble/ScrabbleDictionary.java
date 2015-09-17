package neustadt.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {
	private HashSet<String> dictionary;

	public ScrabbleDictionary() throws FileNotFoundException {
		this.dictionary = new HashSet<String>();
		Scanner readFile = new Scanner(new File("./US.dic"));
		while (readFile.hasNext()) {
			dictionary.add(readFile.next());
		}
	}

	public boolean contains(String word) {
		return dictionary.contains(word);

	}

}