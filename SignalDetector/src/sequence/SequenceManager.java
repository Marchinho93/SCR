package sequence;

import java.io.IOException;

public class SequenceManager {
	private Sequence sequence;
	private File file;
	private int N;
	
	public SequenceManager(String path, int N, int Nb){
		this.N = N;
		this.file = new File(path);
		this.sequence = new Sequence(N, Nb);
	}
	
	public void fillSequence() throws IOException{
		for(int i=0;i<this.N;i++){
			this.sequence.insertBlock(this.file.readSample());
		}
	}
	
	public Sequence getSequence() {
		return sequence;
	}
	
	
}
