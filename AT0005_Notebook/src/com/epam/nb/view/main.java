package com.epam.nb.view;

import java.util.GregorianCalendar;

import com.epam.nb.controller.CommandName;
import com.epam.nb.controller.NoteBookController;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.RequestParam;
import com.epam.nb.entity.Response;

public class main {

	public static void main(String[] args) {
		NoteBookController controller = new NoteBookController();
		Request request = new Request();
		Response response = controller.doCommand(CommandName.NEW_NOTEBOOK, request);
		if (response.getStatus()==true){
			System.out.println("Create notebook is OK");
		}
		request = new Request();
		request.setParam(RequestParam.CONTENT_FOR_NOTE, "first note");
		request.setParam(RequestParam.DATE_FOR_NOTE, GregorianCalendar.getInstance().getTime());
		response = controller.doCommand(CommandName.ADD_NEW_NOTE, request);
		if (response.getStatus()==true){
			System.out.println("Add note is OK");
		}
		request = new Request();
		request.setParam(RequestParam.CONTENT_FOR_NOTE, "second note");
		request.setParam(RequestParam.DATE_FOR_NOTE, GregorianCalendar.getInstance().getTime());
		response = controller.doCommand(CommandName.ADD_NEW_NOTE, request);
		if (response.getStatus()==true){
			System.out.println("Add note is OK");
		}
		response = controller.doCommand(CommandName.SHOW_ALL_NOTES, request);
		if (response.getStatus()==true){
			System.out.println("Show notes is OK");
		}

	}

}
