package DV1080;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConnectionDB {
	Connection conn;
	Statement stml;
	public ConnectionDB() {
		// TODO Auto-generated constructor stub
		try {
			String connectionURL = "jdbc:sqlserver://DESKTOP-QHHHUUQ:1433;databaseName=DichVu_1080;integratedSecurity=true";
			conn = DriverManager.getConnection(connectionURL, "sa", "sa");
			stml = conn.createStatement();
			//JOptionPane.showMessageDialog(null, "Kết nối thành công!!");	 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public Statement getStml() {
		return stml;
	}
	public void setStml(Statement stml) {
		this.stml = stml;
	}
	
//	public static void main(String[] args) {
//		new ConnectionDB();
//	}
}
