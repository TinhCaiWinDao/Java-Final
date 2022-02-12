package DV1080;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DanhSach extends JFrame {
	private JFrame jfr;
	private Connection conn;
	private Statement stml;
	private PreparedStatement ps;
	private ResultSet rs;
	private String LoaiDV;
	private String gioiTinh;
	private DefaultTableModel dm;
	private ButtonGroup group;
	private JTable tbl;
	private JTextField jtfid;
	private JTextField jtftk;
	private JTextField jtfname;
	private JTextField jtfaddress;
	private JTextField jtfsdt;
	private JLabel jlbTB;
	public DanhSach() {
		// TODO Auto-generated constructor stub
		this.jfr = new JFrame("Danh Sach");
		this.jfr.setSize(1000,600);
		this.jfr.setLayout(new BorderLayout());
		this.jfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar menubar = new JMenuBar();
		menubar.setBackground(Color.WHITE);
		this.jfr.setJMenuBar(menubar);
		JMenu File = new JMenu("File");
		JMenu Edit = new JMenu("Edit");
		JMenu Search = new JMenu("Search");
		JMenu window = new JMenu("Window");
		menubar.add(File);
		menubar.add(Edit);
		menubar.add(Search);
		menubar.add(window);
		JMenuItem Open = new JMenuItem("Open");
		Open.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DanhSach.class.getResource("Open.png"))));
		JMenuItem Save = new JMenuItem("Save");
		Save.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DanhSach.class.getResource("Save.png"))));
		JMenuItem Saveas = new JMenuItem("Save As");
		Saveas.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DanhSach.class.getResource("SaveAs.png"))));
		JMenuItem Exit = new JMenuItem("Exit");
		Exit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DanhSach.class.getResource("Exit.png"))));
		File.add(Open);
		File.add(Save);
		File.add(Saveas);
		File.add(Exit);
		
		
		URL urlicon = DanhSach.class.getResource("Heart.png");
		Image imgicon = Toolkit.getDefaultToolkit().createImage(urlicon);
		this.jfr.setIconImage(imgicon);
		
		JPanel main = new JPanel();
		main.setLayout(new GridLayout(1,2));
		
		JPanel left = new JPanel();
		left.setBackground(Color.WHITE);
