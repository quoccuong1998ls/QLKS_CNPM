package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.DAO;
import Model.HoaDon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class GDHoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField CMND;
	private JTextField txtTen;
	private JTextField txtTienP;
	private JTextField txtTienDV;
	private JTextField txtTong;
	private JButton btnIn;
	private JButton btnCancel;
	private JButton btnTim;

	// String url=null;
	// List<String> PTCTT=null;
	DefaultTableModel model = null;

	float TongTien = 0;
	private JTable table;
	private JTextField txtMaP;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDHoaDon frame = new GDHoaDon();
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
	public GDHoaDon() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nhập SCMND");
		lblNewLabel.setBounds(67, 42, 66, 14);
		contentPane.add(lblNewLabel);

		CMND = new JTextField();
		CMND.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					String sCMND = CMND.getText();
					DAO d = new DAO();
					Connection conn = d.getSQLServerConnection();
					PreparedStatement pst;
					ResultSet rs;
					try {
						pst = conn.prepareStatement("select * from t_khachhang where SCMND =?");
						pst.setString(1, sCMND);
						rs = pst.executeQuery();

						if (rs.next() == false) {
							JOptionPane.showMessageDialog(rootPane, " nhap lai so CMND");
						} else {

							String map = rs.getString("MaP");
							String Ten = rs.getString("HoTen");
							txtTen.setText(Ten.trim());
							txtMaP.setText(map.trim());
							// txtCMND.setText(cmnd.trim());
							// comboBox.setSelectedItem(rs.getString("MaP").trim());

						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		CMND.setBounds(156, 39, 86, 20);
		contentPane.add(CMND);
		CMND.setColumns(10);

		JLabel lblHoten = new JLabel("HoTen :");
		lblHoten.setBounds(67, 90, 46, 14);
		contentPane.add(lblHoten);

		JLabel lblTienphong = new JLabel("Tienphong :");
		lblTienphong.setBounds(67, 196, 79, 14);
		contentPane.add(lblTienphong);

		JLabel lblTiendv = new JLabel("TienDV :");
		lblTiendv.setBounds(67, 245, 79, 17);
		contentPane.add(lblTiendv);

		JLabel lblMap = new JLabel("MaP :");
		lblMap.setBounds(67, 141, 79, 14);
		contentPane.add(lblMap);

		JLabel lblTongtien = new JLabel("TongTien :");
		lblTongtien.setBounds(67, 299, 79, 14);
		contentPane.add(lblTongtien);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(156, 87, 86, 20);
		contentPane.add(txtTen);

		txtTienP = new JTextField();
		txtTienP.setColumns(10);
		txtTienP.setBounds(156, 193, 86, 20);
		contentPane.add(txtTienP);

		txtTienDV = new JTextField();
		txtTienDV.setColumns(10);
		txtTienDV.setBounds(156, 243, 86, 20);
		contentPane.add(txtTienDV);

		txtTong = new JTextField();
		txtTong.setColumns(10);
		txtTong.setBounds(156, 296, 86, 20);
		contentPane.add(txtTong);

		btnIn = new JButton("In hóa đơn");
		btnIn.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\in.png"));
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(rootPane, "chọn 1 hàng để thanh toán");
				}else{
				try {
					Date now = new Date();
					Writer bw = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream("History" + CMND.getText().trim() + ".txt"), "UTF8"));
					bw.write("\t\tTHE HOTHEL CDH\r\n\r\n");
					bw.write("\t\tDIA CHI: 332 Nguyen Trai - Thanh Xuan - Ha Noi\r\n\r\n");
					bw.write("\t\tSĐT: 099999999\r\n\r\n");
					bw.write("\t\tHOA ĐON THANH TOAN\r\n\r\n");
//					bw.write("------------------------------------------------------------\r\n");
//					//bw.write("CMND\tHoTen\tMaP\tGiaPhong\tGiaDV\tThanhTien\r\n");
//					bw.write("-----------------------------------------------------------\r\n");
					bw.write("------------------------------------------------------------\r\n\r\n");
					bw.write("\t\tSoCMND:\t\t" + CMND.getText() + "\r\n");
					bw.write("\t\tHoTen:\t\t" + txtTen.getText() + "\r\n");
					bw.write("\t\tMaPhong:\t\t" + txtMaP.getText() + "\r\n");
					bw.write("\t\t--------------------------------------------\r\n");
					bw.write("\t\tTien Phong:\t\t\t" + txtTienP.getText() + " VNĐ\r\n");
					bw.write("\t\tTien dich vu:\t\t\t" + txtTienDV.getText() + " VNĐ\r\n");
					bw.write("\t\t--------------------------------------------\r\n");
					bw.write("\t\tThành tiền:\t\t\t" + txtTong.getText() + " VNĐ\r\n\r\n");
					bw.write("-------------------------------------------------------------\r\n\r\n\r\n");
					// bw.write("\t\tTiền khách đưa:\t\t\t" + formatter.format(guest) + " VNĐ\r\n");
					// bw.write("\t\tTiền trả lại:\t\t\t" + txtRepay.getText() + " VNĐ\r\n");
					//bw.write("------------------------------------------------------------\r\n");
					bw.write("                     CÁM ƠN QUÝ KHÁCH!\r\n");
					bw.write("                        HẸN GẶP LẠI!");
					bw.close();
					// }catch(Exception ex){
					// ex.printStackTrace();
					// }
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Runtime run = Runtime.getRuntime();
				try {
					run.exec("notepad History" + CMND.getText().trim() + ".txt");
				} catch (IOException e) {
				}
				
				DAO d = new DAO();

				Connection conn = d.getSQLServerConnection();

				if (xoadichvusudung(d) == true) {
					try {

						PreparedStatement ps = conn
								.prepareStatement("Delete from t_khachhang where SCMND= " + CMND.getText());
						// ps.setString(1, table.getValueAt(table.getSelectedRow(), 0).toString());
						if (JOptionPane.showConfirmDialog(rootPane, "xóa khách "+CMND.getText()+"khỏi bảng thông tin khách", "comfirm",
								JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							ps.executeUpdate();
							model.setRowCount(0);
							loadData();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {

						// row = table.getSelectedRowCount();
						// (row >= 0) {
						// for(int i = 1; i <= row; i++) {
						// String values = table.getModel().getValueAt(row, 8).toString();
						PreparedStatement ps = conn.prepareStatement("update t_phong  set TinhTrang = ? where t_phong.MaP= ?");
						ps.setString(2, txtMaP.getText());
						ps.setString(1, "Trong");

						ps.executeUpdate();

						// }

					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				}
			}
		});
		btnIn.setBounds(352, 383, 115, 41);
		contentPane.add(btnIn);

		btnCancel = new JButton("Thoát");
		btnCancel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\THOAT1.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ManuView().setVisible(true);
			}
		});
		btnCancel.setBounds(525, 383, 89, 41);
		contentPane.add(btnCancel);

		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\managersearch.png"));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sCMND = CMND.getText();
				float tienp = 0;
				float tiendv = 0;
				float tong = 0;
				DAO d = new DAO();
				Connection conn = d.getSQLServerConnection();
				PreparedStatement pst;
				ResultSet rs;
				try {
					pst = conn.prepareStatement(
							"select t_khachhang.SCMND,t_khachhang.HoTen,t_khachhang.MaP,DATEDIFF(day,NgayDen,NgayTra) as songay,t_phong.GiaPhong, t_tongtienDV.TongTienDV from t_khachhang,t_phong,t_tongtienDV where t_khachhang.MaP=t_phong.MaP and t_khachhang.SCMND = t_tongtienDV.SCMND and t_khachhang.SCMND =?");
					pst.setString(1, sCMND);
					rs = pst.executeQuery();

					while (rs.next()) {
						int songay = rs.getInt("songay");
						float giaphong = rs.getFloat("GiaPhong");
						tiendv = rs.getFloat("TongTienDV");
						tienp = songay * giaphong;
						tong = tiendv + tienp;
						model = (DefaultTableModel) table.getModel();
						model.addRow(
								new Object[] { CMND.getText(), rs.getString("HoTen"), rs.getString("MaP"), tienp, tiendv, tong

								});
						// int sum = 0;
						// for(int i = 0;i < table.getRowCount(); i++) {
						// sum += Integer.parseInt(table.getValueAt(i, 5).toString());
						// }
						// CMND.setText("");
						// txtTen.setText("");
						// txtCMND.requestFocus();
						loadData();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});
		btnTim.setBounds(24, 383, 89, 41);
		contentPane.add(btnTim);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(304, 87, 402, 272);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "CMND", "HoTen", "MaP", "tienp", "tiendv", "tong" }));
		scrollPane.setViewportView(table);

		txtMaP = new JTextField();
		txtMaP.setBounds(156, 138, 86, 20);
		contentPane.add(txtMaP);
		txtMaP.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("THANH TOÁN");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(304, 11, 195, 20);
		contentPane.add(lblNewLabel_1);

		btnAdd = new JButton("Thêm");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\oui-icons-21-32.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sCMND = CMND.getText();
				float tienp = 0;
				float tiendv = 0;
				float tong = 0;
				DAO d = new DAO();
				Connection conn = d.getSQLServerConnection();
				PreparedStatement pst;
				ResultSet rs;
				try {
					pst = conn.prepareStatement(
							"select t_khachhang.SCMND,t_khachhang.HoTen,t_khachhang.MaP,DATEDIFF(day,NgayDen,NgayTra) as songay,t_phong.GiaPhong, t_tongtienDV.TongTienDV from t_khachhang,t_phong,t_tongtienDV where t_khachhang.MaP=t_phong.MaP and t_khachhang.SCMND = t_tongtienDV.SCMND and t_khachhang.SCMND =?");
					pst.setString(1, sCMND);
					rs = pst.executeQuery();

					while (rs.next()) {
						int songay = rs.getInt("songay");
						float giaphong = rs.getFloat("GiaPhong");
						tiendv = rs.getFloat("TongTienDV");
						tienp = songay * giaphong;
						tong = tiendv + tienp;
						
						loadData();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				try {

					PreparedStatement ps = conn.prepareStatement("INSERT INTO t_hoadon VALUES(?,?,?,?,?,?)");
					ps.setString(1, CMND.getText());
					ps.setString(2, txtTen.getText());
					ps.setString(3, txtMaP.getText());
					ps.setFloat(4, tienp);
					ps.setFloat(5, tiendv);
					ps.setFloat(6, tong);

					int chk = ps.executeUpdate();
					if (chk > 0) {
						JOptionPane.showMessageDialog(rootPane, "them thanh cong");
						model.setRowCount(0);
						loadData();
					} else {

					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});
		btnAdd.setBounds(174, 383, 102, 41);
		contentPane.add(btnAdd);
		loadData();
		// System.out.println(tienDv());
		// loadData();
		model = (DefaultTableModel) table.getModel();
		// Indulieuramodel();
	}

	public float ThanhTien(long songay, float thanhtien) {
		float tien = 0;
		tien = thanhtien * songay;
		return tien;
	}

	// public float tienDv() {
	// String sCMND = CMND.getText();
	// DAO d = new DAO();
	// float tiendv = 0 ;
	// float dichvu = 0;
	// Connection conn = d.getSQLServerConnection();
	// PreparedStatement pst;
	// ResultSet rs;
	// try {
	// pst = conn.prepareStatement("select
	// t_dichvusudung.SCMND,t_dichvusudung.ThanhTien from t_dichvusudung where
	// t_dichvusudung.SCMND = ? ");
	// pst.setString(1, sCMND);
	// rs = pst.executeQuery();
	//
	// while(rs.next()) {
	// dichvu = rs.getFloat("ThanhTien");
	// tiendv +=dichvu;
	// }
	//
	//
	//
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return dichvu;
	// }
	public void loadData() {
		try {
			DAO d = new DAO();
			Connection conn = d.getSQLServerConnection();
			int number;
			Vector row, column;
			column = new Vector();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from t_hoadon");
			ResultSetMetaData metadata = rs.getMetaData();
			number = metadata.getColumnCount();

			for (int i = 1; i <= number; i++) {
				column.add(metadata.getColumnName(i));
			}
			model.setColumnIdentifiers(column);

			while (rs.next()) {
				row = new Vector();
				for (int i = 1; i <= number; i++) {
					row.addElement(rs.getString(i));
				}
				model.addRow(row);
				table.setModel(model);

			}
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					if (table.getSelectedRow() >= 0) {
						CMND.setText(table.getValueAt(table.getSelectedRow(), 0) + "");
						txtTen.setText(table.getValueAt(table.getSelectedRow(), 1) + "");
						txtMaP.setText(table.getValueAt(table.getSelectedRow(), 2) + "");
						txtTienP.setText(table.getValueAt(table.getSelectedRow(), 3) + "");
						txtTienDV.setText(table.getValueAt(table.getSelectedRow(), 4) + "");
						txtTong.setText(table.getValueAt(table.getSelectedRow(), 5) + "");

					}
				}
			});
		} catch (Exception ex) {

		}
	}

	public boolean xoadichvusudung(DAO d) {

		Connection conn = d.getSQLServerConnection();
		PreparedStatement ps;
		try {

			ps = conn.prepareStatement("delete\r\n" + "from t_dichvusudung from t_khachhang\r\n"
					+ "where t_khachhang.SCMND=t_dichvusudung.SCMND and t_dichvusudung.SCMND =" + CMND.getText());
			// ps.setString(1, table.getValueAt(table.getSelectedRow(), 0).toString());
			// ps.setString(1, table.getValueAt(table.getSelectedRow(), 0).toString());
//			if (JOptionPane.showConfirmDialog(this, "delete this service", "comfirm",
//					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

				ps.executeUpdate();
				model.setRowCount(0);
				loadData();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
