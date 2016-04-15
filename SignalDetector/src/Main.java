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

		
		SequenceManager sm1 = new SequenceManager("src/seq_2_SNR_-10dB.dat", 100000, 1000);
		sm1.fillSequence();
		Sequence s1 = sm1.getSequence();
		System.out.println(Detector.calculateSignalRate(s1, threshold_Neg, 100000, 1000));
		System.out.println(s1.getBlocks()[50].calculateBlockPower());
		
		SequenceManager sm2 = new SequenceManager("src/seq_2_SNR_0dB.dat", 100000, 1000);
		sm2.fillSequence();
		Sequence s2 = sm2.getSequence();
		System.out.println(Detector.calculateSignalRate(s2, threshold_0, 100000, 1000));
		
		System.out.println(s2.getBlocks()[50].calculateBlockPower());
		
		SequenceManager sm3 = new SequenceManager("src/seq_2_SNR_10dB.dat", 100000, 1000);
		sm3.fillSequence();
		Sequence s3 = sm3.getSequence();
		System.out.println(Detector.calculateSignalRate(s2, threshold_Pos, 100000, 1000));
		System.out.println(s3.getBlocks()[50].calculateBlockPower());
	}
		
}
