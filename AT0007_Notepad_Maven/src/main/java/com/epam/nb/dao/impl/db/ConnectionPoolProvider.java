package com.epam.nb.dao.impl.db;

import com.epam.nb.dao.DAOException;

public class ConnectionPoolProvider {

    private static final ConnectionPoolProvider dbProvider = new ConnectionPoolProvider();
    private ConnectionPool connectionPool = new ConnectionPool();
    
    private ConnectionPoolProvider() {
			try {
				connectionPool.initPoolData();
			} catch (DAOException e) {
				e.printStackTrace();
			}
	}
    
    public static ConnectionPoolProvider getInstance(){
        return dbProvider;
    }
    
    public ConnectionPool getConnectionPool(){
        return connectionPool;
    }
    
    /*    public static DBProvider getInstance(){
        return dbProvider;
    }
    
	public Connection getConnectToDB() throws ClassNotFoundException, SQLException{
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");	
		return con;
	}*/
    
    
      


    
}
