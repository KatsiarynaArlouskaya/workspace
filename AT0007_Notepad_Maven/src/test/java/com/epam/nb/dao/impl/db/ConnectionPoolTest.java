package com.epam.nb.dao.impl.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.epam.nb.dao.DAOException;

public class ConnectionPoolTest {

  @Test
  public void takeConnection() {
	  Connection con1, con2, con3, con4, con5, con6;
	  ConnectionPool connectionPool = ConnectionPool.getInstance();
		try {
			con1 = connectionPool.takeConnection();
			con2 = connectionPool.takeConnection();
			con3 = connectionPool.takeConnection();
			con4 = connectionPool.takeConnection();
			con5 = connectionPool.takeConnection();
			con1.close();
			con2.close();
			con3.close();
			con4.close();
			con5.close();
			
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
}
