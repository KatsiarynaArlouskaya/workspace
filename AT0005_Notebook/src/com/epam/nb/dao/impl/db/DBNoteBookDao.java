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

	@Override
	public Note find(String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note find(int id) throws DAOException {
		
		Connection con;
		try {
			con = DBProvider.getInstance().getConnectToDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM notepad WHERE id=2");
			int id_ = rs.getInt("id");
			long date = rs.getLong("date");
			String content = rs.getString("content");
			System.out.println("ID = " + id_);
			System.out.println("date = " + date);
			System.out.println("content = " + content);
			System.out.println();
			System.out.println("Запись найдена");
			return new Note(content, new Date(date));
		} catch (ClassNotFoundException | SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}
	}

	@Override
	public void add(Note note) throws DAOException {
		try {
			Connection con = DBProvider.getInstance().getConnectToDB();
			Statement st = con.createStatement();
			st.execute("INSERT INTO 'notepad' ('date', 'content') VALUES ("+note.getDate().getTime()+", '"+note.getContent()+"'); ");
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}

	}

	@Override
	public void create() throws DAOException {
		try {
			Connection con = DBProvider.getInstance().getConnectToDB();
			Statement st = con.createStatement();
			st.execute("DROP TABLE 'notepad';");
			st.execute("CREATE TABLE 'notepad' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'date' BIGINT, 'content' text);");
			System.out.println("Таблица создана или уже существует.");
			st.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}

	}

	@Override
	public NoteBook notebook() throws DAOException {
		NoteBook notebook = new NoteBook();
		Connection con;
		try {
			con = DBProvider.getInstance().getConnectToDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM notepad");
			while (rs.next()) {
				int id = rs.getInt("id");
				long date = rs.getLong("date");
				String content = rs.getString("content");
				notebook.addNewNote(content, new Date(date));
			}
			return notebook;
		} catch (ClassNotFoundException | SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}

	}

}
