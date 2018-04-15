package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_002devents_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../app.css\">\n");
      out.write("\t\t<title>Incremental Game</title>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\t<h1>Incremental Game</h1>\n");
      out.write("\t\t<nav>\n");
      out.write("\t\t\t<a href=\"admin-infor.html\">Game Information</a>\n");
      out.write("\t\t\t|\n");
      out.write("\t\t\t<a href=\"admin-generators.html\">Generators</a>\n");
      out.write("\t\t\t|\n");
      out.write("\t\t\t<a href=\"admin-events.html\">Events</a>\n");
      out.write("\t\t</nav>\n");
      out.write("\t\t<form action=\"/admin/events\" method=\"post\">\n");
      out.write("\t\t\t<label for='eventname'>Event name</label><br>\n");
      out.write("\t\t\t<input name='name' id='eventname' type='text' /><br>\n");
      out.write("\t\t\t<label for='eventdescrib'>Event Descrption</label><br>\n");
      out.write("\t\t\t<textarea name='description' id='eventdescrib'></textarea><br>\n");
      out.write("\t\t\t<label for='triggerAt'>Trigger At</label><br>\n");
      out.write("\t\t\t<input name='trigger' id='triggerAt' type='number' /><br>\n");
      out.write("\n");
      out.write("\t\t\t<button>Add|Edit</button>\n");
      out.write("\t\t</form>\n");
      out.write("\n");
      out.write("\t\t<table>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<th>Name</th>\n");
      out.write("\t\t\t\t<th>Description</th>\n");
      out.write("\t\t\t\t<th>Trigger At </th>\n");
      out.write("\t\t\t\t<th>Action</th>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eventEntries}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"event\">\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${event.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${event.getDescription()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${event.getTriggerAt()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t<a href='EditEventServlet?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${event.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'>Edit</a> |\n");
      out.write("\t\t\t\t\t<a href='DeleteEventsServlet?id=id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${event.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'>Delete</a>\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t</c:forEach>\n");
      out.write("\n");
      out.write("\t\t</table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
