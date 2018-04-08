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

@WebServlet("/admin/events")
public class AdminEventsServlet extends HttpServlet {
	public void init(){
		ArrayList<Event> entries = new ArrayList<>();
		entries.add(new Event(entries.size(),"Grandma shows up", "Lorem...", 10));
		entries.add(new Event(entries.size(), "factory shows up", "Lorem...", 50));
		entries.add(new Event(entries.size(), "digging mine", "Lorem...", 100));
		getServletContext().setAttribute("event-entries", entries);
	} 
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// TODO: render the events page HTML
		String html = "<h1>Incremental Game</h1>";
		ArrayList<Event> entries = (ArrayList<Event>)getServletContext().getAttribute("event-entries");
		html += "<h3> Game Information | Generators | Events</h3>";
		html += "<form method='POST'>";
		html += "<label for='name'>Event name</label><br>";
		html += "<input name='name' id='name' type='text' /><br>";
		html += "<label for='description'>Event Descrption</label><br>";
		html += "<textarea name='description'></textarea><br>";
		html += "<label for='triggerAt'>Trigger At</label><br>";
		html += "<input name='triggerAt' id='triggerAt' type='text' /><br>";
		html += "<button>{Add|Edit}</button>";
		html += "</form>";


		html += "<table border = '1'>";
		html += "<tr>";
		html += "<th>Name</th>";
		html += "<th>Description</th>";
		html += "<th>Trigger At </th>";
		html += "<th>Action</th>";
		html += "</tr>";

		for (Event entry: entries){
			html += "<tr>";
			html += "<td>" + entry.getName() + "</td><td> " + entry.getDescription() + "</td><td>" + entry.getTriggerAt();
			html += "</td><td><a href='./admin/edit?id=" + entry.getId() +"'>Edit</a> | <a href='./guestbook/delete?id=" + entry.getId() + "'>Delete</a></td>";
			html += "</tr>";
		}	
		html += "</table>";

		EventsDAO dao = new EventsDAOImpl(getServletContext());
		dao.add(entry);
		Collection<Event> events = dao.getAll();
		System.out.println(events);
		out.println(html);
		getServletContext().setAttribute(entries);
	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
		ArrayList<Event> entries = (ArrayList<Event>)getServletContext().getAttribute("event-entries");
		String name = request.getParameter("name");
		String description = request.getParameter("description");   //associate with name in put and textarea
		int triggerAt = request.getParameter("triggerAt");

		Event entry = new Event(entries.size(), name, description, triggerAt);
		entries.add(entry);
		response.sendRedirect("/admin/events");
	}
}
