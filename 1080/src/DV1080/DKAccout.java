package DV1080;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DKAccout extends JFrame {
	JFrame main;
	Statement stml = null;
	Connection conn;
	ResultSet rs;
	private JCheckBox cb;
	public DKAccout() {
		// TODO Auto-generated constructor stub
		try {
			String connectionURL = "jdbc:sqlserver://DESKTOP-QHHHUUQ:1433;databaseName=DichVu_1080;integratedSecurity=true";
			conn = DriverManager.getConnection(connectionURL, "sa", "sa");		
		//	JOptionPane.showMessageDialog(null, "Kết nối thành công!!");
			stml = conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
		main = new JFrame("Đăng ký tài khoản!!");
		main.setBounds(100, 100, 320, 420);
		main.getDefaultCloseOperation();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		main.add(panel);
		panel.setLayout(null);
		
		JLabel lblTD = new JLabel("Đăng ký tài khoản");
		lblTD.setForeground(Color.GREEN);
		lblTD.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTD.setBounds(84, 31, 132, 19);
		panel.add(lblTD);
		
		JLabel lblacc = new JLabel("Tài Khoản");
		lblacc.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblacc.setBounds(35, 90, 68, 19);
		panel.add(lblacc);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblemail.setBounds(35, 133, 68, 13);
		panel.add(lblemail);
		
		JLabel lblMK = new JLabel("Mật khẩu");
		lblMK.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMK.setBounds(35, 172, 68, 13);
		panel.add(lblMK);
		
		
		
		JTextField jtfacc = new JTextField();
		jtfacc.setBounds(125, 91, 123, 19);
		panel.add(jtfacc);
		
		JTextField jtfemail = new JTextField();
		jtfemail.setBounds(125, 130, 123, 19);
		panel.add(jtfemail);
		
		JTextField jpfPass = new JPasswordField();
		jpfPass.setBounds(125, 170, 123, 19);
		panel.add(jpfPass);
		
		JButton jbtDK = new JButton("Đăng ký");
		jbtDK.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jbtDK.setBounds(62, 236, 88, 21);
		panel.add(jbtDK);
		
		jbtDK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ConnectionDB();
				try {
					//String sql = "insert into TaiKhoan values (\'"+jtfacc.getText()+"\',\'"+jpfPass.getText()+"\')";
					if (cb.isSelected()) { 
					stml.executeUpdate("INSERT into TaiKhoan values (\'"+jtfacc.getText()+"\',\'"+jpfPass.getText()+"\',\'"+jtfemail.getText()+"\')");
					
					jtfacc.setText(null);
					jtfemail.setText(null);
					jpfPass.setText(null);
					
					JOptionPane.showMessageDialog(null, "Đăng ký thành công!!");
					} else {
						JOptionPane.showMessageDialog(null, "Bạn chưa xác nhận là người:)))))");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
			
		});
		
		JButton jbtDN = new JButton("Đăng nhập");
		jbtDN.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jbtDN.setBounds(160, 236, 88, 21);
		panel.add(jbtDN);
		
		jbtDN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Login();
				main.dispose();
			}
			
		});
		
		cb = new JCheckBox("Bạn không phải là người máy!!");
		cb.setBackground(Color.WHITE);
		cb.setFont(new Font("Times New Roman", Font.PLAIN, 11));
	//	cb.setHorizontalAlignment(SwingConstants.LEFT);
		cb.setBounds(65, 270, 166, 21);
		panel.add(cb);
		
		main.add(panel);
		main.setVisible(true);
		main.setLocationRelativeTo(null);
	}
}
