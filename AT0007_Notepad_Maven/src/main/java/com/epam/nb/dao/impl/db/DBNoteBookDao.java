package com.epam.nb.dao.impl.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.epam.nb.dao.DAOException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class DBNoteBookDao implements NoteBookDao {
	private String ID_COLUMN = "id";
	private String DATE_COLUMN = "date";
	private String CONTENT_COLUMN = "content";
	private String TABLE_NAME = "notepad";

	@Override
	public Note find(String contentSearch) throws DAOException {
		Connection con = null;
		Note note;
		ConnectionPool connectionPool=null;
		Statement st = null;
		ResultSet rs = null;
		String sqlRequest = "SELECT * FROM "+TABLE_NAME+" WHERE "+CONTENT_COLUMN+" LIKE '%"+contentSearch+"%'";
		try {
			connectionPool = ConnectionPoolProvider.getInstance().getConnectionPool();
			con = connectionPool.takeConnection();
			st = con.createStatement();
			rs = st.executeQuery(sqlRequest);
			if (rs.next()){
				long date = rs.getLong(DATE_COLUMN);
				String content = rs.getString(CONTENT_COLUMN);		
				note = new Note(content, new Date(date));
			}
			else {
				note =null;
			}	
		} catch (SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}
		finally{
			connectionPool.closeConnection(con, st, rs);
		}
		return note;
	}

	@Override
	public Note find(int idSearch) throws DAOException {	
		Note note;
		ConnectionPool connectionPool = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			idSearch++; //Id starts with 1 in DB, instead 0 in ArrayList.
			connectionPool = ConnectionPoolProvider.getInstance().getConnectionPool();
			con = connectionPool.takeConnection();
			st = con.createStatement();
			String sqlRequest = "SELECT * FROM "+TABLE_NAME+" WHERE "+ID_COLUMN+"="+idSearch;
			rs = st.executeQuery(sqlRequest);
			if (rs.next()){
				long date = rs.getLong(DATE_COLUMN);
				String content = rs.getString(CONTENT_COLUMN);		
				note = new Note(content, new Date(date));
			}
			else {
				note =null;
			}
		} catch (SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}
		finally{
			connectionPool.closeConnection(con, st, rs);
		}
		return note;
	}

	@Override
	public void add(Note note) throws DAOException {
		ConnectionPool connectionPool = null;
		Connection con = null;
		Statement st = null;
		try {
			connectionPool = ConnectionPoolProvider.getInstance().getConnectionPool();
			con = connectionPool.takeConnection();
			st = con.createStatement();
			String sqlRequest = "INSERT INTO "+TABLE_NAME+" ("+DATE_COLUMN+", "+CONTENT_COLUMN+") VALUES ("+note.getDate().getTime()+", '"+note.getContent()+"'); ";
			st.execute(sqlRequest);
		} catch (SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}
		finally{
			connectionPool.closeConnection(con, st);
		}

	}

	@Override
	public void create() throws DAOException {
		ConnectionPool connectionPool = null;
		Connection con = null;
		Statement st = null;
		try {
			connectionPool = ConnectionPoolProvider.getInstance().getConnectionPool();
			con = connectionPool.takeConnection();
			st = con.createStatement();
			String sqlRequest = "DROP TABLE IF EXISTS "+TABLE_NAME+";";
			st.execute(sqlRequest);
			sqlRequest = "CREATE TABLE "+TABLE_NAME+" ("+ID_COLUMN+" INTEGER PRIMARY KEY AUTOINCREMENT, "+DATE_COLUMN+" BIGINT, "+CONTENT_COLUMN+" text);";
			st.execute(sqlRequest);
		} catch (SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}
		finally{
			connectionPool.closeConnection(con, st);
		}
	}

	@Override
	public NoteBook notebook() throws DAOException {
		NoteBook notebook = new NoteBook();
		ConnectionPool connectionPool = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connectionPool = ConnectionPoolProvider.getInstance().getConnectionPool();
			con = connectionPool.takeConnection();
			st = con.createStatement();
			String sqlRequest = "SELECT * FROM "+TABLE_NAME;
			rs = st.executeQuery(sqlRequest);
			while (rs.next()) {
				long date = rs.getLong(DATE_COLUMN);
				String content = rs.getString(CONTENT_COLUMN);
				notebook.addNewNote(content, new Date(date));
			}	
		} catch (SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}
		finally{
			connectionPool.closeConnection(con, st, rs);
		}
		return notebook;

	}

}
