package sequence;

public class Block {
	private Sample[] samples;
	private int next;
	private int N;
	
	public Block(int N){
		this.samples = new Sample[N];
		this.next = 0;
		this.N = N;
	}
	
	public void insertSample(Sample s){
		this.samples[next] = s;
		this.next++;
	}
	
	public Double calculateBlockPower(){
		Double result=0.0;
		for(int i=0;i<this.N; i++){
			Double re = this.samples[i].getRe();
			Double im = this.samples[i].getIm();
			result += Math.sqrt((Math.pow(re, 2) + Math.pow(im, 2)));
		}
		return result/this.N;
	}
	
	public Sample[] getSamples() {
		return samples;
	}
	
}
