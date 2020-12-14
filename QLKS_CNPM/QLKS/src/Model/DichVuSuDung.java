package Model;

public class DichVuSuDung {
	private String CMND;
	private String Madv;
	private int soLuong;
	private double thanhToan;
	public DichVuSuDung(String cMND, String madv, int soLuong, double thanhToan) {
		super();
		CMND = cMND;
		Madv = madv;
		this.soLuong = soLuong;
		this.thanhToan = thanhToan;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getMadv() {
		return Madv;
	}
	public void setMadv(String madv) {
		Madv = madv;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getThanhToan() {
		return thanhToan;
	}
	public void setThanhToan(double thanhToan) {
		this.thanhToan = thanhToan;
	}
	
	

}
