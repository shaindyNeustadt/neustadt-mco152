package neustadt.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MostAnagrams {
	public static void main(String[] args) throws FileNotFoundException {
		HashMap<ArrayList<Character>, ArrayList<String>> map = new HashMap<ArrayList<Character>, ArrayList<String>>();
		Scanner readDictionary = new Scanner(new File("./US.dic"));
		ArrayList<Character> charSet = null;
		int maxNum = 0;
		ArrayList<String> wordSet = null;
		ArrayList<String> maxWordSet = null;

		while (readDictionary.hasNext()) {
			String nextWord = readDictionary.next();

			charSet = new ArrayList<Character>();
			char[] newWord = nextWord.toCharArray();

			for (int i = 0; i < newWord.length; i++) {
				charSet.add(newWord[i]);
			}
			Collections.sort(charSet);

			if (map.containsKey(charSet)) {
				map.get(charSet).add(nextWord);
			} else {
				wordSet = new ArrayList<String>();
				wordSet.add(nextWord);
				map.put(charSet, wordSet);
			}
			if (map.get(charSet).size() > maxNum) {
				maxNum = map.get(charSet).size();
				maxWordSet = new ArrayList<String>(map.get(charSet));
			}
		}
		System.out.println(maxNum + " Words: \n" + maxWordSet.toString());
	}
}