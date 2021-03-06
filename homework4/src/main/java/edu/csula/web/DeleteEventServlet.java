package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.storage.UsersDAO;
import edu.csula.models.User;

import edu.csula.storage.EventsDAO;
import edu.csula.storage.mysql.*;
import edu.csula.models.*;

@WebServlet("/admin/DeleteEventServlet")
public class DeleteEventServlet extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAO dao1 = new UsersDAOImpl(request.getSession());

		if (!dao1.getAuthenticatedUser().isPresent()) {
			response.sendRedirect("auth");
		}
		EventsDAO dao = new EventsDAOImpl(new Database());

		int id = Integer.parseInt(request.getParameter("id"));
		Collection<Event> events = dao.getAll();

		dao.remove(id);

		response.sendRedirect("events");
	}
}
