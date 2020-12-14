package Model;

import java.util.Date;

public class HoaDon {
	private String CMND;
	private String hoTen;
	private String MaP;
	private double tienP;
	private double tienDV;
	private double Tong;
	private Date ngayLapHoaDon;
	public HoaDon(String cMND, String hoTen, String maP, double tienP, double tienDV, double tong, Date ngayLapHoaDon) {
		super();
		this.CMND = cMND;
		this.hoTen = hoTen;
		this.MaP = maP;
		this.tienP = tienP;
		this.tienDV = tienDV;
		Tong = tong;
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getMaP() {
		return MaP;
	}
	public void setMaP(String maP) {
		MaP = maP;
	}
	public double getTienP() {
		return tienP;
	}
	public void setTienP(double tienP) {
		this.tienP = tienP;
	}
	public double getTienDV() {
		return tienDV;
	}
	public void setTienDV(double tienDV) {
		this.tienDV = tienDV;
	}
	public double getTong() {
		return Tong;
	}
	public void setTong(double tong) {
		Tong = tong;
	}
	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}
	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	
}
