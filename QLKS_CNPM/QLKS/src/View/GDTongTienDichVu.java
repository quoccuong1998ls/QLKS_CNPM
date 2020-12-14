package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.DAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class GDTongTienDichVu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtCMND;
	DefaultTableModel tbn = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDTongTienDichVu frame = new GDTongTienDichVu();
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
	public GDTongTienDichVu() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 414, 126);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "SCMND", "TongTienDV" }));
		scrollPane.setViewportView(table);

		JButton btnCancel = new JButton("Trở lại");
		btnCancel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\THOAT1.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GDHoaDon().setVisible(true);
			}
		});
		btnCancel.setBounds(308, 252, 101, 36);
		contentPane.add(btnCancel);

		JLabel lblNewLabel = new JLabel("TỔNG TIỀN DỊCH VỤ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(111, 11, 199, 28);
		contentPane.add(lblNewLabel);

		txtCMND = new JTextField();
		txtCMND.setBounds(167, 50, 86, 20);
		contentPane.add(txtCMND);
		txtCMND.setColumns(10);

		JLabel lblCmnd = new JLabel("CMND :");
		lblCmnd.setBounds(111, 53, 46, 14);
		contentPane.add(lblCmnd);

		JButton btnSearch = new JButton("Tìm");
		btnSearch.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\managersearch.png"));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTable();

			}
		});
		btnSearch.setBounds(23, 252, 111, 36);
		contentPane.add(btnSearch);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadData();
			}
		});
		btnAdd.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\oui-icons-21-32.png"));
		btnAdd.setBounds(167, 252, 111, 36);
		contentPane.add(btnAdd);
		// loadData();
	}

	public void loadData() {
		try {
			float tong = 0;

			DAO d = new DAO();
			Connection conn = d.getSQLServerConnection();
			PreparedStatement ps = conn.prepareStatement(
					"select t_khachhang.SCMND,t_dichvusudung.ThanhTien\r\n" + "from t_dichvusudung,t_khachhang\r\n"
							+ "where t_dichvusudung.SCMND=t_khachhang.SCMND and t_khachhang.SCMND =?");
			ps.setString(1, txtCMND.getText());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				tong += rs.getFloat("ThanhTien");

			}

			tbn = (DefaultTableModel) table.getModel();
			tbn.addRow(new Object[] { txtCMND.getText(), tong

			});
			try {

				ps = conn.prepareStatement("INSERT INTO t_tongtienDV VALUES(?,?)");
				ps.setString(1, txtCMND.getText());

				ps.setFloat(2, tong);

				int chk = ps.executeUpdate();
				if (chk > 0) {
					JOptionPane.showMessageDialog(rootPane, "them thanh cong");
					tbn.setRowCount(0);
					// loadData();
				} else {

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void showTable() {
		try {
			float tong = 0;

			DAO d = new DAO();
			Connection conn = d.getSQLServerConnection();
			PreparedStatement ps = conn.prepareStatement(
					"select t_khachhang.SCMND,t_dichvusudung.ThanhTien\r\n" + "from t_dichvusudung,t_khachhang\r\n"
							+ "where t_dichvusudung.SCMND=t_khachhang.SCMND and t_khachhang.SCMND =?");
			ps.setString(1, txtCMND.getText());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				tong += rs.getFloat("ThanhTien");

			}

			tbn = (DefaultTableModel) table.getModel();
			tbn.addRow(new Object[] { txtCMND.getText(), tong

			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
