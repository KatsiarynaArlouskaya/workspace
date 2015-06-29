package com.epam.nb.dao;

import com.epam.nb.dao.DAOException;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public interface NoteBookDao {
    Note find(String content) throws DAOException;
    Note find(int id) throws DAOException;
    void add(Note note) throws DAOException;
    void create() throws DAOException;
    NoteBook notebook() throws DAOException;
}
