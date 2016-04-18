package sequence;

public class Sequence {
	private Block[] blocks;
	private int next;
	private int nextSample;
	private int N;
	private int Nb;
	
	public Sequence(int N, int Nb){
		this.blocks = new Block[(N/Nb)];
		this.next = 0;
		this.nextSample = 0;
		this.Nb = Nb;
		this.N = N;
		this.blocks[0] = new Block(Nb);
	}

	public void insertBlock(Sample s){
		if(this.next < (N/Nb)){
			if(this.nextSample < Nb){
				this.blocks[this.next].insertSample(s);
				this.nextSample++;
			}
			else{
				this.nextSample=0;
				this.next++;
				this.blocks[this.next] = new Block(this.Nb);
				this.blocks[this.next].insertSample(s);
				this.nextSample++;
			}
		}
		else{
			System.out.println("Error too many blocks for this sequence");
		}

	}
	
	public Block[] getBlocks() {
		return this.blocks;
	}
	
	public double power(){
		double power = 0.0;
		for (int i=0; i<(N/Nb); i++){
			power += this.blocks[i].calculateBlockPower();
		}
				
		return (power/(N/Nb));
	}

	
}
