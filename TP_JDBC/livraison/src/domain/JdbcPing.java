package domain;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcPing {

	public static void main(String[] args) {

		Properties props = new Properties();
		try (FileReader fis = new FileReader("conf.properties")) {
			props.load(fis);

			Class.forName(props.getProperty("jdbc.driver.class"));
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Driver inconnu - " + e.getMessage());
			System.exit(1);
		}

		String dbUrl = props.getProperty("jdbc.url");
		String dbLogin = props.getProperty("jdbc.login");
		String dbPwd = props.getProperty("jdbc.password");

		try (Connection cnx = DriverManager.getConnection(dbUrl, dbLogin, dbPwd)) {

			cnx.setAutoCommit(false);

		} catch (SQLException e) {
			System.out.println("Erreur acc�s DB - " + e.getMessage());
			System.exit(0);
		}
	}
}
