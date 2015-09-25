package neustadt.scrabble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {
	private HashSet<String> dictionary;

	public ScrabbleDictionary() throws IOException {
		this.dictionary = new HashSet<String>();
		BufferedReader readFile = new BufferedReader(new FileReader("./US.dic"));
		String nextLine;
		while ((nextLine = readFile.readLine()) != null) {
			dictionary.add(nextLine);
		}
	}

	public boolean contains(String word) {
		return dictionary.contains(word);

	}

}