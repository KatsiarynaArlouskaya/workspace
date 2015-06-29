package com.epam.nb.dao.impl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.epam.nb.dao.DAOException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class DBNoteBookDao implements NoteBookDao {

	@Override
	public Note find(String contentSearch) throws DAOException {
		Connection con;
		Note note;
		try {
			ConnectionPool connectionPool = DBProvider.getInstance().getConnectionPool();
			con = connectionPool.takeConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM notepad WHERE content LIKE '%"+contentSearch+"%'");
			if (rs.next()){
				long date = rs.getLong("date");
				String content = rs.getString("content");		
				note = new Note(content, new Date(date));
			}
			else {
				note =null;
			}	
			connectionPool.closeConnection(con, st, rs);
		} catch (SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}
		return note;
	}

	@Override
	public Note find(int idSearch) throws DAOException {	
		Note note;
		Connection con;
		try {
			idSearch++; //Id starts with 1 in DB, instead 0 in ArrayList.
			ConnectionPool connectionPool = DBProvider.getInstance().getConnectionPool();
			con = connectionPool.takeConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM notepad WHERE id="+idSearch);
			if (rs.next()){
				long date = rs.getLong("date");
				String content = rs.getString("content");		
				note = new Note(content, new Date(date));
			}
			else {
				note =null;
			}
			connectionPool.closeConnection(con, st, rs);
		} catch (SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}
		return note;
	}

	@Override
	public void add(Note note) throws DAOException {
		Connection con;
		try {
			ConnectionPool connectionPool = DBProvider.getInstance().getConnectionPool();
			con = connectionPool.takeConnection();
			Statement st = con.createStatement();
			st.execute("INSERT INTO 'notepad' ('date', 'content') VALUES ("+note.getDate().getTime()+", '"+note.getContent()+"'); ");
			connectionPool.closeConnection(con, st);
		} catch (SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}

	}

	@Override
	public void create() throws DAOException {
		Connection con;
		final String driverName = "org.sqlite.JDBC";
		final String url = "jdbc:sqlite:TEST1.s3db";
		try {
			Class.forName(driverName);
			con =  DriverManager.getConnection(url);
			Statement st = con.createStatement();
			st.execute("DROP TABLE 'notepad';");
			st.execute("CREATE TABLE 'notepad' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'date' BIGINT, 'content' text);");
			System.out.println("Notebook created");
			con.close();
			st.close();
		} catch (SQLException e) {
			throw new DAOException("Fail to create to DB", e);
		} catch (ClassNotFoundException e) {
			throw new DAOException("Can't find database driver class", e);
		}
	}

	@Override
	public NoteBook notebook() throws DAOException {
		NoteBook notebook = new NoteBook();
		Connection con;
		try {
			ConnectionPool connectionPool = DBProvider.getInstance().getConnectionPool();
			con = connectionPool.takeConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM notepad");
			while (rs.next()) {
				long date = rs.getLong("date");
				String content = rs.getString("content");
				notebook.addNewNote(content, new Date(date));
			}	
			connectionPool.closeConnection(con, st, rs);
		} catch (SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}
		return notebook;

	}

}
