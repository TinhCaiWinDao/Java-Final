package DV1080;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class GDChinh extends JFrame {
	public GDChinh(){
		// TODO Auto-generated constructor stub
		JFrame jfr = new JFrame("Menu 1080");
		jfr.setSize(695, 500);
		jfr.setDefaultCloseOperation(jfr.EXIT_ON_CLOSE);
		
		URL urlicon = DanhSach.class.getResource("Heart.png");
		Image imgicon = Toolkit.getDefaultToolkit().createImage(urlicon);
		jfr.setIconImage(imgicon);
		
		JPanel main = new JPanel();
		main.setLayout(null);
		
		JButton jbtDT = new JButton("Điểm thi");
		jbtDT.setBackground(Color.WHITE);
		jbtDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jbtDT.setBounds(28, 269, 153, 63);
		main.add(jbtDT);
		
		JButton jbtDS = new JButton("Danh sách khách hàng");
		jbtDS.setBackground(Color.WHITE);
		jbtDS.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jbtDS.setBounds(270, 269, 153, 63);
		main.add(jbtDS);
		
		jbtDS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DanhSach();
				jfr.dispose();
			}
			
		});
		
		JButton jbtTK = new JButton("Thống kê");
		jbtTK.setBackground(Color.WHITE);
		jbtTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jbtTK.setBounds(488, 269, 153, 63);
		main.add(jbtTK);
		
		JButton jbtout = new JButton("Đăng Xuất");
		jbtout.setBackground(Color.WHITE);
		jbtout.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jbtout.setBounds(514, 379, 104, 39);
		main.add(jbtout);
		
		jbtout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfr.dispose();
				new Login();
			}
			
		});
		
		JLabel jlbTD = new JLabel("Hệ Thống Quản Lý");
		jlbTD.setBackground(Color.WHITE);
		jlbTD.setForeground(Color.WHITE);
		jlbTD.setFont(new Font("Times New Roman", Font.BOLD, 28));
		jlbTD.setBounds(226, 74, 244, 63);
		main.add(jlbTD);
		
		JLabel lbliconGD = new JLabel("");
		lbliconGD.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DanhSach.class.getResource("GiaoDienChinh.jpg"))));
		lbliconGD.setBounds(0, 0, 671, 453);
		main.add(lbliconGD);
		
		jfr.add(main, BorderLayout.CENTER);
		jfr.setVisible(true);
		jfr.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new GDChinh();
	}
}
