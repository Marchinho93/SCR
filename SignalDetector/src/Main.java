import threshold.Noise;
import threshold.ThresholdManager;

public class Main {

	public static void main(String[] args) {
		ThresholdManager threshold = new ThresholdManager(10000,0,0.001);
		System.out.println(threshold.getThreshold());
	}
		
}
