package ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import com.devdaily.opensource.database.DDConnectionBroker;

class ConnectionBroker implements BuildConnection {

	private String driver = null;
	private String url = null;
	private String username = null;
	private String password = null;
	private int minConnections = 0;
	private int maxConnections = 0;
	private long timeout = 0;
	private long leaseTime = 0;
	private String logFile = null;
	private DDConnectionBroker broker = null;

	private void setUp() {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/fileOnline_db";
		username = "root";
		password = "arch53212765";
		minConnections = 2;
		maxConnections = 5;
		timeout = 100;
		leaseTime = 60000;
		broker = null;
	}

	public Connection getConnection() throws SQLException {
		try {
			broker = new DDConnectionBroker(driver, url, username, password,
					minConnections, maxConnections, timeout, leaseTime, logFile);

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			System.out.println("Could not construct a broker, quitting.");

		}
		return broker.getConnection();
	}

	public void freeConnection(Connection conn) throws SQLException {
		try {
			broker.freeConnection(conn);
		} catch (Exception e) {
			System.out
					.println("Threw an exception trying to free my Connection: "
							+ e.getMessage());
		}
	}

	public int getNumberConnections() throws SQLException {
		if (broker != null)
			return broker.getNumberConnections();
		else
			return -1;
	}

	ConnectionBroker() {
		super();
		setUp();
	}
}

