package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.DAO;
import Model.KhachHang;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class GDSearchUser extends JFrame {

	private JPanel contentPane;
	private JTable table;
	// DefaultTableModel tbn = new DefaultTableModel();
	private PreparedStatement stmt;
	private ResultSet rs;
	private JTextField txtSearch;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	DefaultTableModel tbl = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDSearchUser frame = new GDSearchUser();
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
	public GDSearchUser() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 485, 262);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnCancel = new JButton("Tr\u1EE3 l\u1EA1i");
		btnCancel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\THOAT1.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ManuView().setVisible(true);
			}
		});
		btnCancel.setBounds(336, 407, 101, 41);
		contentPane.add(btnCancel);

		JButton btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\managersearch.png"));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Search = txtSearch.getText().trim();
				Vector cols = new Vector<>();
				cols.addElement("MaKH");
				cols.addElement("SCMND");
				cols.addElement("HoTen");
				cols.addElement("DiaChi");
				cols.addElement("SDT");
				cols.addElement("GioiTinh");
				cols.addElement("QuocTich");
				cols.addElement("NgayDen");
				cols.addElement("MaP");
				cols.addElement("NgayTra");

				Vector dataSearch = new Vector<>();
				String option = comboBox.getSelectedItem().toString();
				
				
				switch (option) {
//				
				case "SCMND":
					try {
						DAO d = new DAO();
						Connection conn = d.getSQLServerConnection();
						String sql = "SELECT * FROM t_khachhang where SCMND like ?";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, txtSearch.getText() + "%");
						rs = stmt.executeQuery();
						while (rs.next()) {
							Vector user = new Vector<>();
							user.add(rs.getString("MaKH"));
							user.add(rs.getString("SCMND"));
							user.add(rs.getString("HoTen"));
							user.add(rs.getString("DiaChi"));
							user.add(rs.getString("SDT"));
							user.add(rs.getString("GioiTinh"));
							user.add(rs.getString("QuocTich"));
							user.add(rs.getString("NgayDen"));
							user.add(rs.getString("MaP"));
							user.add(rs.getString("NgayTra"));
							dataSearch.addElement(user);
						}

					} catch (Exception e) {
						// TODO: handle exception
					}
					break;
				case "Tên khách":
					try {
						DAO d = new DAO();
						Connection conn = d.getSQLServerConnection();
						String sql = "SELECT * FROM t_khachhang where HoTen like ?";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, txtSearch.getText() + "%");
						rs = stmt.executeQuery();
						while (rs.next()) {
							Vector user = new Vector<>();
							user.add(rs.getString("MaKH"));
							user.add(rs.getString("SCMND"));
							user.add(rs.getString("HoTen"));
							user.add(rs.getString("DiaChi"));
							user.add(rs.getString("SDT"));
							user.add(rs.getString("GioiTinh"));
							user.add(rs.getString("QuocTich"));
							user.add(rs.getString("NgayDen"));
							user.add(rs.getString("MaP"));
							user.add(rs.getString("NgayTra"));
							dataSearch.addElement(user);
						}

					} catch (Exception e) {
						// TODO: handle exception
					}
					break;
				default:
					try {
						DAO d = new DAO();
						Connection conn = d.getSQLServerConnection();
						String sql = "SELECT * FROM t_khachhang";
						stmt = conn.prepareStatement(sql);
						rs = stmt.executeQuery();
						
						while (rs.next()) {
							Vector user = new Vector<>();
							user.add(rs.getString("MaKH"));
							user.add(rs.getString("SCMND"));
							user.add(rs.getString("HoTen"));
							user.add(rs.getString("DiaChi"));
							user.add(rs.getString("SDT"));
							user.add(rs.getString("GioiTinh"));
							user.add(rs.getString("QuocTich"));
							user.add(rs.getString("NgayDen"));
							user.add(rs.getString("MaP"));
							user.add(rs.getString("NgayTra"));
							if (user.toString().toLowerCase().contains(Search)) {
								dataSearch.addElement(user);
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					break;
				}
				table.setModel(new DefaultTableModel(dataSearch, cols));
			}
			

		});
		btnTim.setBounds(92, 407, 101, 41);
		contentPane.add(btnTim);

		txtSearch = new JTextField();
		txtSearch.setBounds(199, 71, 86, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] {"SCMND", "Tên khách"}));
		comboBox.setBounds(80, 70, 101, 22);
		contentPane.add(comboBox);

		lblNewLabel = new JLabel("TÌM KHÁCH");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(149, 11, 200, 32);
		contentPane.add(lblNewLabel);

	}

}
