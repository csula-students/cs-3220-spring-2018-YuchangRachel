package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;

@WebServlet("/admin/EditEventServlet")
public class EditEventServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = dao.getAll();
		int id = Integer.parseInt(request.getParameter("id"));
		Event event = null;
		for (Event e : events){
			if (e.getId() == id){
				event = e;
			}
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String html = "";
		html += "<form method='POST'>";
		html += "<h2>Edit Comment</h2>";
		html += "<label for='name'>Name: </label>";
		html += "<input type='text'name='name' id='eventname' value='"+ event.getName() + "' />";
		html += "<label for='eventdescrib'>Event Descrption</label><br>";
		html += "<textarea name='description' id='eventdescrib'>" + event.getDescription() + "</textarea>";
		html += "<label for='triggerAt'>Trigger At</label><br>";
		html += "<input type='number' name='trigger' id='triggerAt' value='"+ event.getTriggerAt() + "' /><br>";
		html += "<button>Submit</button>";
		html += "</form>";
		out.println(html);
	}


	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = dao.getAll();
		int id = Integer.parseInt(request.getParameter("id"));
		/*
		Event event = null;
		for (Event e : events){
			if (e.getId() == id){
				event = e;
			}
		}
		*/

		String name = request.getParameter("name");
		String description = request.getParameter("description");   
		int triggerAt = Integer.parseInt(request.getParameter("trigger"));
		/*
		event.setName(name);
		event.setDescription(description);
		event.setTriggerAt(triggerAt);
		*/
		dao.set(id, new Event(events.size(), name, description, triggerAt));

		response.sendRedirect("/admin/events");
	}
}
