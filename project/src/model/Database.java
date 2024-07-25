package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static final String DB_Svname="HOANGPHU";
	private static final String DB_Login="sa";
	private static final String DB_Pass="123";
	private static final String DB_Name="BADMINTON";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String DB_URL = "jdbc:sqlserver://" + DB_Svname + ":1433;" +
                    "databaseName=" + DB_Name + ";" +
                    "encrypt=true;" +
                    "trustServerCertificate=true";
			return DriverManager.getConnection(DB_URL,DB_Login,DB_Pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
