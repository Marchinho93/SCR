package threshold;

public class ThresholdManager {
	int N;
	Double[] noisePowerArray;
	Noise noise;
	int snr;
	
	public ThresholdManager(int N, int snr){
		this.N = N;
		this.snr = snr;
		this.noisePowerArray = new Double[this.N];
		this.noise = new Noise(this.N, this.snr);
	}

}
