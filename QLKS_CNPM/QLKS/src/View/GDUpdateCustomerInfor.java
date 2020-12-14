package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.DAO;

import static Controller.DAO.getSQLServerConnection;
import Model.KhachHang;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class GDUpdateCustomerInfor extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCMND;
	private JTextField txtDiaChi;
	private JTextField txtHoTen;
	private JTextField txtSDT;
	private JTextField txtGioiTinh;
	private JButton btnThem;
	private JButton btnReset;
	private JButton btnCancel;
	private JButton btnXoa;
	private JButton btnSua;
	private JTextField txtQuocTich;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JTextField txtMaKH;
	private ArrayList<KhachHang> list;
	private int selectedIndex;
	private JComboBox comboBox;
	private JDateChooser NgayDen;
	private JDateChooser NgayTra;
	DefaultTableModel tbn = new DefaultTableModel();
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDUpdateCustomerInfor frame = new GDUpdateCustomerInfor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GDUpdateCustomerInfor() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Số CMND :");
		lblNewLabel.setBounds(42, 92, 84, 14);
		contentPane.add(lblNewLabel);

		JLabel lblaCh = new JLabel("Địa chỉ :");
		lblaCh.setBounds(42, 154, 84, 14);
		contentPane.add(lblaCh);

		JLabel lblMPhng = new JLabel("Mã phòng : ");
		lblMPhng.setBounds(42, 320, 84, 14);
		contentPane.add(lblMPhng);

		JLabel lblHTn = new JLabel("Họ tên :");
		lblHTn.setBounds(42, 123, 65, 14);
		contentPane.add(lblHTn);

		JLabel lblSt = new JLabel("SDT :");
		lblSt.setBounds(42, 185, 65, 14);
		contentPane.add(lblSt);

		JLabel lblNgyn = new JLabel("Giới tính :");
		lblNgyn.setBounds(42, 216, 65, 14);
		contentPane.add(lblNgyn);

		txtCMND = new JTextField();
		txtCMND.setBounds(117, 89, 117, 20);
		contentPane.add(txtCMND);
		txtCMND.setColumns(10);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(117, 151, 117, 20);
		contentPane.add(txtDiaChi);

		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(117, 120, 117, 20);
		contentPane.add(txtHoTen);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(117, 182, 117, 20);
		contentPane.add(txtSDT);

		txtGioiTinh = new JTextField();
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(117, 213, 117, 20);
		contentPane.add(txtGioiTinh);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\THEM.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				// if(table.getSelectedRowCount() > 0) {
				// try {
				// DAO d = new DAO();
				// Connection conn = d.getSQLServerConnection();
				// PreparedStatement ps = conn.prepareStatement("select TinhTrang from t_phong
				// where MaP = " + comboBox.getSelectedItem().toString());
				// // ps.setString(1, (String) comboBox.getSelectedItem());
				// ResultSet rs = ps.executeQuery();
				//
				// if(rs.getString("TinhTrang").equals("SuDung")) {
				// JOptionPane.showMessageDialog(rootPane, "chọn lại phòng");
				//
				// }
				// }catch(Exception e) {
				// e.printStackTrace();
				// }
				// }
				try {
					DAO d = new DAO();
					KhachHang k = new KhachHang();
					Connection conn = d.getSQLServerConnection();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO t_khachhang VALUES(?,?,?,?,?,?,?,?,?,?)");
					ps.setString(1, txtMaKH.getText());
					ps.setString(2, txtCMND.getText());
					ps.setString(3, txtHoTen.getText());
					ps.setString(4, txtDiaChi.getText());
					ps.setString(5, txtSDT.getText());
					ps.setString(6, txtGioiTinh.getText());
					ps.setString(7, txtQuocTich.getText());
					// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					ps.setString(8, ((JTextField) NgayDen.getDateEditor().getUiComponent()).getText());
//					try {
//						String value = comboBox.getSelectedItem().toString();
//						PreparedStatement ps1 = conn.prepareStatement("select TinhTrang \r\n" + "from t_phong\r\n" + "where MaP = 'P1'");
//						// ps.setString(1, value);
//						ResultSet rs = ps1.executeQuery();
//						if (rs.next()) {
//							if (rs.getString("TinhTrang").equals("SuDung")) {
//								JOptionPane.showMessageDialog(rootPane, "phòng đã đc dùng,chọn lại phòng");
//								ps.setString(9, comboBox.getSelectedItem().toString());
//
//							}
//						}
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
					ps.setString(9, comboBox.getSelectedItem().toString());
					ps.setString(10, ((JTextField) NgayTra.getDateEditor().getUiComponent()).getText());
					
					
					
					

					int chk = ps.executeUpdate();
					if (chk > 0) {
						JOptionPane.showMessageDialog(rootPane, "them thanh cong");
						tbn.setRowCount(0);
						loadData();
					} else {

					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				try {
					DAO d = new DAO();
					Connection conn = d.getSQLServerConnection();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO t_dichvusudung VALUES(?,?,?,?)");
					ps.setString(1, txtCMND.getText());
					ps.setString(2, "DP");
					ps.setInt(3, 0);
					ps.setFloat(4, 0);

					int chk = ps.executeUpdate();
					if (chk > 0) {
						// JOptionPane.showMessageDialog(rootPane, "them thanh cong DV");
						tbn.setRowCount(0);
						loadData();
					} else {

					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

//				 try {
//				 DAO d = new DAO();
//				 Connection conn = d.getSQLServerConnection();
//				 int row = table.getSelectedRow();
//				 String values = table.getModel().getValueAt(row, 0).toString();
//				 PreparedStatement ps = conn.prepareStatement("update t_phong \r\n" +
//				 "set TinhTrang = 'SuDung'\r\n" +
//				 "from t_khachhang\r\n" +
//				 "where t_khachhang.MaP = t_phong.MaP and t_khachhang.MaKH = "+values );
//				
//				 //ps.setString(1, "SuDung");
//				
//				
//				 ps.executeUpdate();
//				 tbn.setRowCount(0);
//				 loadData();
//				 }catch(Exception e) {
//				 e.printStackTrace();
//				 }
			}
		});
		btnThem.setBounds(42, 412, 89, 23);
		contentPane.add(btnThem);

		btnReset = new JButton("Làm mới");
		btnReset.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\CLEAR.png"));
		btnReset.setBounds(238, 412, 89, 23);
		contentPane.add(btnReset);

		btnCancel = new JButton("Trợ lại");
		btnCancel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\THOAT.png"));
		btnCancel.setBounds(802, 412, 112, 23);
		contentPane.add(btnCancel);

		JLabel lblQuocTich = new JLabel("Quốc tịch :");
		lblQuocTich.setBounds(42, 247, 65, 14);
		contentPane.add(lblQuocTich);

		JLabel label_1 = new JLabel("Ngày đến :");
		label_1.setBounds(42, 284, 65, 14);
		contentPane.add(label_1);

		txtQuocTich = new JTextField();
		txtQuocTich.setColumns(10);
		txtQuocTich.setBounds(117, 244, 117, 20);
		contentPane.add(txtQuocTich);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(263, 60, 682, 318);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				// "MaKH", "SCMND", "Ho ten", "Dia chi", "SDT", "Gioi tinh", "Quoc tich", "Ngay
				// den", "Ma phong", "NgayTra"
		}));
		scrollPane.setViewportView(table);

		lblNewLabel_1 = new JLabel("MaKH");
		lblNewLabel_1.setBounds(42, 61, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtMaKH = new JTextField();
		txtMaKH.setBounds(117, 58, 117, 20);
		contentPane.add(txtMaKH);
		txtMaKH.setColumns(10);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\SUA.png"));
		btnSua.setBounds(428, 412, 89, 23);
		contentPane.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\XOA.png"));
		btnXoa.setBounds(627, 412, 89, 23);
		contentPane.add(btnXoa);

		JLabel lblNewLabel_2 = new JLabel("Ngày trả :");
		lblNewLabel_2.setBounds(42, 358, 58, 20);
		contentPane.add(lblNewLabel_2);

		comboBox = new JComboBox();
		comboBox.setBounds(117, 316, 117, 22);
		contentPane.add(comboBox);

		NgayDen = new JDateChooser();
		NgayDen.setBounds(117, 278, 117, 20);
		contentPane.add(NgayDen);

		NgayTra = new JDateChooser();
		NgayTra.setBounds(117, 358, 117, 20);
		contentPane.add(NgayTra);

		lblNewLabel_3 = new JLabel("CẬP NHẬT THÔNG TIN KHÁCH HÀNG");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setInheritsPopupMenu(true);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setRequestFocusEnabled(true);
		lblNewLabel_3.setEnabled(true);
		lblNewLabel_3.setBounds(207, 11, 378, 38);
		contentPane.add(lblNewLabel_3);
		btnCancel.addActionListener(this);
		btnReset.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		this.setLocationRelativeTo(null);
		loadData();
		loadComobox();

	}

	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if (a.getSource().equals(btnReset)) {
			btnResetClick();
		} else if (a.getSource().equals(btnXoa)) {
			btnXoaClick();
		} else if (a.getSource().equals(btnCancel)) {
			btnCancelClick();
		} else {
			btnSuaClick();
		}

	}

	public void btnResetClick() {
		txtMaKH.setText("");
		txtCMND.setText("");
		txtHoTen.setText("");
		txtDiaChi.setText("");
		txtSDT.setText("");
		txtGioiTinh.setText("");
		txtQuocTich.setText("");
		// NgayDen.setText("");
		// //txtMaP.setText("");
		// NgayTra.setText("");
	}

	public void btnXoaClick() {
		// int removeIndex = table.getSelectedRow();
		// if(removeIndex == -1) {
		// JOptionPane.showMessageDialog(rootPane, "chon 1 dong roi an nut Xoa");
		// }else if(list.size() == 0) {
		// JOptionPane.showMessageDialog(rootPane, "khong co thong tin nao");
		// }else {
		// list.remove(removeIndex);
		// showTable();
		// }
		DAO d = new DAO();

		Connection conn = d.getSQLServerConnection();

		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "chọn 1 dòng cần xóa");
		} else {
			if (xoadichvusudung(d) == true) {
				try {

					String values = table.getModel().getValueAt(row, 0).toString();
					PreparedStatement ps = conn.prepareStatement("Delete from t_khachhang where MaKH= " + values);
					// ps.setString(1, table.getValueAt(table.getSelectedRow(), 0).toString());
					if (JOptionPane.showConfirmDialog(rootPane, "bạn muốn xóa khách này", "comfirm",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						ps.executeUpdate();
						tbn.setRowCount(0);
						loadData();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					// JOptionPane.showMessageDialog(rootPane, "chọn 1 khách hàng");
					e.printStackTrace();
				}
			}
		}

		try {

			// row = table.getSelectedRowCount();
			// (row >= 0) {
			// for(int i = 1; i <= row; i++) {
			// String values = table.getModel().getValueAt(row, 8).toString();
			PreparedStatement ps = conn.prepareStatement("update t_phong  set TinhTrang = ? where t_phong.MaP= ?");
			ps.setString(2, (String) comboBox.getSelectedItem());
			ps.setString(1, "Trong");

			ps.executeUpdate();

			// }

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void btnSuaClick() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "chọn 1 hang để sửa");
		} else {
			try {
				DAO d = new DAO();
				Connection conn = d.getSQLServerConnection();
				PreparedStatement ps = conn.prepareStatement(
						"Update t_khachhang set SCMND=?,HoTen=?,DiaChi=?,SDT=?,GioiTinh=?,QuocTich=?,NgayDen=?,MaP=?,NgayTra=? where MaKH = ?");
				ps.setString(10, txtMaKH.getText());
				ps.setString(1, txtCMND.getText());
				ps.setString(2, txtHoTen.getText());
				ps.setString(3, txtDiaChi.getText());
				ps.setString(4, txtSDT.getText());
				ps.setString(5, txtGioiTinh.getText());
				ps.setString(6, txtQuocTich.getText());
				ps.setString(7, ((JTextField) NgayDen.getDateEditor().getUiComponent()).getText());
				ps.setString(8, comboBox.getSelectedItem().toString());
				ps.setString(9, ((JTextField) NgayTra.getDateEditor().getUiComponent()).getText());
				ps.executeUpdate();
				tbn.setRowCount(0);
				loadData();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void btnCancelClick() {

		new ManuView().setVisible(true);
		this.dispose();

	}

	public void loadData() {
		try {
			DAO d = new DAO();
			Connection conn = d.getSQLServerConnection();
			int number;
			Vector row, column;
			column = new Vector();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from t_khachhang");
			ResultSetMetaData metadata = rs.getMetaData();
			number = metadata.getColumnCount();

			for (int i = 1; i <= number; i++) {
				column.add(metadata.getColumnName(i));
			}
			tbn.setColumnIdentifiers(column);

			while (rs.next()) {
				row = new Vector();
				for (int i = 1; i <= number; i++) {
					row.addElement(rs.getString(i));
				}
				tbn.addRow(row);
				table.setModel(tbn);

			}
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					if (table.getSelectedRow() >= 0) {
						txtMaKH.setText(table.getValueAt(table.getSelectedRow(), 0) + "");
						txtCMND.setText(table.getValueAt(table.getSelectedRow(), 1) + "");
						txtCMND.setEditable(false);
						txtHoTen.setText(table.getValueAt(table.getSelectedRow(), 2) + "");
						txtDiaChi.setText(table.getValueAt(table.getSelectedRow(), 3) + "");
						txtSDT.setText(table.getValueAt(table.getSelectedRow(), 4) + "");
						txtGioiTinh.setText(table.getValueAt(table.getSelectedRow(), 5) + "");
						txtQuocTich.setText(table.getValueAt(table.getSelectedRow(), 6) + "");
						try {
							tbn = (DefaultTableModel) table.getModel();
							Date date = new SimpleDateFormat("yyyy-MM-dd")
									.parse((String) tbn.getValueAt(table.getSelectedRow(), 7));
							NgayDen.setDate(date);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// NgayDen.setDate(sdf.parse((String) table.getValueAt(table.getSelectedRow(),
						// 6))+"");
						comboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(), 8) + "");
						try {
							tbn = (DefaultTableModel) table.getModel();
							Date date = new SimpleDateFormat("yyyy-MM-dd")
									.parse((String) tbn.getValueAt(table.getSelectedRow(), 9));
							NgayTra.setDate(date);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			});
		} catch (Exception ex) {

		}
		int row = table.getSelectedRow();
		try {
			DAO d = new DAO();
			Connection conn = d.getSQLServerConnection();
			row = table.getSelectedRowCount();
			if (row >= 0) {
				// for(int i = 1; i <= row; i++) {
				// String values = table.getModel().getValueAt(row, 8).toString();
				PreparedStatement ps = conn.prepareStatement("update t_phong  set TinhTrang = ? where t_phong.MaP=?");
				ps.setString(2, (String) comboBox.getSelectedItem());
				ps.setString(1, "SuDung");

				ps.executeUpdate();

			} else {
				PreparedStatement ps = conn.prepareStatement("update t_phong set TinhTrang ='Trong' ");

				ps.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(table.getSelectedRowCount());

	}

	public void loadComobox() {
		try {
			DAO d = new DAO();
			Connection conn = d.getSQLServerConnection();
			PreparedStatement ps = conn.prepareStatement("Select MaP,TinhTrang from t_phong ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				comboBox.addItem(rs.getString("MaP"));

			}
			// if(rs.getString("TinhTrang").equalsIgnoreCase("Trong")) {
			// //comboBox.addItem(rs.getString("MaP"));
			//
			// }
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
// khi xoa khach hang thi xoa cac dich vu mà khach hang do dang su dung
	public boolean xoadichvusudung(DAO d) {

		Connection conn = d.getSQLServerConnection();
		PreparedStatement ps;
		try {
			int row = table.getSelectedRow();
			String values = table.getModel().getValueAt(row, 1).toString();
			ps = conn.prepareStatement("delete\r\n" + "from t_dichvusudung from t_khachhang\r\n"
					+ "where t_khachhang.SCMND=t_dichvusudung.SCMND and t_dichvusudung.SCMND =" + values);
			// ps.setString(1, table.getValueAt(table.getSelectedRow(), 0).toString());
			// ps.setString(1, table.getValueAt(table.getSelectedRow(), 0).toString());
			// if (JOptionPane.showConfirmDialog(this, "delete this service", "comfirm",
			// JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

			ps.executeUpdate();
			tbn.setRowCount(0);
			loadData();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
