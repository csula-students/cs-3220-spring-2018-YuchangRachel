package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class game_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta charset=\"UTF-8\">\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../game.css\">\n");
      out.write("\t\t<title>Incremental game</title>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\t<h1>Cookie Clicker</h1>\n");
      out.write("\n");
      out.write("\t\t<div class=\"stories\">\n");
      out.write("\t\t\t<game-story-book></game-story-book>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<game-button></game-button>\n");
      out.write("\n");
      out.write("\t\t<game-counter></game-counter>\n");
      out.write("\n");
      out.write("\t\t<div class=\"generators\">\n");
      out.write("\t\t\t<game-generator data-id=\"0\"></game-generator>\n");
      out.write("\t\t\t<game-generator data-id=\"1\"></game-generator>\n");
      out.write("\t\t\t<game-generator data-id=\"2\"></game-generator>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<!-- import webcomponent polyfill for other browsers -->\n");
      out.write("\t\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/webcomponentsjs/1.1.0/webcomponents-lite.js\"></script>\n");
      out.write("\n");
      out.write("\t\t<script>\n");
      out.write("\t\t  window.game = {\n");
      out.write("\t\t  state: {\n");
      out.write("\t\t  counter: 0\n");
      out.write("\t\t  }\n");
      out.write("\t\t  };\n");
      out.write("\n");
      out.write("\t\t  window.game.state = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${state}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("; // where state is passed from Controller as JSON string\n");
      out.write("\t\t</script>\n");
      out.write("\t\t<script src ='app.bundle.js'></script>\n");
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
