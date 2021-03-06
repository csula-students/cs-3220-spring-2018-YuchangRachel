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

import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;

import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.storage.UsersDAO;
import edu.csula.models.User;

@WebServlet("/admin/DeleteGeneratorServlet")
public class DeleteGeneratorServlet extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAO dao1 = new UsersDAOImpl(request.getSession());

		if (!dao1.getAuthenticatedUser().isPresent()) {
			response.sendRedirect("auth");
		}

		int id = Integer.parseInt(request.getParameter("id"));
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		List<Generator> generators = dao.getAll();
		/*
		   for (int i = 0; i < generators.size(); i++){
		   if (generators.get(i).getId() == id){
		   generators.remove(i);
		   }
		   }
		   */

		dao.remove(id);

		response.sendRedirect("generators");
	}
}
