package Model;

public class Phong {
	private String MaP;
	private String tinhTrang;
	private double giaPhong;
	private String loaiPhong;
	public Phong(String maP, String tinhTrang, double giaPhong, String loaiPhong) {
		super();
		MaP = maP;
		this.tinhTrang = tinhTrang;
		this.giaPhong = giaPhong;
		this.loaiPhong = loaiPhong;
	}
	public String getMaP() {
		return MaP;
	}
	public void setMaP(String maP) {
		MaP = maP;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public double getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	
	

}
