package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class ManuView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCNKhach;
	private JButton btnCNPhong;
	private JButton btnCNDichVu;
	private JButton btnChiTietDichVu;
	private JButton btnThanhToan;
	private JButton btnTimKhach;
	private JButton btnTimPhong;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManuView frame = new ManuView();
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
	public ManuView() {
		setTitle("CDH Hotel");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 707);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		contentPane.setBackground(new Color(255, 102, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKS\\hinh\\manu.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 650, 250);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ KHÁCH SẠN");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(292, 261, 289, 43);
		contentPane.add(lblNewLabel_1);

		btnCNKhach = new JButton("Thông tin khách hàng");
		btnCNKhach.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCNKhach.setName("");
		btnCNKhach.setVerticalAlignment(SwingConstants.TOP);
		btnCNKhach.setBounds(0, 302, 165, 23);
		contentPane.add(btnCNKhach);

		btnCNPhong = new JButton("Thông tin phòng");
		btnCNPhong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCNPhong.setBounds(0, 336, 165, 23);
		contentPane.add(btnCNPhong);

		btnCNDichVu = new JButton("Dịch vụ sử dụng");
		btnCNDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCNDichVu.setBounds(0, 370, 165, 23);
		contentPane.add(btnCNDichVu);

		btnChiTietDichVu = new JButton("Chi tiết dịch vụ");
		btnChiTietDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnChiTietDichVu.setBounds(0, 459, 165, 23);
		contentPane.add(btnChiTietDichVu);

		JLabel lblNewLabel_2 = new JLabel("Cập nhậtt  thông tin");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 263, 165, 28);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Chi tiết");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 417, 165, 25);
		contentPane.add(lblNewLabel_3);

		btnThanhToan = new JButton("Thông tin thanh toán");
		btnThanhToan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThanhToan.setToolTipText("");
		btnThanhToan.setBounds(0, 524, 165, 23);
		contentPane.add(btnThanhToan);

		JLabel lblNewLabel_4 = new JLabel("Thanh toán");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 493, 165, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Tìm kiếm");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setBounds(0, 558, 165, 26);
		contentPane.add(lblNewLabel_5);

		btnTimKhach = new JButton("Tìm khách hàng");
		btnTimKhach.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnTimKhach.setBounds(0, 595, 165, 23);
		contentPane.add(btnTimKhach);

		btnTimPhong = new JButton("Tìm phòng");
		btnTimPhong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnTimPhong.setBounds(0, 627, 165, 23);
		contentPane.add(btnTimPhong);

		JLabel lblNewLabel_6 = new JLabel("GVHD : Lê Khắc Tuấn");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setBounds(364, 340, 197, 28);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("SVTH : Nguyễn Ngọc Vũ Hưng (C)");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(364, 420, 286, 23);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel(": Ma Quốc Cường");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(407, 454, 138, 24);
		contentPane.add(lblNewLabel_8);

		JLabel lblNguyenMinhDuc = new JLabel(": Nguyễn Minh Đức");
		lblNguyenMinhDuc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNguyenMinhDuc.setBounds(407, 489, 126, 28);
		contentPane.add(lblNguyenMinhDuc);
		
		JLabel lblGvhdL = new JLabel(": Lê Hồng Phương");
		lblGvhdL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGvhdL.setHorizontalAlignment(SwingConstants.LEFT);
		lblGvhdL.setBounds(413, 365, 197, 28);
		contentPane.add(lblGvhdL);
		btnCNKhach.addActionListener(this);
		btnCNDichVu.addActionListener(this);
		btnCNPhong.addActionListener(this);
		btnChiTietDichVu.addActionListener(this);
		btnTimKhach.addActionListener(this);
		btnTimPhong.addActionListener(this);
		btnThanhToan.addActionListener(this);

		setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnCNKhach)) {
			btnCNKhachClick();
		} else if (e.getSource().equals(btnCNDichVu)) {
			btnCNDichVuClick();
		} else if (e.getSource().equals(btnChiTietDichVu)) {
			btnChihiTietDVClick();
		} else if (e.getSource().equals(btnTimKhach)) {
			btnTimKhachClick();
		} else if (e.getSource().equals(btnTimPhong)) {
			btnTimPhongClick();
		} else if (e.getSource().equals(btnThanhToan)) {
			btnThanhToanClick();
		} else {
			btnCNPhongClick();
		}

	}

	public void btnCNKhachClick() {
		new GDUpdateCustomerInfor().setVisible(true);
		this.dispose();

	}

	public void btnCNPhongClick() {
		new GDRoomUpdate().setVisible(true);
		this.dispose();
	}

	public void btnCNDichVuClick() {
		new GDUpdateService().setVisible(true);
		this.dispose();
	}

	public void btnChihiTietDVClick() {
		new GDDichVu().setVisible(true);
		this.dispose();
	}

	public void btnTimPhongClick() {
		new GDSearchRoom().setVisible(true);
		this.dispose();
	}

	public void btnTimKhachClick() {
		new GDSearchUser().setVisible(true);
		this.dispose();
	}

	public void btnThanhToanClick() {
		new GDHoaDon().setVisible(true);
		this.dispose();
	}
}
