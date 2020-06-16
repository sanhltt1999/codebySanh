package OnTap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectDB {
	private static String connectURL = "jdbc:sqlserver://DESKTOP-0UJSE5C:1433;databaseName = ontapJava; integratedSecurity = true";
	
	public static boolean executeDB(String query) {
		try {
			Connection connection = DriverManager.getConnection(connectURL);
			
			Statement sm = connection.createStatement();
			sm.execute(query);
	//		sm.close();
			return true;
			
		} catch(Exception exception) {
			System.out.println(exception.toString());
			return false;
		}
	}
	
	public static ResultSet getDB(String query) {
		try {
			Connection connection = DriverManager.getConnection(connectURL);
			
			Statement sm = connection.createStatement();
			
			ResultSet rs = sm.executeQuery(query);
			System.out.println("Ket noi thanh cong ");
//			sm.close();
			
			return rs;
			
		} catch(Exception exception) {
			return null;
		}
	}	
}
