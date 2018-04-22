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

import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;

@WebServlet("/admin/EditGeneratorServlet")
public class EditGeneratorServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		Collection<Generator> generators = dao.getAll();
		Generator generator = null;
		for (Generator e : generators){
			if (e.getId() == id){
				generator = e;
			}
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("../WEB-INF/edit-generator-servlet.jsp")
            .forward(request, response);
	}


	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		Collection<Generator> generators = dao.getAll();
		int id = Integer.parseInt(request.getParameter("id"));
		Generator generator = null;
		for (Generator e : generators){
			if (e.getId() == id){
				generator = e;
			}
		}

		String name = request.getParameter("name");
		int rate = Integer.parseInt(request.getParameter("rate"));
		int baseCost = Integer.parseInt(request.getParameter("cost"));
		int unlockAt = Integer.parseInt(request.getParameter("unlock"));
		String description = request.getParameter("description");

		generator.setName(name);
		generator.setRate(rate);
		generator.setBaseCost(baseCost);
		generator.setUnlockAt(unlockAt);
	    generator.setDescription(description);

		response.sendRedirect("/admin/generators");
	}
}
