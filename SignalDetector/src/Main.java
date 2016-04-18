import java.io.IOException;

import detector.Detector;
import sequence.Block;
import sequence.File;
import sequence.Sample;
import sequence.Sequence;
import sequence.SequenceManager;
import threshold.Noise;
import threshold.ThresholdManager;

public class Main {

	public static void main(String[] args) throws IOException {
		ThresholdManager threshold_Neg = new ThresholdManager(10000,-10,0.001);
		ThresholdManager threshold_0 = new ThresholdManager(10000,0,0.001);
		ThresholdManager threshold_Pos = new ThresholdManager(10000,10,0.001);
		System.out.println(threshold_Neg.getThreshold()+" Soglia con snr negativo");
		System.out.println(threshold_0.getThreshold()+" Soglia con snr 0");
		System.out.println(threshold_Pos.getThreshold()+" Soglia con snr positivo");
		
		SequenceManager sm1 = new SequenceManager("src/seq_1_SNR_-10dB.dat", 100000, 1000);
		sm1.fillSequence();
		Sequence s1 = sm1.getSequence();
		System.out.println("Signal Rate -10: " + Detector.calculateSignalRate(s1, threshold_Neg, 100000, 1000));
		
		SequenceManager sm2 = new SequenceManager("src/seq_1_SNR_0dB.dat", 100000, 1000);
		sm2.fillSequence();
		Sequence s2 = sm2.getSequence();
		System.out.println("Signal Rate 0: " + Detector.calculateSignalRate(s2, threshold_0, 100000, 1000));		
				
		SequenceManager sm3 = new SequenceManager("src/seq_1_SNR_+10dB.dat", 100000, 1000);
		sm3.fillSequence();
		Sequence s3 = sm3.getSequence();
		System.out.println("Signal Rate +10: " + Detector.calculateSignalRate(s3, threshold_Pos, 100000, 1000));
		
		Noise n1 = new Noise(10000, -10);
		Double n1d = n1.test();
		System.out.println("Potenza rumore -10 = "+ n1d);
		Noise n2 = new Noise(10000, 0);
		Double n2d = n2.test();
		System.out.println("Potenza rumore 0 = "+n2d);
		Noise n3 = new Noise(10000, 10);
		Double n3d = n3.test();
		System.out.println("Potenza rumore 10 = "+n3d);

		System.out.println("Potenza segnale ingresso "+s1.power());
		System.out.println("Potenza segnale ingresso "+s2.power());
		System.out.println("Potenza segnale ingresso "+s3.power());
		
	}
		
}
