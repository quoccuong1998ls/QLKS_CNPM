package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.DAO;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class GDSearchRoom extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;
	private PreparedStatement stmt;
	private ResultSet rs;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDSearchRoom frame = new GDSearchRoom();
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
	public GDSearchRoom() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MaP", "TinhTrang"}));
		comboBox.setBounds(77, 85, 90, 22);
		contentPane.add(comboBox);

		txtSearch = new JTextField();
		txtSearch.setBounds(208, 86, 86, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 156, 539, 178);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnSearch = new JButton("Tìm");
		btnSearch.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\managersearch.png"));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Search = txtSearch.getText().trim();
				Vector cols = new Vector<>();
				cols.addElement("MaP");
				cols.addElement("TinhTrang");
				cols.addElement("GiaPhong");
				cols.addElement("LoaiPhong");

				Vector dataSearch = new Vector<>();
				String option = comboBox.getSelectedItem().toString();
				switch (option) {
				
				case "MaP":
					try {
						DAO d = new DAO();
						Connection conn = d.getSQLServerConnection();
						String sql = "SELECT * FROM t_phong where MaP like ?";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, txtSearch.getText() + "%");
						rs = stmt.executeQuery();
						while (rs.next()) {
							Vector user = new Vector<>();
							user.add(rs.getString("MaP"));
							user.add(rs.getString("TinhTrang"));
							user.add(rs.getString("GiaPhong"));
							user.add(rs.getString("LoaiPhong"));
							dataSearch.addElement(user);
						}

					} catch (Exception e) {
						// TODO: handle exception
					}
					break;
				case "TinhTrang":
					try {
						DAO d = new DAO();
						Connection conn = d.getSQLServerConnection();
						String sql = "SELECT * FROM t_phong where TinhTrang like ?";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, txtSearch.getText() + "%");
						rs = stmt.executeQuery();
						while (rs.next()) {
							Vector user = new Vector<>();
							user.add(rs.getString("MaP"));
							user.add(rs.getString("TinhTrang"));
							user.add(rs.getString("GiaPhong"));
							user.add(rs.getString("LoaiPhong"));
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
						String sql = "SELECT * FROM t_phong";
						stmt = conn.prepareStatement(sql);
						rs = stmt.executeQuery();
						while (rs.next()) {
							Vector user = new Vector<>();
							user.add(rs.getString("MaP"));
							user.add(rs.getString("TinhTrang"));
							user.add(rs.getString("GiaPhong"));
							user.add(rs.getString("LoaiPhong"));
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
		btnSearch.setBounds(92, 385, 110, 33);
		contentPane.add(btnSearch);

		JButton btnCancel = new JButton("Trở lại");
		btnCancel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\THOAT1.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ManuView().setVisible(true);
			}
		});
		btnCancel.setBounds(354, 385, 110, 33);
		contentPane.add(btnCancel);

		JLabel lblNewLabel = new JLabel("T\u00CCM PH\u00D2NG");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(145, 11, 232, 33);
		contentPane.add(lblNewLabel);
	}

}
