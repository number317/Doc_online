package ConnectionPool;

import java.sql.*;

public class ConnectionFactory {

	private BuildConnection build = null;
	private static ConnectionFactory instance;

	public BuildConnection getBuild() {
		return build;
	}

	public void setBuild(BuildConnection build) {
		this.build = build;
	}

	public ConnectionFactory() {
		this.build = new ConnectionBroker();
	}
	
	synchronized public static ConnectionFactory getInstatnce() {
		if (instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return build.getConnection();
	}

	public void freeConnection(Connection conn) {
		try {
			build.freeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}

	public int getNumbersConnection() {
		try {
			return build.getNumberConnections();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return -1;
	}
}
