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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = dao.getAll();
		System.out.println(events);


		// TODO: render the events page HTML
		String html = "<head>";
		html += "<title>Incremental Game</title>";
		html += "<link rel=\"stylesheet\" type=\"text/css\" href=\"../style.css\">";
		html += "</head>";
		html += "<body>";
		html += "<h1>Incremental Game</h1>";
		html += "<nav>";
		html += "<a href=\"admin-infor.html\">Game Information</a>";
		html += " | ";
		html += "<a href=\"admin-generators.html\">Generators</a>";
		html += " | ";
		html += "<a href=\"admin-events.html\">Events</a>";
		html += "</nav>";

		html += "<form method='POST'>";
		html += "<label for='name'>Event name</label><br>";
		html += "<input name='name' id='name' type='text' /><br>";
		html += "<label for='description'>Event Descrption</label><br>";
		html += "<textarea name='description'></textarea><br>";
		html += "<label for='triggerAt'>Trigger At</label><br>";
		html += "<input name='triggerAt' id='triggerAt' type='text' /><br>";
		html += "</form>";	
		
		html += "<button>Add|Edit</button>";


		html += "<table>";
		html += "<tr>";
		html += "<th>Name</th>";
		html += "<th>Description</th>";
		html += "<th>Trigger At </th>";
		html += "<th>Action</th>";
		html += "</tr>";

		for (Event event: events){
			html += "<tr>";
			html += "<td>" + event.getName() + "</td><td> " + event.getDescription() + "</td><td>" + event.getTriggerAt();
			html += "</td><td><a href='admin/edit?id=" + event.getId() +"'>Edit</a> | <a href='admin/delete?id=" + event.getId() + "'>Delete</a></td>";
			html += "</tr>";
		}	
		html += "</table>";
		html += "</body>";

		out.println(html);
	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = dao.getAll();

		//parse information
		String name = request.getParameter("name");
		String description = request.getParameter("description");   
		int triggerAt = Integer.parseInt(request.getParameter("triggerAt"));
		Event event = new Event(events.size(), name, description, triggerAt);

		//transaction
		dao.add(event);
		response.sendRedirect("/admin/events");
	}
}
