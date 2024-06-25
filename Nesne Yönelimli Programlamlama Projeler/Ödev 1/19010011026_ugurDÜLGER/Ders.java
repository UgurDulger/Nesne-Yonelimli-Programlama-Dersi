
public class Ders {
	private int bolNo;
	private int dersID;
	private String dersAd;
	private int dersKredi;
	private static int say = 0;
	
	public Ders(int bolNo, String dersAd, int dersKredi) {
		this.dersID = ++say;
		this.bolNo = bolNo;
		this.dersAd = dersAd;
		this.dersKredi = dersKredi;
	}
	

	public int getBolNo() {
		return bolNo;
	}

	public void setBolNo(int bolNo) {
		this.bolNo = bolNo;
	}

	public String getDersAd() {
		return dersAd;
	}

	public void setDersAd(String dersAd) {
		this.dersAd = dersAd;
	}

	public int getDersKredi() {
		return dersKredi;
	}

	public void setDersKredi(int dersKredi) {
		this.dersKredi = dersKredi;
	}

	public int getDersID() {
		return dersID;
	}

	public void setDersID(int dersID) {
		this.dersID = dersID;
	}
	
	
	
	
	

}
