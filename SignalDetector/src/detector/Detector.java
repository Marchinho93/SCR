package detector;

import sequence.Sequence;
import threshold.ThresholdManager;

public class Detector {
	
	public static int calculateSignalRate(Sequence s, ThresholdManager t, int N, int Nb){
		int over=0;
		int under=0;
		for(int i=0;i<(100);i++){
			Double blockPower =s.getBlocks()[i].calculateBlockPower();
			if(blockPower > t.getThreshold()){
				over++;
			}
			else{
				under++;
			}
		}
		return over;
	}
}
