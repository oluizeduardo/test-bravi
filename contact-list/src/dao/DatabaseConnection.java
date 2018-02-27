package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

		private String address = "127.0.0.1";
		private String port = "5432";
		private String nameDataBase = "Contacts";
	    private String url = "jdbc:postgresql://"+address+":"+port+"/"+nameDataBase;  
	    private String username = "postgres";  
	    private String password = "postgres";  
	    private String driver = "org.postgresql.Driver";
		
	    private static DatabaseConnection instance = null;
	    
	    
	    public DatabaseConnection() {	}
	    
	    
	    
	    // Singleton
	    public static DatabaseConnection getInstance(){
	        if(instance == null){
	        	instance = new DatabaseConnection();
	        }
	        return instance;
	    }

	    
	    
	    public Connection getConnection() throws SQLException {	        
	    	try {
	    		Class.forName(driver);
	    	}catch (ClassNotFoundException e) {
	    		System.out.println("An error to load the database driver has been detected!");
			}	    	
	        return (Connection) DriverManager.getConnection(url, username ,password);
	    }
	    
	    
	
}
