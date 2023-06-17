package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class DangKi extends JFrame {

	private JPanel contentPane;
	private JTextField hoten;
	private JTextField sodienthoai;
	private JTextField email;
	private JPasswordField matkhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKi frame = new DangKi();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangKi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 477);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 104, 597, 336);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Họ Tên: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 138, 41);
		panel.add(lblNewLabel);
		
		hoten = new JTextField();
		hoten.setBounds(151, 10, 436, 41);
		panel.add(hoten);
		hoten.setColumns(10);
		
		JLabel lblSinThoi = new JLabel("Số Điện Thoại: ");
		lblSinThoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSinThoi.setBounds(10, 71, 138, 41);
		panel.add(lblSinThoi);
		
		sodienthoai = new JTextField();
		sodienthoai.setColumns(10);
		sodienthoai.setBounds(151, 71, 436, 41);
		panel.add(sodienthoai);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu:");
		lblMtKhu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMtKhu.setBounds(10, 135, 138, 41);
		panel.add(lblMtKhu);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(151, 202, 436, 41);
		panel.add(email);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(10, 202, 138, 41);
		panel.add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Bạn đã có tài khoản?");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DangNhap lo = new DangNhap();
				lo.setLocationRelativeTo(null);
				lo.setVisible(true);
				dispose(); 
				
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(178, 248, 214, 23);
		panel.add(lblNewLabel_1);
		
		JButton dangki = new JButton("Đăng Kí");
		dangki.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		dangki.setBounds(219, 281, 148, 41);
		panel.add(dangki);
		
		matkhau = new JPasswordField();
		matkhau.setBounds(151, 135, 436, 41);
		panel.add(matkhau);
		
		JLabel lblNewLabel_2 = new JLabel("Chào mừng bạn đến với Box Chat");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setBounds(10, 10, 577, 86);
		contentPane.add(lblNewLabel_2);
	}
}
