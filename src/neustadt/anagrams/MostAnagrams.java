package neustadt.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MostAnagrams {
	public static void main(String[] args) throws FileNotFoundException {
		HashMap<HashSet<Character>, Integer> map = new HashMap<HashSet<Character>, Integer>();
		Scanner readDictionary = new Scanner(new File("./US.dic"));
		HashSet<Character> set = null;
		int maxNum = 0;
		HashSet<Character> maxSet = null;
		while (readDictionary.hasNext()) {
			set = new HashSet<Character>();
			char[] newWord = readDictionary.nextLine().toCharArray();
			for (int i = 0; i < newWord.length; i++) {
				set.add(newWord[i]);
			}
			if (map.containsKey(set)) {
				Integer count = map.get(set);
				map.put(set, count + 1);
			} else {
				// put words into map
				map.put(set, 1);
			}
			if (map.get(set) > maxNum) {
				maxNum = map.get(set);
		//		maxSet = new HashSet<Character>(map.getKey(set));
				
		}
		/*int maxNum = 0;
		HashSet<Character> maxSet = null;
		for (Map.Entry<HashSet<Character>, Integer> entry : map.entrySet()) {
			if (map.get(set) > maxNum) {
				maxNum = map.get(set);
				maxSet = new HashSet<Character>(entry.getKey());
			}
		}*/
			
}
		System.out.println(maxNum + " Words "// + maxSet.toString()
				);
	}
}
