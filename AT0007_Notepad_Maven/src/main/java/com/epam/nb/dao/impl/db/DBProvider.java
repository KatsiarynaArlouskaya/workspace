package com.epam.nb.dao.impl.db;

public class DBProvider {

    private static final DBProvider dbProvider = new DBProvider();
    private ConnectionPool connectionPool = new ConnectionPool();
    
    
    public static DBProvider getInstance(){
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
