/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.75
 * Generated at: 2023-07-06 06:51:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/Study_Spring/WorkSpace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/02.Smart/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1684805391722L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("	<title>Home</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h3 class=\"my-4\">스마트 웹&amp;앱 과정</h3>\n");
      out.write("<img style=\"width:100%\" src=\"img/hanul.png\">\n");
      out.write("상품명: <input type=\"text\" id=\"name\">\n");
      out.write("가격: <input type=\"text\" id=\"price\">\n");
      out.write("<button onclick=\"test()\">보내기(jsp)</button>\n");
      out.write("<button onclick=\"xml()\">보내기(xml)</button>\n");
      out.write("<div id=\"xml-result\"></div>\n");
      out.write("<table id=\"ajax-result\">\n");
      out.write("	<tr>\n");
      out.write("		<th>상품명</th>\n");
      out.write("		<th>가격</th>\n");
      out.write("	</tr>\n");
      out.write("	<tr>\n");
      out.write("		<td>커피</td>\n");
      out.write("		<td>1000</td>\n");
      out.write("	</tr>\n");
      out.write("	<tr>\n");
      out.write("		<td>콜라</td>\n");
      out.write("		<td>1200</td>\n");
      out.write("	</tr>\n");
      out.write("	<tr>\n");
      out.write("		<td>우유</td>\n");
      out.write("		<td>1500</td>\n");
      out.write("	</tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("function xml() {\n");
      out.write("	$.ajax({\n");
      out.write("		url : 'xml',\n");
      out.write("	}).done(function(response){\n");
      out.write("		console.log(response)\n");
      out.write("		// console.log(response)\n");
      out.write("		console.log($(response).find(\"product\"))\n");
      out.write("		var tag = '';\n");
      out.write("		$(response).find(\"product\").each(function(){\n");
      out.write("			var name = $(this).find(\"name\").text()\n");
      out.write("			var price = $(this).find(\"price\").text()\n");
      out.write("			tag += `<div><span>${name}</span><span>${price}</span></div>`;\n");
      out.write("		})\n");
      out.write("		$('#xml-result').append(tag)\n");
      out.write("	})\n");
      out.write("	\n");
      out.write("}\n");
      out.write("\n");
      out.write("function test() {\n");
      out.write("	$.ajax({\n");
      out.write("		url: 'test',\n");
      out.write("//		type: 'post',\n");
      out.write("		data: { name: $('#name').val(),  price: $(\"#price\").val() },\n");
      out.write("	}).done(function(response){\n");
      out.write("		console.log(response)\n");
      out.write("		$('#ajax-result').append(response)\n");
      out.write("	})\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
