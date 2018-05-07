package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.models.State;

import java.util.Collection;

import edu.csula.storage.servlet.EventsDAOImpl;
import edu.csula.storage.EventsDAO;
import edu.csula.models.Event;

import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/game")
public class GameJsonServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		EventsDAO dao = new EventsDAOImpl(getServletContext());
		Collection<Event> stories = dao.getAll();
		GeneratorsDAO dao1 = new GeneratorsDAOImpl(getServletContext());
		Collection<Generator> generators = dao1.getAll();

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String state = gson.toJson(new State(stories, generators));

		out.println(state);
		request.setAttribute("state", state);

		response.setContentType("text/html");
		request.getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
	}

}
