package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadWriter {
	private BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	
	public void writeline(String string) {
		System.out.println(string);
	}
	
	public String readline() {
		try {
			return bufferRead.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return null;
	}
	
	public List<String> getDictionary () {
		try {
			return Files.readAllLines(Paths.get("dictionary/OSPD.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
