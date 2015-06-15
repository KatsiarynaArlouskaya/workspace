package com.epam.nb.dao.impl.memory;

import com.epam.nb.entity.NoteBook;

public class NoteBookProvider {
    private static final NoteBookProvider notebookProvider = new NoteBookProvider();
    private NoteBook noteBook = new NoteBook();
    
    public static NoteBookProvider getInstance(){
        return notebookProvider;
    }
    
    public NoteBook getNoteBook(){
        return noteBook;
    }

}
