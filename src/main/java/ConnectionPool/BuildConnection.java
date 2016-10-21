package ConnectionPool;

import java.sql.*;

interface BuildConnection {
	Connection getConnection() throws SQLException;
	void freeConnection(Connection conn) throws SQLException;
	int getNumberConnections() throws SQLException;
}