//		left.setLayout(new GridLayout(7,2));
		left.setLayout(null);
		
		Border border1 = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		TitledBorder tlBorder = BorderFactory.createTitledBorder(border1,"");
		left.setBorder(tlBorder);
		
		main.add(left);
		
		JLabel lbltd = new JLabel("Nhập Thông Tin");
		lbltd.setForeground(Color.BLUE);
		lbltd.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lbltd.setBounds(115, 20, 254, 35);
		JLabel jlbtk = new JLabel("Tìm Kiếm :");
		jlbtk.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jlbtk.setBounds(30, 75, 95, 20);
		JLabel jlbid = new JLabel("ID :");
		jlbid.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jlbid.setBounds(30, 120, 95, 20);
		JLabel jlbname = new JLabel("Họ và Tên : ");
		jlbname.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jlbname.setBounds(30, 165, 95, 20);
		JLabel jlbgioitinh = new JLabel("Giới Tính : ");
		jlbgioitinh.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jlbgioitinh.setBounds(30, 210, 95, 20);
		JLabel jlbaddress = new JLabel("Địa chỉ : ");
		jlbaddress.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jlbaddress.setBounds(30, 255, 95, 20);
		JLabel jlbsdt = new JLabel("Số Điện Thoại : ");
		jlbsdt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jlbsdt.setBounds(30, 300, 95, 20);
		JLabel jlbdv = new JLabel("Dịch Vụ : ");
		jlbdv.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jlbdv.setBounds(30, 345, 95, 20);
		jlbTB = new JLabel();
		jlbTB.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jlbTB.setBounds(150, 375, 298, 21);
		left.add(lbltd);
		left.add(jlbtk);
		left.add(jlbid);
		left.add(jlbname);
		left.add(jlbgioitinh);
		left.add(jlbaddress);
		left.add(jlbsdt);
		left.add(jlbdv);
		left.add(jlbTB);
		
		jtftk = new JTextField();
		jtftk.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jtftk.setBounds(165, 75, 238, 21);
		jtfid = new JTextField();
		jtfid.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jtfid.setBounds(165, 120, 238, 21);
		jtfname = new JTextField();
		jtfname.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jtfname.setBounds(165, 165, 238, 21);
		jtfaddress = new JTextField();
		jtfaddress.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jtfaddress.setBounds(165, 255, 238, 21);
		jtfsdt = new JTextField();
		jtfsdt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jtfsdt.setBounds(165, 300, 238, 21);
		left.add(jtftk);
		left.add(jtfid);
		left.add(jtfname);
		left.add(jtfaddress);
		left.add(jtfsdt);
		
		JRadioButton jrbNam = new JRadioButton("Nam");
		jrbNam.setBackground(Color.WHITE);
		jrbNam.setFont(new Font("Time New Roman", Font.PLAIN, 17));
		jrbNam.setBounds(165,210,70,20);
		left.add(jrbNam);
		
		jrbNam.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				gioiTinh = "Nam";
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JRadioButton jrbNu = new JRadioButton("Nữ");
		jrbNu.setBackground(Color.WHITE);
		jrbNu.setFont(new Font("Time New Roman", Font.PLAIN, 17));
		jrbNu.setBounds(265,210,70,20);
		left.add(jrbNu);
		
		jrbNu.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				gioiTinh = "Nữ";
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		group = new ButtonGroup();
		group.add(jrbNu);
		group.add(jrbNam);
		
		String[] dv = {"Tra cứu điểm thi", "Tư vấn tâm lý", "Tra cứu số điện thoại"};
		JComboBox cbo=new JComboBox(dv);
		cbo.setFont(new FontUIResource("Times New Roman", Font.PLAIN, 16));
		cbo.setBackground(Color.WHITE);
		cbo.setBounds(165, 345, 238, 21);
		left.add(cbo);
		
		cbo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoaiDV = DanhSach.getParameter("cbo");
			}
			
		});
		
		JButton jbtadd = new JButton("Add");
		jbtadd.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DanhSach.class.getResource("Add.png"))));
		jbtadd.setBackground(Color.LIGHT_GRAY);
		jbtadd.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jbtadd.setBounds(49, 413, 110, 28);
		left.add(jbtadd);
		
		jbtadd.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//				gioiTinh = null;
//				if (jrbNam.isSelected()) {
//					gioiTinh = "Nam";
//				} if (jrbNu.isSelected()) {
//					gioiTinh = "Nữ";
//				}
				try {
					new ConnectionDB();
					if(jrbNam.isSelected()) {
						gioiTinh = "Nam";
					} else if (jrbNu.isSelected()) {
						gioiTinh = "Nữ";
					}
					LoaiDV = cbo.getSelectedItem().toString();
					String them = "Insert into DanhSach values (\'"+jtfid.getText()+"\',N\'"+jtfname.getText()+"\',"
							+ "N\'"+gioiTinh+"\',N\'"+jtfaddress.getText()+"\',N\'"+jtfsdt.getText()+"\',N\'"+LoaiDV+"')";
					//show_DLADD();
					//dm.addRow(new String[] {jtfid.getText(), jtfacc.getText(),jtfname.getText(),gioiTinh,jtfaddress.getText(),jtfsdt.getText(),LoaiDV});
//					String them = "Insert into DanhSach(ID, accout, Name, GT, Address, SDT, DichVu) "
//							+ "Values (?,?,?,?,?,?,?)";
					//PreparedStatement pr = conn.prepareStatement(them);
					stml.executeUpdate(them);
					jlbTB.setText("Đã thêm thành công!!!");
					DefaultTableModel model = (DefaultTableModel)tbl.getModel();
					model.setRowCount(0);
					show_DN();
//						pr.setString(1, jtfid.getText());
//						pr.setString(2, jlbacc.getText());
					
//						pr.setString(3, jtfname.getText());
//					if(jrbNam.isSelected()) {
//						gioiTinh = "Nam";
//					} else if (jrbNu.isSelected()) {
//						gioiTinh = "Nữ";
//					}
//						pr.setString(4, gioiTinh);
//						pr.setString(5, jtfaddress.getText());
//						pr.setString(6, jtfsdt.getText());
//						pr.setString(7, cbo.toString());
//					
					
						//JOptionPane.showMessageDialog(null, "Đã thêm thành công!!!");
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
					jlbTB.setText("Thêm thất bại!!!");
				}
				

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
					
		
		JButton jbtnext = new JButton("Next");
		jbtnext.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DanhSach.class.getResource("Next.png"))));
		jbtnext.setBackground(Color.LIGHT_GRAY);
		jbtnext.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jbtnext.setBounds(190, 413, 110, 28);
		left.add(jbtnext);
		jbtnext.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jtfid.setText(null);
				jtfname.setText(null);
				group.clearSelection();
