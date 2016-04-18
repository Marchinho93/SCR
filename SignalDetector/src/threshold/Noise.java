package threshold;

import java.util.Arrays;
import java.util.Random;

public class Noise {
	Double[] reNoiseSignalArray;
	Double[] imNoiseSignalArray;
	Double[] noisePowerArray;
	Random r;
	double snr;

	public Noise(double N, double snr) {
		this.reNoiseSignalArray = new Double[(int) N];
		this.imNoiseSignalArray = new Double[(int) N];
		this.noisePowerArray = new Double[(int) N];
		this.r = new Random();
		this.snr = snr;
		for(int i=0;i<N;i++){
			this.reNoiseSignalArray[i] = getValue();
			this.imNoiseSignalArray[i] = getValue();
			this.noisePowerArray[i] = calculatePower(this.reNoiseSignalArray[i], this.imNoiseSignalArray[i]);
		}
		Arrays.sort(this.noisePowerArray);
	}
	
	private Double calculatePower(Double re, Double im) {
		Double power = Math.pow((re+im),2);
		return power;
	}
	
	public Double test(){
		Double power=0.0;
		for(int i=0;i<this.noisePowerArray.length;i++){
			power+=calculatePower(this.reNoiseSignalArray[i],this.imNoiseSignalArray[i]);
		}
		return power/10000;
	}

	private Double getValue(){
		Double snrLinear = this.linearize(this.snr);
		Double sigma = Math.sqrt((1/(snrLinear))/2);
		Double nextGaussian = this.r.nextGaussian()*sigma;
		return nextGaussian; 
	}

	private Double linearize(double snr) {
		return Math.pow(10, (this.snr/10));
	}
	
	public Double[] getArray(){
		return this.noisePowerArray;
	}

}