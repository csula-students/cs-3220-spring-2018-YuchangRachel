package edu.csula.storage.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	// FIXME: don't hard commit your credential
	private static final String database = "cs3220_test";
	private static final String host = "localhost";
	private static final String url = String.format("jdbc:mysql://%s/%h", host, database);
	private static final String username = "root";
	private static final String password = "";

	public Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch( ClassNotFoundException e ) {
			throw new IllegalStateException(e);
		}
	}

	public Connection connection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}

