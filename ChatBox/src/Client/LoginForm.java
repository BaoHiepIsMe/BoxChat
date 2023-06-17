package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtHost;
	private JTextField txtPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 22, 94, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblHost = new JLabel("Host:");
		lblHost.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblHost.setBounds(10, 87, 94, 51);
		contentPane.add(lblHost);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPort.setBounds(10, 155, 94, 51);
		contentPane.add(lblPort);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  connectToServer();
			}
		});
		txtUsername.setBounds(102, 30, 288, 35);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtHost = new JTextField();
		txtHost.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtHost.setText("127.0.0.1");
		txtHost.setColumns(10);
		txtHost.setBounds(102, 95, 288, 35);
		contentPane.add(txtHost);
		
		txtPort = new JTextField();
		txtPort.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtPort.setText("3333");
		txtPort.setColumns(10);
		txtPort.setBounds(102, 155, 288, 35);
		contentPane.add(txtPort);
		
		JButton jButton1 = new JButton("Đăng nhập");
		jButton1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 connectToServer();
			}
		});
		jButton1.setBounds(88, 216, 259, 35);
		contentPane.add(jButton1);
	}
	private void connectToServer() {
        String host = txtHost.getText();
        String portStr = txtPort.getText();
        String username = txtUsername.getText();
        System.out.println("Host: " + host);
        System.out.println("Port: " + portStr);

        if (host.length() > 0 && portStr.length() > 0 && username.length() > 0) {
            if (username.length() <= 15) {
                String u = username.replace(" ", "_");
                MainForm main = new MainForm();
                main.initFrame(u, host, Integer.parseInt(portStr));
                if (main.isConnected()) {
                    main.setLocationRelativeTo(null);
                    main.setVisible(true);
                    setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Tài khoản phải tối đa 15 ký tự bao gồm [khoảng trắng].!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chưa hoàn thành Form.!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
