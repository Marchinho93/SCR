package sequence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class File {
	private BufferedReader reader;
	public File(String path){
		try {
			this.reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			System.out.println("Errore path file");
		}
	}
	
	public Sample readSample() throws IOException{
		return new Sample(divide(this.reader.readLine()));
	}
	
	public Double[] divide(String s){
		int step = 0;
		StringBuilder reString = new StringBuilder();
		StringBuilder imString = new StringBuilder();
		for(int i=0; i<s.length();i++){
			char currChar = s.charAt(i);
			if(currChar=='	')
				step++;
			else {
				if(step==0)
				reString.append(currChar);
				if(step==1)
				imString.append(currChar);
			}
		}
		Double[] out = new Double[2];
		out[0]= Double.parseDouble(reString.toString());
		out[1]= Double.parseDouble(imString.toString());
		return out;
	}
}
