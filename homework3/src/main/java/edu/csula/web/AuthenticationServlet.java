package edu.csula.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csula.storage.servlet.UsersDAOImpl;
import edu.csula.storage.UsersDAO;
import edu.csula.models.User;


@WebServlet("/admin/auth")
public class AuthenticationServlet extends HttpServlet {
	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		doDelete(request, response);
		request.getRequestDispatcher("/WEB-INF/admin-authentication.jsp")
			.forward(request, response);
	}

	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle login
		String username = request.getParameter("name");
		String password = request.getParameter("pin");
		HttpSession session = request.getSession();
		UsersDAO dao = new UsersDAOImpl(session);

		if (dao.authenticate(username, password)){
			response.sendRedirect("events");
		}
		else {
			response.sendRedirect("auth");
		}

	}

	@Override
	public void doDelete( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: handle logout
		HttpSession session = request.getSession();
		UsersDAO dao = new UsersDAOImpl(session);
		dao.logout();
	}
}