//				jrbNam.setSelected(false);
//				jrbNu.setSelected(false);
				jtfaddress.setText(null);
				jtfsdt.setText(null);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JButton jbtupdate = new JButton("Update");
		jbtupdate.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DanhSach.class.getResource("Update.png"))));
		jbtupdate.setBackground(Color.LIGHT_GRAY);
		jbtupdate.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jbtupdate.setBounds(327, 413, 110, 28);
		left.add(jbtupdate);
		
		jbtupdate.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
//					new ConnectionDB();
					if(jrbNam.isSelected()) {
						gioiTinh = "Nam";
					} else if (jrbNu.isSelected()) {
						gioiTinh = "Nữ";
					}
					LoaiDV = cbo.getSelectedItem().toString();
					String update = "UPDATE DanhSach set Name = N'"+jtfname.getText()+"', GT = N'"+gioiTinh+"', Address = N'"+jtfaddress.getText()+""
							+ "', SDT = N'"+jtfsdt.getText()+"', DichVu = N'"+LoaiDV+"'  where ID = "+jtfid.getText();
					stml.executeUpdate(update);
					jlbTB.setText("Đã cập nhập thành công!!!");
					DefaultTableModel model = (DefaultTableModel)tbl.getModel();
					model.setRowCount(0);
					show_DN();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
					jlbTB.setText("Cập nhập thất bại!!!");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JButton jbtdelete = new JButton("Delete");
		jbtdelete.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DanhSach.class.getResource("Delete.png"))));
		jbtdelete.setBackground(Color.LIGHT_GRAY);
		jbtdelete.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jbtdelete.setBounds(49, 471, 110, 28);
		left.add(jbtdelete);
		jbtdelete.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				try {
					int row = tbl.getSelectedRow();
					String delete = "delete from DanhSach where ID = ?";
					ps = conn.prepareStatement(delete);
					ps.setString(1, jtfid.getText());
					
					jtfid.setText(null);
					jtfname.setText(null);
					group.clearSelection();
//					jrbNam.setSelected(false);
//					jrbNu.setSelected(false);
					jtfaddress.setText(null);
					jtfsdt.setText(null);
					
					
					ps.executeUpdate();
					dm.removeRow(row);
					jlbTB.setText("Đã xóa thành công!!!");
					//JOptionPane.showMessageDialog(null,"Đã xóa thành công!!");
				} catch (SQLException e1) {
					// TODO: handle exception
					System.out.println(e1);
					jlbTB.setText("Xóa thất bại!!!");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JButton jbtfind = new JButton("Find");
		jbtfind.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DanhSach.class.getResource("Find.png"))));
		jbtfind.setBackground(Color.LIGHT_GRAY);
		jbtfind.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jbtfind.setBounds(190, 471, 110, 28);
		left.add(jbtfind);
		jbtfind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtftk.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập tìm kiếm!");
				} else {
				DefaultTableModel model = (DefaultTableModel)tbl.getModel();
				model.setRowCount(0);
				show_DLADD();
				}
			}
		});
		
		JButton jbtreturn = new JButton("Return");
		jbtreturn.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DanhSach.class.getResource("Return.png"))));
		jbtreturn.setBackground(Color.LIGHT_GRAY);
		jbtreturn.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jbtreturn.setBounds(327, 471, 110, 28);
		left.add(jbtreturn);
		jbtreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfr.dispose();
				new GDChinh();
			}
		});

		JPanel right = new JPanel();
		right.setBackground(Color.WHITE);
		right.setLayout(new BorderLayout());
		main.add(right);
		Border border2 = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		TitledBorder tlborder = BorderFactory.createTitledBorder(border2,"Danh Sách");
		right.setBorder(tlborder);
		
		dm = new DefaultTableModel();
		dm.addColumn("ID");
		dm.addColumn("Họ và Tên");
		dm.addColumn("Giới Tính");
		dm.addColumn("Địa chỉ");
		dm.addColumn("Số Điện Thoại");
		dm.addColumn("Dịch Vụ");
		
		tbl = new JTable(dm);
		tbl.setBackground(Color.WHITE);
		show_DN();
