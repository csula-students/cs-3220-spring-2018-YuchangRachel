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

import edu.csula.storage.EventsDAO;
import edu.csula.storage.mysql.*;
import edu.csula.models.*;

@WebServlet("/admin/events")
public class AdminEventsServlet extends HttpServlet {

	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventsDAO dao = new EventsDAOImpl(new Database());

		Collection<Event> events = dao.getAll();

		request.setAttribute("eventEntries", events);
		request.getRequestDispatcher("/WEB-INF/admin-events.jsp")
			.forward(request, response);

	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
		EventsDAO dao = new EventsDAOImpl(new Database());
		Collection<Event> events = dao.getAll();

		//parse information
		String name = request.getParameter("name");
		String description = request.getParameter("description");   
		int triggerAt = Integer.parseInt(request.getParameter("trigger"));
		Event event = new Event(events.size(), name, description, triggerAt);

		//transaction
		dao.add(event);
		response.sendRedirect("events");
	}
}
