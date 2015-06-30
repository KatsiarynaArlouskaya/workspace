package com.epam.nb.dao.impl.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.nb.dao.DAOException;
import com.epam.nb.view.main;

public class ConnectionPoolProvider {

    private static final ConnectionPoolProvider dbProvider = new ConnectionPoolProvider();
    private ConnectionPool connectionPool = new ConnectionPool();
	private static final Logger logger = LogManager.getLogger(main.class.getName());
    
    private ConnectionPoolProvider() {
			try {
				connectionPool.initPoolData();
			} catch (DAOException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
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
