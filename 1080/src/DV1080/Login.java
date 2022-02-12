package DV1080;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	Connection conn;
	Statement stml;
	ResultSet rs;
	Login() {
		JFrame jfr = new JFrame("Đăng nhập!!");
		jfr.setBounds(100, 100, 320, 420);
		jfr.getDefaultCloseOperation();
		
		URL urlicon = DanhSach.class.getResource("Heart.png");
		Image imgicon = Toolkit.getDefaultToolkit().createImage(urlicon);
		jfr.setIconImage(imgicon);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		jfr.add(panel);
		panel.setLayout(null);
		
		JLabel lblTD = new JLabel("Dịch vụ 1080");
		lblTD.setForeground(Color.GREEN);
		lblTD.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTD.setBounds(84, 31, 132, 19);
		panel.add(lblTD);
		
		JLabel jlbaccout = new JLabel("Tài khoản");
		jlbaccout.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jlbaccout.setBounds(35, 90, 68, 19);
		panel.add(jlbaccout);
		
		JLabel lblpass = new JLabel("Mật khẩu");
		lblpass.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblpass.setBounds(35, 133, 68, 13);
		panel.add(lblpass);
		
		JTextField textacc = new JTextField();
		textacc.setBounds(125, 91, 123, 19);
		panel.add(textacc);
		textacc.setColumns(10);
		
		JPasswordField textpass = new JPasswordField();
		textpass.setBounds(125, 131, 123, 19);
		panel.add(textpass);
		textpass.setColumns(10);
		
		JButton jbtDN = new JButton("Đăng nhập");
		jbtDN.setBackground(Color.LIGHT_GRAY);
		jbtDN.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jbtDN.setBounds(62, 205, 88, 21);
		panel.add(jbtDN);
		
		jbtDN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textacc.getText().equals("") && textpass.getText().equals("")) {
					 JOptionPane.showMessageDialog(null, "Chưa nhập tài khoản và mật khẩu!!");
				 } else if(textacc.getText().equals("")) {
					 JOptionPane.showMessageDialog(null, "Chưa nhập tài khoản!!");
				 } else if(textpass.getText().equals("")) {
					 JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu!!");
				 } else {
				try {
					String connectionURL = "jdbc:sqlserver://DESKTOP-QHHHUUQ:1433;databaseName=DichVu_1080;integratedSecurity=true";
					conn = DriverManager.getConnection(connectionURL, "sa", "sa");
					//JOptionPane.showMessageDialog(null, "Kết nối thành công!!");
					stml = conn.createStatement();
					String sql = "Select * from TaiKhoan";
					rs = stml.executeQuery(sql);
					while(rs.next()) {
						 String user = rs.getString(1);
						 String pass = rs.getString(2);
						 
						 if(textacc.getText().equals(user) && textpass.getText().equals(pass)) {
								JOptionPane.showMessageDialog(null, "Đăng nhập thành công!!");
								new GDChinh();
								jfr.dispose();
								break;
							} else {
								JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc sai mật khẩu!!");
								return;
							}
					}
					
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e1.toString());
				}
				 }
			}
		});
		
		JButton jbtDK = new JButton("Đăng Ký");
		jbtDK.setBackground(Color.LIGHT_GRAY);
		jbtDK.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jbtDK.setBounds(160, 205, 88, 21);
		panel.add(jbtDK);
		
		jbtDK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DKAccout();
				jfr.dispose();
			}
			
		});
		
		JCheckBox cb = new JCheckBox("Đồng ý các điều khoản trên!!");
		cb.setBackground(Color.WHITE);
		cb.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		cb.setBounds(65, 270, 166, 21);
		panel.add(cb);
		
		JLabel anh = new JLabel("");
		anh.setIcon(new ImageIcon(Login.class.getResource("LOGIN.jpg")));
		anh.setBounds(0, 0, 320, 420);
		panel.add(anh);
		
		
		
		jfr.add(panel);
		jfr.setVisible(true);
		jfr.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new Login();
	}
}
