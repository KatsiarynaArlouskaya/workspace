package com.epam.nb.entity;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String content;
	private Date date;

	public Note(String newContent, Date newDate) {
		content = newContent;
		date = newDate;
	}
	
	public Note(String newContent) {
		content = newContent;
		date = new Date();
	}


	public String toString() {
		return getClass().getName() + "@" + "content: " + content + ", date: "
				+ date;
	}

	public int hashCode() {
		return (int) (((null == content) ? 0 : content.hashCode()) + ((null == date) ? 0
				: date.hashCode()));
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Note note = (Note) obj;
		if (null == date) {
			return (date == note.date);
		} else {
			if (!date.equals(note.date)) {
				return false;
			}
		}
		if (null == content) {
			return (content == note.content);
		} else {
			if (!content.equals(note.content)) {
				return false;
			}
		}
		return true;
	}

	public Note() {
	}

	public void setContent(String newContent) {
		content = newContent;
	}

	public void setDate(Date newDate) {
		date = newDate;
	}

	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}

}
