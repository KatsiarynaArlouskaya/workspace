package com.epam.nb.dao.impl.db;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

import com.epam.nb.dao.DAOException;

public final class ConnectionPool {

	private BlockingQueue<Connection> connectionQueue;
	private BlockingQueue<Connection> givenAwayConQueue;

	private String driverName = "org.sqlite.JDBC";
	private String url = "jdbc:sqlite:TEST1.s3db";
	private int poolSize = 5;

	public void initPoolData() throws DAOException {
		try {
			Class.forName(driverName);
			givenAwayConQueue = new ArrayBlockingQueue<Connection>(poolSize);
			connectionQueue = new ArrayBlockingQueue<Connection>(poolSize);
			for (int i = 0; i < poolSize; i++) {
				Connection connection = DriverManager.getConnection(url);
				PooledConnection pooledConnection = new PooledConnection(
						connection);
				connectionQueue.add(pooledConnection);
			}

		} catch (SQLException e) {
			throw new DAOException("SQLException in Connection Pool", e);
		} catch (ClassNotFoundException e) {
			throw new DAOException("Can't find database driver class", e);
		}
	}

	public void dispose() throws DAOException {
		clearConnectionQueue();
	}

	private void clearConnectionQueue() throws DAOException {
		closeConnectionsQueue(givenAwayConQueue);
		closeConnectionsQueue(connectionQueue);
	}

	public Connection takeConnection() throws DAOException {
		Connection connection = null;
		try {
			connection = connectionQueue.take();
			givenAwayConQueue.offer(connection);
		} catch (InterruptedException e) {
			throw new DAOException("Erroe connection to the data source.", e);
		}
		return connection;
	}

	public void closeConnection(Connection con, Statement st, ResultSet rs)
			throws DAOException {
		try {
			con.close();
		} catch (SQLException e) {
			throw new DAOException("Erroe close connection.", e);
		}
		try {
			rs.close();
		} catch (SQLException e) {
			throw new DAOException("Erroe close connection.", e);
		}
		try {
			st.close();
		} catch (SQLException e) {
			throw new DAOException("Erroe close connection.", e);
		}
	}

	public void closeConnection(Connection con, Statement st)
			throws DAOException {
		try {
			con.close();
		} catch (SQLException e) {
			throw new DAOException("Erroe close connection.", e);
		}
		try {
			st.close();
		} catch (SQLException e) {
			throw new DAOException("Erroe close connection.", e);
		}
	}

	private void closeConnectionsQueue(BlockingQueue<Connection> queue) throws DAOException {
		Connection connection;
		try {
			while ((connection = queue.poll()) != null) {

				if (!connection.getAutoCommit()) {
					connection.commit();
				}
				((PooledConnection) connection).reallyClose();
			}
		} catch (SQLException e) {
			throw new DAOException("Erroe commit connection.", e);
		}

	}

	private class PooledConnection implements Connection {
		private Connection connection;

		public PooledConnection(Connection c) throws SQLException {
			this.connection = c;
			this.connection.setAutoCommit(true);
		}

		public void reallyClose() throws SQLException {
			connection.close();
		}

		@Override
		public void clearWarnings() throws SQLException {
			connection.clearWarnings();
		}

		@Override
		public void close() throws SQLException {
			if (connection.isClosed()) {
				throw new SQLException("Attempting to close closed connection.");
			}
			if (connection.isReadOnly()) {
				connection.setReadOnly(false);
			}
			if (!givenAwayConQueue.remove(this)) {
				throw new SQLException("Error deleting connection in the pool");
			}
			if (!connectionQueue.offer(this)) {
				throw new SQLException(
						"error allocating connection in the pool");
			}
		}

		@Override
		public void commit() throws SQLException {
			connection.commit();
		}

		@Override
		public Array createArrayOf(String typeName, Object[] elements)
				throws SQLException {
			return connection.createArrayOf(typeName, elements);
		}

		@Override
		public Blob createBlob() throws SQLException {
			return connection.createBlob();
		}

		@Override
		public Clob createClob() throws SQLException {
			return connection.createClob();
		}

		@Override
		public NClob createNClob() throws SQLException {
			return connection.createNClob();
		}

		@Override
		public SQLXML createSQLXML() throws SQLException {
			return connection.createSQLXML();
		}

		@Override
		public Statement createStatement() throws SQLException {
			return connection.createStatement();
		}

		@Override
		public Statement createStatement(int resultSetType,
				int resultSetConcurrency) throws SQLException {
			return connection.createStatement(resultSetType,
					resultSetConcurrency);
		}

		@Override
		public Statement createStatement(int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			return connection.createStatement(resultSetType,
					resultSetConcurrency, resultSetHoldability);
		}

		@Override
		public Struct createStruct(String typeName, Object[] attributes)
				throws SQLException {
			return connection.createStruct(typeName, attributes);
		}

		@Override
		public boolean getAutoCommit() throws SQLException {
			return connection.getAutoCommit();
		}

		@Override
		public String getCatalog() throws SQLException {
			return connection.getCatalog();
		}

		@Override
		public boolean isWrapperFor(Class<?> arg0) throws SQLException {
			return connection.isWrapperFor(arg0);
		}

