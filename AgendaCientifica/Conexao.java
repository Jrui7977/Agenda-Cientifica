import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	public String hostname;
	public String username;
	public int port;
	public String database;
	public String password;
	
	public Connection connection;
	
	public Connection Conexao() {
		
		try {
			
			hostname = "localhost";
			port = 3306;
			database = "agenda_cientifica";
			username = "root";
			password = "";
			
			String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			connection = DriverManager.getConnection(url, username , password);			
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return this.connection;
	}
}
