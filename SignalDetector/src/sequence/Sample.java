package sequence;

public class Sample {
	
	private Double im;
	private Double re;
	
	public Sample(Double im, Double re){
		this.im=im;
		this.re=re;
	}
	
	public Sample(Double[] val){
		this.im = val[1];
		this.re = val[0];
	}
	
	public Double getIm() {
		return im;
	}

	public void setIm(Double im) {
		this.im = im;
	}

	public Double getRe() {
		return re;
	}

	public void setRe(Double re) {
		this.re = re;
	}
	

}
