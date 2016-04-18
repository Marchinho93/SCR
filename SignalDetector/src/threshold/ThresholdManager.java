package threshold;
public class ThresholdManager {
	private double N;
	private Noise noise;
	private double snr;
	private double threshold;
	
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