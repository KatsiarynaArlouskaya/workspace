package com.epam.nb.dao.impl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	public Note find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Note note) throws DAOException {
		String sql = "INSERT INTO notepad (date, content) VALUES (?, ?); ";
		try {
			Connection con = DBProvider.getInstance().getConnectToDB();
		/*	PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setLong(1, note.getDate().getTime());
			preparedStatement.setString(2, note.getContent());
			preparedStatement.close();*/
			 
			Statement st = con.createStatement();
			st.execute("INSERT INTO 'notepad' ('date', 'content') VALUES ("+note.getDate().getTime()+", '"+note.getContent()+"'); ");
			st.close();
			con.close();
			System.out.println("Запись добавлена: " + note.getDate().getTime()
					+ " " + note.getContent());
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
				System.out.println("ID = " + id);
				System.out.println("date = " + date);
				System.out.println("content = " + content);
				System.out.println();
				notebook.addNewNote(content, new Date(date));
				System.out.println("Таблица выведена");
			}
			return notebook;
		} catch (ClassNotFoundException | SQLException e) {
			throw new DAOException("Fail to access to DB", e);
		}

	}

}
