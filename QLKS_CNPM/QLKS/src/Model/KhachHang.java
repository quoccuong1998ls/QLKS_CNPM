package Model;

import java.util.Date;

public class KhachHang {
	private String MaKH;
	private String CNND;
	private String name;
	private String diaChi;
	private String SDT;
	private String gioiTinh;
	private String quocTich;
	private Date ngayDen;
	private Date ngayTra;
	private String maPhong;
	
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KhachHang(String maKH, String cNND, String name, String diaChi, String sDT, String gioiTinh, String quocTich,
			Date ngayDen, Date ngayTra, String maPhong) {
		super();
		this.MaKH = MaKH;
		this.CNND = CNND;
		this.name = name;
		this.diaChi = diaChi;
		this.SDT = SDT;
		this.gioiTinh = gioiTinh;
		this.quocTich = quocTich;
		this.ngayDen = ngayDen;
		this.ngayTra = ngayTra;
		this.maPhong = maPhong;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}

	public String getCNND() {
		return CNND;
	}

	public void setCNND(String cNND) {
		CNND = cNND;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public Date getNgayDen() {
		return ngayDen;
	}

	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	
	
	
	
	
	
	
	

}