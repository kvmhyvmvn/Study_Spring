/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.75
 * Generated at: 2023-08-22 02:11:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.khm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class new_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h3 class=\"my-4\">새 글 쓰기</h3>\r\n");
      out.write("	<form method=\"post\" enctype=\"multipart/form-data\" action=\"register\">\r\n");
      out.write("		<table class=\"tb-row\">\r\n");
      out.write("			<colgroup>\r\n");
      out.write("				<col width=\"180px\">\r\n");
      out.write("				<col>\r\n");
      out.write("			</colgroup>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>제목</th>\r\n");
      out.write("				<td><input type=\"text\" name=\"title\"\r\n");
      out.write("					class=\"check-empty form-control\" title=\"제목\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>내용</th>\r\n");
      out.write("				<td><textarea name=\"content\" class=\"check-empty form-control\"\r\n");
      out.write("						title=\"내용\"></textarea></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>첨부파일</th>\r\n");
      out.write("				<td>\r\n");
      out.write("					<div>\r\n");
      out.write("						<label> <input type=\"file\" name=\"file\"\r\n");
      out.write("							class=\"form-control\" id=\"file-multiple\" multiple> <i\r\n");
      out.write("							role=\"button\" class=\"fs-3 fa-regular fa-file\"></i>\r\n");
      out.write("						</label>\r\n");
      out.write("					</div> <!-- 마우스 드래그 드랍으로 파일첨부 처리되게 -->\r\n");
      out.write("					<div class=\"form-control mt-2 py-2 file-drag\">\r\n");
      out.write("						<div class=\"text-center py-3\">첨부할 파일을 마우스로 끌어 오세요</div>\r\n");
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("		<input type=\"hidden\" name=\"writer\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginInfo.userid }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("	</form>\r\n");
      out.write("	<div class=\"btn-toolbar gap-2 my-3 justify-content-center\">\r\n");
      out.write("		<button class=\"btn btn-primary px-4\" id=\"btn-save\">저장</button>\r\n");
      out.write("		<button class=\"btn btn-outline-primary px-4\" onclick=\"history.go(-1)\">취소</button>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script>\r\n");
      out.write("		var fileList = new FileList();\r\n");
      out.write("		\r\n");
      out.write("		// 백틱 사용하기 : ``\r\n");
      out.write("		var name = \"홍길동\";\r\n");
      out.write("		console.log(\"이름은 \" + name + \" 입니다\")\r\n");
      out.write("		console.log(`이름은 ${name} 입니다`)\r\n");
      out.write("		\r\n");
      out.write("		/*  \r\n");
      out.write("		$('.file-drag')\r\n");
      out.write("		.on( 'dragover dragleave drop', function(e){\r\n");
      out.write("			e.preventDefault();\r\n");
      out.write("			//드래그오버시 입력태그에 커서가 있을때처럼 보여지게\r\n");
      out.write("			if( e.type=='dragover' )  	$(this).addClass('drag-over') \r\n");
      out.write("			else 						$(this).removeClass('drag-over')\r\n");
      out.write("		})\r\n");
      out.write("		.on('drop', function(){\r\n");
      out.write("		})\r\n");
      out.write("		 */\r\n");
      out.write("\r\n");
      out.write("		$('#btn-save').click(function() {\r\n");
      out.write("			if (emptyCheck()) {\r\n");
      out.write("				multipleFileUpload();\r\n");
      out.write("				$('form').submit()\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
