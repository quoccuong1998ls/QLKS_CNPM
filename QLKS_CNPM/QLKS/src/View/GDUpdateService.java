package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controller.DAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class GDUpdateService extends JFrame {

	private JPanel contentPane;
	private JTextField txtSoluong;
	private JTextField txtDonGia;
	private JButton btnReset;
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnXoa;
	private JButton btnSua;
	private JComboBox comboCMND;
	private JComboBox comboMaDV;
	private JTable table;
	DefaultTableModel tbn = new DefaultTableModel();
	private JTextField txtThanhTien;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDUpdateService frame = new GDUpdateService();
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
	public GDUpdateService() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Số CMND :");
		lblNewLabel.setBounds(40, 71, 65, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Số lượng :");
		lblNewLabel_1.setBounds(40, 142, 65, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Mã DV :");
		lblNewLabel_2.setBounds(234, 71, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Đơn giá :");
		lblNewLabel_3.setBounds(234, 142, 72, 14);
		contentPane.add(lblNewLabel_3);

		txtSoluong = new JTextField();
		txtSoluong.setBounds(115, 139, 86, 20);
		contentPane.add(txtSoluong);
		txtSoluong.setColumns(10);

		txtDonGia = new JTextField();
		txtDonGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		txtDonGia.setBounds(305, 139, 86, 20);
		contentPane.add(txtDonGia);
		txtDonGia.setColumns(10);

		comboCMND = new JComboBox();
		comboCMND.setEditable(true);
		comboCMND.setBounds(115, 67, 86, 22);
		contentPane.add(comboCMND);

		comboMaDV = new JComboBox();
		comboMaDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboMaDV.getSelectedItem().toString().equals("DA")) {
					txtDonGia.setText("30000");
				} else if (comboMaDV.getSelectedItem().toString().equals("GL")) {
					txtDonGia.setText("100000");
				} else if (comboMaDV.getSelectedItem().toString().equals("TH")) {
					txtDonGia.setText("200000");
				} else if (comboMaDV.getSelectedItem().toString().equals("DP")) {
					txtDonGia.setText("0");
				} else {
					txtDonGia.setText("500000");
				}

			}
		});
		comboMaDV.setEditable(true);
		comboMaDV.setBounds(305, 67, 86, 22);
		contentPane.add(comboMaDV);

		btnReset = new JButton("Làm mới");
		btnReset.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\CLEAR.png"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtSoluong.setText("");
				txtDonGia.setText("");
			}
		});
		btnReset.setBounds(143, 391, 117, 23);
		contentPane.add(btnReset);

		btnAdd = new JButton("Thêm");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\THEM.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DAO d = new DAO();
					Connection conn = d.getSQLServerConnection();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO t_dichvusudung VALUES(?,?,?,?)");
					ps.setString(1, comboCMND.getSelectedItem().toString());
					ps.setString(2, comboMaDV.getSelectedItem().toString());
					ps.setFloat(3, Float.parseFloat(txtSoluong.getText()));
					ps.setFloat(4, Float.parseFloat(txtThanhTien.getText()));

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
			}
		});
		btnAdd.setBounds(10, 391, 89, 23);
		contentPane.add(btnAdd);

		btnCancel = new JButton("Trở lại");
		btnCancel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\THOAT.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ManuView().setVisible(true);

			}
		});
		btnCancel.setBounds(582, 391, 105, 23);
		contentPane.add(btnCancel);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\SUA.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(rootPane, "chọn 1 hang để sửa");
				}else {
				try {
					DAO d = new DAO();
					Connection conn = d.getSQLServerConnection();
					PreparedStatement ps = conn.prepareStatement("Update t_dichvusudung set Madv=?,SoLuong=?,ThanhTien=? where SCMND = ?");
					ps.setString(4, comboCMND.getSelectedItem().toString());
					ps.setString(1, comboMaDV.getSelectedItem().toString());
					ps.setFloat(2, Float.parseFloat(txtSoluong.getText()));
					ps.setFloat(3, Float.parseFloat(txtThanhTien.getText()));

					ps.executeUpdate();
					tbn.setRowCount(0);
					loadData();
				} catch (Exception e) {
					e.printStackTrace();
				}
				}
			}
		});
		btnSua.setBounds(305, 391, 89, 23);
		contentPane.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\XOA.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DAO d = new DAO();
				Connection conn = d.getSQLServerConnection();
				
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(rootPane, "chọn 1 dòng cần xóa");
				} else {
				try {
					PreparedStatement ps = conn.prepareStatement("Delete t_dichvusudung where SCMND=?");
					ps.setString(1, table.getValueAt(table.getSelectedRow(), 0).toString());
					if (JOptionPane.showConfirmDialog(rootPane, "delete this customer", "comfirm",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						ps.executeUpdate();
						tbn.setRowCount(0);
						loadData();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		btnXoa.setBounds(440, 391, 89, 23);
		contentPane.add(btnXoa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 185, 667, 182);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Thành Tiền :");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float soLuong, donGia, thanhTien;
				soLuong = Float.parseFloat(txtSoluong.getText());
				donGia = Float.parseFloat(txtDonGia.getText());
				thanhTien = soLuong * donGia;
				txtThanhTien.setText(String.format("%.1f", thanhTien));

			}
		});
		btnNewButton.setBounds(440, 67, 105, 23);
		contentPane.add(btnNewButton);

		txtThanhTien = new JTextField();
		txtThanhTien.setBounds(555, 68, 86, 20);
		contentPane.add(txtThanhTien);
		txtThanhTien.setColumns(10);

		lblNewLabel_4 = new JLabel("SỬ DỤNG DỊCH VỤ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(171, 11, 268, 30);
		contentPane.add(lblNewLabel_4);

		JButton btnNewButton_1 = new JButton("XemTongTienDV");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GDTongTienDichVu().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(440, 138, 201, 23);
		contentPane.add(btnNewButton_1);
		loadData();
		loadComboCMND();
		loadComboMaDV();
	}

	public void loadComboCMND() {
		try {
			DAO d = new DAO();
			Connection conn = d.getSQLServerConnection();
			PreparedStatement ps = conn.prepareStatement("Select SCMND from t_khachhang group by SCMND");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				comboCMND.addItem(rs.getString("SCMND"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public void loadComboMaDV() {
		try {
			DAO d = new DAO();
			Connection conn = d.getSQLServerConnection();
			PreparedStatement ps = conn.prepareStatement("Select Madv from t_DV group by Madv");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				comboMaDV.addItem(rs.getString("Madv"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public void loadData() {
		try {
			DAO d = new DAO();
			Connection conn = d.getSQLServerConnection();
			int number;
			Vector row, column;
			column = new Vector();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from t_dichvusudung");
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
						comboCMND.setSelectedItem(table.getValueAt(table.getSelectedRow(), 0) + "");
						comboMaDV.setSelectedItem(table.getValueAt(table.getSelectedRow(), 1) + "");
						txtSoluong.setText(table.getValueAt(table.getSelectedRow(), 2) + "");
						txtThanhTien.setText(table.getValueAt(table.getSelectedRow(), 3) + "");

					}
				}
			});
		} catch (Exception ex) {

		}
	}
}
