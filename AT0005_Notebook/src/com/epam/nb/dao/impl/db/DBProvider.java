package com.epam.nb.dao.impl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBProvider {
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement preparedStatement = null;
	
	
    private static final DBProvider dbProvider = new DBProvider();
    
    public static DBProvider getInstance(){
        return dbProvider;
    }
    
	public Connection getConnectToDB() throws ClassNotFoundException, SQLException{
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");	
		return con;
	}
      


    
}
