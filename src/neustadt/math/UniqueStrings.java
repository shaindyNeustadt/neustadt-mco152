package neustadt.math;

import java.util.HashSet;

public class UniqueStrings {
	public static void main(String[] args) {
		String array[] = new String[] { "A", "B", "B", "A", "B", "C", "F", "G" };
		HashSet<String> s = new HashSet<String>();
		HashSet<String> duplicates = new HashSet<String>();
		for (String a : array) {
			if (s.contains(a)) {
				duplicates.add(a);
			}
			s.add(a);
		}
		System.out.println(duplicates);
	}
	}