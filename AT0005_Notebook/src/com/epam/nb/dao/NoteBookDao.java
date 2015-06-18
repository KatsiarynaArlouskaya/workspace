package com.epam.nb.dao;

import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public interface NoteBookDao {
    Note find(String content);
    Note find(int id);
    void add(Note note);
    void create();
    NoteBook notebook();
}
