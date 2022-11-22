package fstt.org.market.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton
public class ConnexionManager {
	
	
	private static Connection connexion ;
	private String url = "jdbc:mysql://localhost:3306/market";
	private String username = "root";
	private String password = "";
	
	private  ConnexionManager() throws SQLException, ClassNotFoundException {
		 
		Class.forName("com.mysql.cj.jdbc.Driver") ;
		
		connexion = DriverManager.getConnection(url, username, password);
	}
	
	public static Connection getConnexion() throws SQLException, ClassNotFoundException {
		
		if(connexion == null )
			new ConnexionManager();
	
		return connexion ;
			  
		
	}

}