//		try {
//			show_DN();
//			while(rs.next()) {
//				dm.addRow(new String[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jtfid.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 0));
				jtfname.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 1));
				gioiTinh = (String) tbl.getValueAt(tbl.getSelectedRow(), 2);
				if (gioiTinh.equals("Nam")) {
					jrbNam.setSelected(true);
				} else {
					jrbNu.setSelected(true);
				}
				jtfaddress.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 3));
				jtfsdt.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 4));
				LoaiDV = (String) tbl.getValueAt(tbl.getSelectedRow(), 5);
				switch (LoaiDV) {
					case "Tra cứu điểm thi":
						cbo.setSelectedIndex(0);
						break;
					case "Tư vấn tâm lý":
						cbo.setSelectedIndex(1);
						break;
					case "Tra cứu số điện thoại":
						cbo.setSelectedIndex(2);
						break;
				}
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JScrollPane sc = new JScrollPane(tbl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBackground(Color.WHITE);
		right.add(sc);
		
		
		this.jfr.add(main);
		this.jfr.setVisible(true);
		this.jfr.setLocationRelativeTo(null);
	}

	protected static String getParameter(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void show_DN() {	
		try {
			String connectionURL = "jdbc:sqlserver://DESKTOP-QHHHUUQ:1433;databaseName=DichVu_1080;integratedSecurity=true";
			conn = DriverManager.getConnection(connectionURL, "sa", "sa");
			//JOptionPane.showMessageDialog(null, "Kết nối thành công!!");
			stml = conn.createStatement();
			String sql = "Select * from DanhSach";
			rs = stml.executeQuery(sql);
			while (rs.next()) {
				dm.addRow(new String[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
//			JOptionPane.showMessageDialog(null, e.toString());
		}
	}
	public void show_DLADD() {
		try {
//			String connectionURL = "jdbc:sqlserver://DESKTOP-QHHHUUQ:1433;databaseName=DichVu_1080;integratedSecurity=true";
//			conn = DriverManager.getConnection(connectionURL, "sa", "sa");
			//JOptionPane.showMessageDialog(null, "Kết nối thành công!!");
			stml = conn.createStatement();
			int row = tbl.getSelectedRow();
			//String sql = "Select ID, Name, GT, Address, SDT, DichVu from DanhSach where ID = " + jtftk.getText();
			String sql = "Select ID, Name, GT, Address, SDT, DichVu from DanhSach where ID = N'"+jtftk.getText()+"' or Name = N'"+jtftk.getText()+"' or Address = N'"+jtftk.getText()+"' or "
					+ "SDT = N'"+jtftk.getText()+"' or DichVu = N'"+jtftk.getText()+"' or GT = N'"+jtftk.getText()+"'";
			rs = stml.executeQuery(sql);
			while (rs.next()) {
				dm.addRow(new String[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void TimKiem() {
		try {
			stml = conn.createStatement();
			int ten = tbl.getSelectedRow();
			String FindID = "Select ID, accout, Name, GT, Address, SDT, DichVu from DanhSach where ID =  '"+jtftk.getText()+"'";
			rs = stml.executeQuery(FindID);
			
			while (rs.next()) {
				dm.addRow(new String[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		new DanhSach();
	}
}
