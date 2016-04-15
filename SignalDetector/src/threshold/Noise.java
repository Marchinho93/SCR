package threshold;

import java.util.Arrays;
import java.util.Random;

public class Noise {
	Double[] noisePowerArray;
	Random r;
	double snr;

	public Noise(double N, double snr) {
		this.noisePowerArray = new Double[(int) N];
		this.r = new Random();
		this.snr = snr;
		for(int i=0;i<N;i++)
			this.noisePowerArray[i] = this.getValue();
		Arrays.sort(this.noisePowerArray);
		for(int i = 0; i<this.noisePowerArray.length;i++)
			System.out.println(" "+ this.noisePowerArray[i]);
	}
	
	//Calcolo della potenza integrato alla generazione del segnale di rumore
	private Double getValue(){
		Double snrLinear = this.linearize(this.snr);
		Double sigma = Math.sqrt(1/snrLinear);
		Double nextGaussian = this.r.nextGaussian();
		return Math.pow(nextGaussian*sigma, 2); 
	}

	private Double linearize(double snr) {
		return Math.pow(10, (this.snr/10));
	}
	
	public Double[] getArray(){
		return this.noisePowerArray;
	}

}
