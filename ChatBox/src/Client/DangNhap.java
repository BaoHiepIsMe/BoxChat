package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField sodienthoai;
	private JPasswordField matkhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 367);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Box Chat xin chào!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel.setBounds(10, 10, 535, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 103, 115, 48);
		contentPane.add(lblNewLabel_1);
		
		sodienthoai = new JTextField();
		sodienthoai.setBounds(129, 111, 416, 37);
		contentPane.add(sodienthoai);
		sodienthoai.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 172, 115, 48);
		contentPane.add(lblNewLabel_1_1);
		
		matkhau = new JPasswordField();
		matkhau.setBounds(129, 180, 416, 37);
		contentPane.add(matkhau);
		
		JButton dangnhap = new JButton("Đăng Nhập");
		dangnhap.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		dangnhap.setBounds(139, 227, 251, 42);
		contentPane.add(dangnhap);
		
		JLabel lblNewLabel_2 = new JLabel("Bạn chưa có tài khoản?");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(10, 279, 156, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Đăng kí tài khoản tại đây");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DangKi dk = new DangKi();
				dk.setVisible(true);
				dk.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNewLabel_2_1.setBounds(167, 279, 195, 41);
		contentPane.add(lblNewLabel_2_1);
	}
}
