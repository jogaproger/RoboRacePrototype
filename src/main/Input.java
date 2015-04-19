package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static String getLine(){
		String ret = null;
		try {
			ret = br.readLine();
		} catch (IOException e) {
			return null;
		}
		return ret;
		
	}
	
}
