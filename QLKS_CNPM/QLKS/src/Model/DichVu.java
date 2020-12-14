package Model;

public class DichVu {
	private String Madv;
	private String tenDV;
	private double giaDV;
	public DichVu(String madv, String tenDV, double giaDV) {
		super();
		Madv = madv;
		this.tenDV = tenDV;
		this.giaDV = giaDV;
	}
	public String getMadv() {
		return Madv;
	}
	public void setMadv(String madv) {
		Madv = madv;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public double getGiaDV() {
		return giaDV;
	}
	public void setGiaDV(double giaDV) {
		this.giaDV = giaDV;
	}
	
	

}
