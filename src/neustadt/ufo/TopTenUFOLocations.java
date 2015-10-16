package neustadt.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

import com.google.gson.Gson;

public class TopTenUFOLocations {

	public static void main(String[] args) throws IOException{
		
final BufferedReader in = new BufferedReader(new FileReader("./ufo_awesome.json"));
		String[] topTen = new String[10];
		final Gson gson = new Gson();
		final UFOSightingList list = gson.fromJson(in, UFOSightingList.class);		
		Collections.sort(list);
		for(int i = 0; i < list.length; i++){
			while(list[i].location.equalsIgnoreCase(list[i+1])){
				
			}
		}
		System.out.println(list);
		
		System.out.println(list.size());
		
		in.close();
	}
}
