package threshold;
public class ThresholdManager {
	double N;
	Noise noise;
	double snr;
	double threshold;
	
	public double getThreshold() {
		return threshold;
	}

	public ThresholdManager(double N, double snr, double Pfa){
		this.N = N;
		this.snr = snr;
		this.noise = new Noise(this.N, this.snr);
		this.threshold =this.noise.getArray()[(int) (N-(N*Pfa)-1)];
	}
}
