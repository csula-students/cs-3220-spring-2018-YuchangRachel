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
import javax.servlet.http.*;

import edu.csula.storage.servlet.GeneratorsDAOImpl;
import edu.csula.storage.GeneratorsDAO;
import edu.csula.models.Generator;

import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.storage.UsersDAO;
import edu.csula.models.User;

@WebServlet("/admin/EditGeneratorServlet")
public class EditGeneratorServlet extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		UsersDAO dao1 = new UsersDAOImpl(session);

		if (dao1.getAuthenticatedUser().isPresent()) {	
			GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
			Collection<Generator> generators = dao.getAll();
			int id = Integer.parseInt(request.getParameter("id"));
			Generator generator = null;
			for (Generator e : generators){
				if (e.getId() == id){
					generator = e;
				}
			}
			String html = "";
			html += "<form method='POST'>";
			html += "<h2>Edit Generators Information</h2>";
			html += "<label for='generatorname'>Generator Name: </label><br>";
			html += "<input type='text'name='name' id='generatorname' value='"+ generator.getName() + "' /><br>";
			html += "<label for='generatorrate'>Generator Rate: </label><br>";
			html += "<input type='number' name='rate' id='generatorrate' value='" + generator.getRate() + "'/><br>";
			html += "<label for='basecost'>Base Cost: </label><br>";
			html += "<input type='number' name='cost' id='basecost' value='" + generator.getBaseCost() + "'/><br>";
			html += "<label for='unlockat'>Unlock At: </label><br>";
			html += "<input type='number' name='unlock' id='unlockat' value='" + generator.getUnlockAt() + "'/><br>";
			html += "<label for='generatorDescription'>Generator Descrption</label><br>";
			html += "<textarea name='description' id='generatorDescription'>" + generator.getDescription() + "</textarea>";
			html += "<button>Submit</button>";
			html += "</form>";
			out.println(html);
		}
		else {
			response.sendRedirect("auth");
		}
	}


	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle upsert transaction
		GeneratorsDAO dao = new GeneratorsDAOImpl(getServletContext());
		Collection<Generator> generators = dao.getAll();
		int id = Integer.parseInt(request.getParameter("id"));
		/*
		   Generator generator = null;
		   for (Generator e : generators){
		   if (e.getId() == id){
		   generator = e;
		   }
		   }
		   */


		String name = request.getParameter("name");
		int rate = Integer.parseInt(request.getParameter("rate"));
		int baseCost = Integer.parseInt(request.getParameter("cost"));
		int unlockAt = Integer.parseInt(request.getParameter("unlock"));
		String description = request.getParameter("description");

		/*
		   generator.setName(name);
		   generator.setRate(rate);
		   generator.setBaseCost(baseCost);
		   generator.setUnlockAt(unlockAt);
		   generator.setDescription(description);
		   */

		dao.set(id, new Generator(generators.size(), name, description, rate, baseCost, unlockAt));
		response.sendRedirect("generators");
	}
}
