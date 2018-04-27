package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Collection;

import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;

import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.storage.UsersDAO;
import edu.csula.models.User;

@WebServlet("/admin/generators")
public class AdminGeneratorsServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(); 
		UsersDAO dao1 = new UsersDAOImpl(session);

		if (dao1.getAuthenticatedUser().isPresent()) {
			GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
			Collection<Generator> generators = dao.getAll();
			System.out.println(generators);

			// TODO: render the generators page HTML
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
			out.println("<a href=\"generators\">Generators</a>");
			out.println(" | ");
			out.println("<a href=\"../admin/events\">Events</a>");
			out.println("</nav>");

			out.println("<a id=\"log\" href=\"./auth\">Log out</a>");

			out.println("<form method=\"POST\">");
			out.println("<label for=\"generatorname\">Generator Name</label><br>");
			out.println("<input type=\"text\" name=\"name\" id=\"generatorname\"><br>");
			out.println("<label for=\"generatorrate\">Generator Rate</label><br>");
			out.println("<input type=\"number\" name=\"rate\" id=\"generatorrate\"><br>");
			out.println("<label for=\"basecost\">Base Cost</label><br>");
			out.println("<input type=\"number\" name=\"cost\" id=\"basecost\"><br>");
			out.println("<label for=\"unlockat\">Unlock at</label><br>");
			out.println("<input type=\"number\" name=\"unlock\" id=\"unlockat\"><br>");
			out.println("<label for=\"generatorDescription\">Event Description</label><br>");
			out.println("<textarea name=\"description\" id=\"generatorDescription\"></textarea><br>");
			out.println("<button>Add{edit}</button>");
			out.println("</form>");


			out.println("<table>");
			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<th>Rate</th>");
			out.println("<th>Cost</th>");
			out.println("<th>Unlock At</th>");
			out.println("<th>Description</th>")
			out.println("<th>Action</th>");
			out.println("</tr>");
			for (Generator generator : generators) {
				out.println("<tr>");
				out.println("<td>" + generator.getName() + "</td>");
				out.println("<td>" + generator.getRate() + "</td>");
				out.println("<td>" + generator.getBaseCost() + "</td>");
				out.println("<td>" + generator.getUnlockAt() + "</td>");
				out.println("<td>" + generator.getDescription() + "</td>");
				out.println("<td>");
				out.println("<a href=\"EditGeneratorServlet?id=" + generator.getId() +"\">Edit</a>");
				out.println("|");
				out.println("<a href=\"DeleteGeneratorServlet?id=" + generator.getId() + "\">delete</a>");
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");

			out.println("</body>");
			out.println("</html>");
		}
		else {
			response.sendRedirect("auth");
		}

	}


	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		Collection<Generator> generators = dao.getAll();

		//parse information
		String name = request.getParameter("name");
		int rate = Integer.parseInt(request.getParameter("rate"));
		int baseCost = Integer.parseInt(request.getParameter("cost"));
		int unlockAt = Integer.parseInt(request.getParameter("unlock"));
		String description = request.getParameter("description");   
		Generator generator = new Generator(generators.size(), name, description, rate, baseCost, unlockAt);

		//transaction
		dao.add(generator);
		response.sendRedirect("generators");
	}
}
