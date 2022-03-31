package databaseak;

import java.sql.*;

public class DBKonexioa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection konexioa = DriverManager.getConnection("jdbc:mysql://localhost/bdikasleak", "root", "");
			Statement st = konexioa.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM ikasleak");
			while (rs .next()) {
				Connection konexioa1 = DriverManager.getConnection("jdbc:mysql://localhost/bdikasleak", "root", "");
				System.out.println("NAN: " + rs.getObject("nan") +
						", Izena: " + rs.getObject("izena") +
						", Abizenak: " + rs.getObject("abizenak") +
						", Taldea: " + rs.getObject("taldea"));
				st = konexioa1.createStatement();
				st.executeUpdate("UPDATE ikasleak SET taldea='1DW3' WHERE nan='11111111A'");
				konexioa1.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Konexioa errorea");
		}
	}
}