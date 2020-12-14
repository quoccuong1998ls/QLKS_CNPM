package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Phong;
import Controller.DAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class GDRoomUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaP;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnCancel;
	private JButton btnXoa;
	private JButton btnReset;
	private JTable table;
	private JTextField txtTinhTrang;
	private JComboBox comboBox;
	DefaultTableModel tbn = new DefaultTableModel();
	private JTextField txtGiaP;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDRoomUpdate frame = new GDRoomUpdate();
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
	public GDRoomUpdate() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã phòng :");
		lblNewLabel.setBounds(42, 62, 57, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Loại phòng :");
		lblNewLabel_1.setBounds(42, 128, 67, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Giá phòng :");
		lblNewLabel_2.setBounds(253, 62, 57, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tình trạng :");
		lblNewLabel_3.setBounds(253, 128, 57, 14);
		contentPane.add(lblNewLabel_3);

		txtMaP = new JTextField();
		txtMaP.setBounds(109, 59, 86, 20);
		contentPane.add(txtMaP);
		txtMaP.setColumns(10);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\THEM.png"));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DAO d = new DAO();
					Connection conn = d.getSQLServerConnection();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO t_phong VALUES(?,?,?,?)");
					ps.setString(1, txtMaP.getText());
					ps.setString(2, txtTinhTrang.getText());
					ps.setString(3, txtGiaP.getText());
					ps.setString(4, comboBox.getSelectedItem().toString());

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
		btnThem.setBounds(20, 383, 89, 23);
		contentPane.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\SUA.png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DAO d = new DAO();
					Connection conn = d.getSQLServerConnection();
					PreparedStatement ps = conn
							.prepareStatement("Update t_phong set TinhTrang=?,GiaPhong=?,LoaiPhong=? where MaP=?");
					ps.setString(4, txtMaP.getText());
					ps.setString(1, txtTinhTrang.getText());
					ps.setString(2, txtGiaP.getText());
					ps.setString(3, comboBox.getSelectedItem().toString());

					ps.executeUpdate();
					tbn.setRowCount(0);
					loadData();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSua.setBounds(133, 383, 89, 23);
		contentPane.add(btnSua);

		btnCancel = new JButton("Trở lại");
		btnCancel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\THOAT.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ManuView().setVisible(true);
			}
		});
		btnCancel.setBounds(473, 383, 100, 23);
		contentPane.add(btnCancel);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\XOA.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DAO d = new DAO();
				Connection conn = d.getSQLServerConnection();
				try {
					PreparedStatement ps = conn.prepareStatement("Delete t_phong where MaP=?");
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
		});
		btnXoa.setBounds(363, 383, 89, 23);
		contentPane.add(btnXoa);

		btnReset = new JButton("Làm mới");
		btnReset.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\CLEAR.png"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMaP.setText("");
				txtTinhTrang.setText("");
				txtGiaP.setText("");
			}
		});
		btnReset.setBounds(250, 383, 89, 23);
		contentPane.add(btnReset);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 174, 553, 196);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				// "MaPhong", "TinhTrang", "GiaPhong", "LoaiPhong"
		}));
		scrollPane.setViewportView(table);

		txtTinhTrang = new JTextField();
		txtTinhTrang.setBounds(321, 125, 86, 20);
		contentPane.add(txtTinhTrang);
		txtTinhTrang.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setBounds(109, 124, 86, 22);
		contentPane.add(comboBox);

		txtGiaP = new JTextField();
		txtGiaP.setBounds(321, 59, 86, 20);
		contentPane.add(txtGiaP);
		txtGiaP.setColumns(10);

		lblNewLabel_4 = new JLabel("CẬP NHẬT THÔNG TIN PHÒNG");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(139, 11, 303, 40);
		contentPane.add(lblNewLabel_4);

		loadData();
		loadComobox();
	}

	public void loadComobox() {
		try {
			DAO d = new DAO();
			Connection conn = d.getSQLServerConnection();
			PreparedStatement ps = conn.prepareStatement("Select LoaiPhong from t_phong group by LoaiPhong");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				comboBox.addItem(rs.getString("LoaiPhong"));
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
			ResultSet rs = st.executeQuery("Select * from t_phong");
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
						txtMaP.setText(table.getValueAt(table.getSelectedRow(), 0) + "");
						txtTinhTrang.setText(table.getValueAt(table.getSelectedRow(), 1) + "");
						txtGiaP.setText(table.getValueAt(table.getSelectedRow(), 2) + "");
						comboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(), 3) + "");

					}
				}
			});
		} catch (Exception ex) {

		}
	}

}
