package neustadt.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleDictionary {
	private ArrayList<String> dictionary;

	public ScrabbleDictionary() throws FileNotFoundException {
		this.dictionary = new ArrayList<String>();
		Scanner readFile = new Scanner(new File("./US.dic"));
		while (readFile.hasNext()) {
			dictionary.add(readFile.next());
		}
	}

	public boolean contains(String word) {
		return dictionary.contains(word);

	}

}