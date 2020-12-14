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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class GDDichVu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tbn = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDDichVu frame = new GDDichVu();
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
	public GDDichVu() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 478, 197);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnCancel = new JButton("Trở lại");
		btnCancel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\THOAT1.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ManuView().setVisible(true);
			}
		});
		btnCancel.setBounds(194, 288, 106, 23);
		contentPane.add(btnCancel);

		JLabel lblNewLabel = new JLabel("CHI TIẾT DỊCH VỤ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(111, 11, 246, 38);
		contentPane.add(lblNewLabel);
		loadData();
	}

	public void loadData() {
		try {
			DAO d = new DAO();
			Connection conn = d.getSQLServerConnection();
			int number;
			Vector row, column;
			column = new Vector();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from t_DV");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