		@Override
		public <T> T unwrap(Class<T> arg0) throws SQLException {
			return connection.unwrap(arg0);
		}

		@Override
		public void abort(Executor executor) throws SQLException {
			connection.abort(executor);

		}

		@Override
		public Properties getClientInfo() throws SQLException {
			return connection.getClientInfo();
		}

		@Override
		public String getClientInfo(String name) throws SQLException {
			return connection.getClientInfo(name);
		}

		@Override
		public int getHoldability() throws SQLException {
			return connection.getHoldability();
		}

		@Override
		public DatabaseMetaData getMetaData() throws SQLException {
			return connection.getMetaData();
		}

		@Override
		public int getNetworkTimeout() throws SQLException {
			return connection.getNetworkTimeout();
		}

		@Override
		public String getSchema() throws SQLException {
			return connection.getSchema();
		}

		@Override
		public int getTransactionIsolation() throws SQLException {
			return connection.getTransactionIsolation();
		}

		@Override
		public Map<String, Class<?>> getTypeMap() throws SQLException {
			return connection.getTypeMap();
		}

		@Override
		public SQLWarning getWarnings() throws SQLException {
			return connection.getWarnings();
		}

		@Override
		public boolean isClosed() throws SQLException {
			return connection.isClosed();
		}

		@Override
		public boolean isReadOnly() throws SQLException {
			return connection.isReadOnly();
		}

		@Override
		public boolean isValid(int timeout) throws SQLException {
			return connection.isValid(timeout);
		}

		@Override
		public String nativeSQL(String sql) throws SQLException {
			return connection.nativeSQL(sql);
		}

		@Override
		public CallableStatement prepareCall(String sql) throws SQLException {
			return connection.prepareCall(sql);
		}

		@Override
		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency) throws SQLException {
			return connection.prepareCall(sql, resultSetType,
					resultSetConcurrency);
		}

		@Override
		public CallableStatement prepareCall(String sql, int resultSetType,
				int resultSetConcurrency, int resultSetHoldability)
				throws SQLException {
			return connection.prepareCall(sql, resultSetType,
					resultSetConcurrency, resultSetHoldability);
		}

		@Override
		public PreparedStatement prepareStatement(String sql)
				throws SQLException {
			return connection.prepareStatement(sql);
		}

		@Override
		public PreparedStatement prepareStatement(String sql,
				int autoGeneratedKeys) throws SQLException {
			return connection.prepareStatement(sql, autoGeneratedKeys);
		}

		@Override
		public PreparedStatement prepareStatement(String sql,
				int[] columnIndexes) throws SQLException {
			return connection.prepareStatement(sql, columnIndexes);
		}

		@Override
		public PreparedStatement prepareStatement(String sql,
				String[] columnNames) throws SQLException {
			return connection.prepareStatement(sql, columnNames);
		}

		@Override
		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency)
				throws SQLException {
			return connection.prepareStatement(sql, resultSetType,
					resultSetConcurrency);
		}

		@Override
		public PreparedStatement prepareStatement(String sql,
				int resultSetType, int resultSetConcurrency,
				int resultSetHoldability) throws SQLException {
			return connection.prepareStatement(sql, resultSetType,
					resultSetConcurrency, resultSetHoldability);
		}

		@Override
		public void releaseSavepoint(Savepoint savepoint) throws SQLException {
			connection.releaseSavepoint(savepoint);

		}

		@Override
		public void rollback() throws SQLException {
			connection.rollback();

		}

		@Override
		public void rollback(Savepoint savepoint) throws SQLException {
			connection.rollback(savepoint);

		}

		@Override
		public void setAutoCommit(boolean autoCommit) throws SQLException {
			connection.setAutoCommit(autoCommit);

		}

		@Override
		public void setCatalog(String catalog) throws SQLException {
			connection.setCatalog(catalog);

		}

		@Override
		public void setClientInfo(Properties properties)
				throws SQLClientInfoException {
			connection.setClientInfo(properties);

		}

		@Override
		public void setClientInfo(String name, String value)
				throws SQLClientInfoException {
			connection.setClientInfo(name, value);

		}

		@Override
		public void setHoldability(int holdability) throws SQLException {
			connection.setHoldability(holdability);

		}

		@Override
		public void setNetworkTimeout(Executor executor, int milliseconds)
				throws SQLException {
			connection.setNetworkTimeout(executor, milliseconds);

		}

		@Override
		public void setReadOnly(boolean readOnly) throws SQLException {
			connection.setReadOnly(readOnly);

		}

		@Override
		public Savepoint setSavepoint() throws SQLException {
			return connection.setSavepoint();
		}

		@Override
		public Savepoint setSavepoint(String name) throws SQLException {
			// TODO Auto-generated method stub
			return connection.setSavepoint(name);
		}

		@Override
		public void setSchema(String schema) throws SQLException {
			connection.setSchema(schema);

		}

		@Override
		public void setTransactionIsolation(int level) throws SQLException {
			connection.setTransactionIsolation(level);

		}

		@Override
		public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
			connection.setTypeMap(map);

		}

	}

}
