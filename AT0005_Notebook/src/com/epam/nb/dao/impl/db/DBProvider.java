package com.epam.nb.dao.impl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.epam.nb.dao.impl.memory.NoteBookProvider;
import com.epam.nb.entity.NoteBook;


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
