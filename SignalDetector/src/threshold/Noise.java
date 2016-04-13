package threshold;

import java.util.Random;

public class Noise {
	Double[] noiseSignalArray;
	Random r;
	int snr;

	public Noise(int N, int snr) {
		this.noiseSignalArray = new Double[N];
		this.r = new Random();
		this.snr = snr;
		for(int i=0;i<N;i++)
			this.noiseSignalArray[i] = this.getValue();
	}
	
	private Double getValue(){
		Double snrLinear = this.linearize(this.snr);
		Double sigma = Math.sqrt(1/snrLinear);
		Double nextGaussian = this.r.nextGaussian();
		return nextGaussian*sigma;
	}

	private Double linearize(int snr) {
		return Math.pow(10, (this.snr/10));
	}
	
	public Double[] getArray(){
		return this.noiseSignalArray;
	}

}
