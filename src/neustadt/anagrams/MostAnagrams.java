package neustadt.anagrams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class MostAnagrams {
	public static void main(String[] args) throws IOException {
		HashMap<ArrayList<Character>, ArrayList<String>> map = new HashMap<ArrayList<Character>, ArrayList<String>>();
		BufferedReader readDictionary = new BufferedReader(new FileReader("./US.dic"));
		ArrayList<Character> charSet = null;
		int maxNum = 0;
		ArrayList<String> wordSet = null;
		ArrayList<String> maxWordSet = null;
 
		String nextWord;
		while ((nextWord = readDictionary.readLine()) != null) {
			
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
		readDictionary.close();
		System.out.println(maxNum + " Words: \n" + maxWordSet.toString());
	}
}