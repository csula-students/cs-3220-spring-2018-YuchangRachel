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
import javax.servlet.http.HttpSession;

import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;

import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.storage.UsersDAO;
import edu.csula.models.User;

@WebServlet(loadOnStartup=1, urlPatterns={"/admin/events"})
public class AdminEventsServlet extends HttpServlet {
	/*
	   public void init(){
	   ArrayList<Event> entries = new ArrayList<>();
	   entries.add(new Event(entries.size(),"Grandma shows up", "Lorem...", 10));
	   entries.add(new Event(entries.size(), "factory shows up", "Lorem...", 50));
	   entries.add(new Event(entries.size(), "digging mine", "Lorem...", 100));
	   getServletContext().setAttribute("event-entries", entries);
	   } 
	   */

	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		UsersDAO dao1 = new UsersDAOImpl(session);

		if (dao1.getAuthenticatedUser().isPresent()){


			EventsDAO dao = new EventsDAOImpl(getServletContext());
			Collection<Event> events = dao.getAll();
			System.out.println(events);


			// TODO: render the events page HTML

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Incremental Game</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../app.css \">");
			out.println("</head>");

			out.println("<body>");
			out.println("<h1>Incremental Game Framework</h1>");
			out.println("<nav>");
			out.println("<a href=\"admin-infor.html\">Game Information</a>");
			out.println(" | ");
			out.println("<a href=\"../admin/generators\">Generators</a>");
			out.println(" | ");
			out.println("<a href=\"events\">Events</a>");
			out.println("</nav>");

			out.println("<a id=\"log\" href=\"./auth\">Log out</a>");

			out.println("<form method=\"POST\">");
			out.println("<label for=\"eventname\">Event Name</label><br>");
			out.println("<input type=\"text\" name=\"name\" id=\"eventname\"><br>");
			out.println("<label for=\"eventDescription\">Event Description</label><br>");
			out.println("<textarea name=\"description\" id=\"eventDescription\"></textarea><br>");
			out.println("<label for=\"triggerAt\">Trigger at</label><br>");
			out.println("<input type=\"number\" name=\"trigger\" id=\"triggerAt\"><br>");
			out.println("<button>Add{Edit}</button>");
			out.println("</form>");

			out.println("<table>");
			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<th>Description</th>");
			out.println("<th>TriggerAt</th>");
			out.println("<th>Action</th>");
			out.println("</tr>");
			for (Event event : events) {
				out.println("<tr>");
				out.println("<td>" + event.getName() + "</td>");
				out.println("<td>" + event.getDescription() + "</td>");
				out.println("<td>" + event.getTriggerAt() + "</td>");
				out.println("<td>");
				out.println("<a href=\"EditEventServlet?id=" + event.getId() +"\">Edit</a>");
				out.println("|");
				out.println("<a href=\"DeleteEventServlet?id=" + event.getId() + "\">delete</a>");
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");

			out.println("</body>");
			out.println("</html>");
		}
		else {
			response.sendRedirect("/admin/auth");
		}
	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> events = dao.getAll();

		//parse information
		String name = request.getParameter("name");
		String description = request.getParameter("description");   
		int triggerAt = Integer.parseInt(request.getParameter("trigger"));
		Event event = new Event(events.size(), name, description, triggerAt);

		//transaction
		dao.add(event);
		response.sendRedirect("/admin/events");
	}
}
