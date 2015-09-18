package neustadt.math;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicates {
		    public static void main( String args[] ) {

	        String array[] = new String[] {
	            "A", "B", "B", "C"
	        };

	        HashMap<String, Integer> map = new HashMap<String, Integer>();

	        // fill the HashMap
	        for ( String s : array ) {
	            Integer count = map.get(s);
	            map.put(s, (count == null) ? 1 : count + 1);
	          }

	        // iterate through the HashMap's key-value pairs
	        for ( Map.Entry<String, Integer> entry : map.entrySet()) {
	            System.out.println(entry.getKey() + " " + entry.getValue());
	        }

	    }
	}

