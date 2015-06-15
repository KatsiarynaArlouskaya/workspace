package com.epam.nb.entity;

import java.util.Date;

public class Note {
	private String content;
	private Date date;

	Note(String newContent, Date newDate) {
		content = newContent;
		date = newDate;
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
