package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;

@WebServlet("/admin/DeleteEventServlet")
public class DeleteEventServlet extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		EventsDAO dao = new EventsDAOImpl(getServletContext());
		List<Event> events = dao.getAll();
		/*
		for (int i = 0; i < events.size(); i++){
			if (events.get(i).getId() == id){
				events.remove(i);
			}
		}
		*/
		dao.remove(id);

		response.sendRedirect("/admin/events");
	}
}
