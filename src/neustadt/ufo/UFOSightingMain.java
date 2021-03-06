package neustadt.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;

public class UFOSightingMain {

	public static void main(String[] args) throws IOException{
		
		final BufferedReader in = new BufferedReader(new FileReader("./ufo_awesome.json"));
		
		final Gson gson = new Gson();
		final UFOSightingList list = gson.fromJson(in, UFOSightingList.class);		
		System.out.println(list.size());
		in.close();
	}
}
//top ten UFOSighting locations and number they have