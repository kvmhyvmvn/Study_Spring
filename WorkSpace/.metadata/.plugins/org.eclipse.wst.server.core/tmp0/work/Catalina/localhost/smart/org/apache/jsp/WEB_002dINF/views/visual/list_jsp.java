/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.75
 * Generated at: 2023-07-17 08:56:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.visual;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<style>\r\n");
      out.write("	#legend span {width:44px; height:17px; margin-right: 5px}\r\n");
      out.write("	#legend li {display: flex; align-items: center;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h3 class=\"my-4\">사원정보분석 시각화</h3>\r\n");
      out.write("	<ul class=\"nav nav-tabs\">\r\n");
      out.write("		<li class=\"nav-item\"><a class=\"nav-link active\">부서원수</a></li>\r\n");
      out.write("		<li class=\"nav-item\"><a class=\"nav-link\">채용인원수</a></li>\r\n");
      out.write("		<li class=\"nav-item\"><a class=\"nav-link\">테스트1</a></li>\r\n");
      out.write("		<li class=\"nav-item\"><a class=\"nav-link\">테스트2</a></li>\r\n");
      out.write("	</ul>\r\n");
      out.write("\r\n");
      out.write("	<div id='tab-content' class=\"m-md-w m-lg-3\" style='height: 520px'>\r\n");
      out.write("		<canvas id=\"chart\" class=\"h-100 m-auto\"></canvas>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("	<script src=\"https://cdn.jsdelivr.net/npm/chart.js/dist/chart.umd.js\"></script> <!-- 차트라이브러리 -->\r\n");
      out.write("	<script src=\"https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels\"></script> <!-- 데이터라벨 -->\r\n");
      out.write("	<script src=\"https://cdn.jsdelivr.net/npm/chartjs-plugin-autocolors@0.2.2/dist/chartjs-plugin-autocolors.min.js\"></script>\r\n");
      out.write("	<script>\r\n");
      out.write("		Chart.defaults.font.size = 16;\r\n");
      out.write("\r\n");
      out.write("		Chart.defaults.set('plugins.legend', {\r\n");
      out.write("			position : 'bottom', // 범례위치\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("		Chart.register(ChartDataLabels); // Register the plugin to all charts:\r\n");
      out.write("		Chart.register(window['chartjs-plugin-autocolors']); // All charts autocolors\r\n");
      out.write("\r\n");
      out.write("		// 데이터라벨 default 적용 지정\r\n");
      out.write("		Chart.defaults.set('plugins.datalabels', {\r\n");
      out.write("			anchor : 'end', // 데이터 위치\r\n");
      out.write("			align : 'start', // 앵커 기준으로 한 위치\r\n");
      out.write("			offset : -20, // 얼마나 떨어져있게 할 것인지\r\n");
      out.write("			color : '#000', // 폰트 색상\r\n");
      out.write("			font : {\r\n");
      out.write("				weight : 'bold'\r\n");
      out.write("			}, // 굵기\r\n");
      out.write("		})\r\n");
      out.write("\r\n");
      out.write("		$('ul.nav-tabs li').on({\r\n");
      out.write("			'click' : function() {\r\n");
      out.write("				$('ul.nav-tabs li a').removeClass('active');\r\n");
      out.write("				$(this).children('a').addClass('active');\r\n");
      out.write("\r\n");
      out.write("				var idx = $(this).index();\r\n");
      out.write("				if (idx == 0)\r\n");
      out.write("					department(); //부서원수 조회\r\n");
      out.write("				else if (idx == 1)\r\n");
      out.write("					hirement(); //채용인원수 조회\r\n");
      out.write("			},\r\n");
      out.write("\r\n");
      out.write("			'mouseover' : function() {\r\n");
      out.write("				$(this).addClass('shadow');\r\n");
      out.write("			},\r\n");
      out.write("\r\n");
      out.write("			'mouseleave' : function() {\r\n");
      out.write("				$(this).removeClass('shadow');\r\n");
      out.write("			},\r\n");
      out.write("		})\r\n");
      out.write("\r\n");
      out.write("		// 부서원수 조회\r\n");
      out.write("		function department() {\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url : 'department',\r\n");
      out.write("			}).done(function(response) {\r\n");
      out.write("				console.log(response)\r\n");
      out.write("				var info = {};\r\n");
      out.write("				info.category = [], info.datas = [], info.colors = [];\r\n");
      out.write("				$(response).each(function() {\r\n");
      out.write("					info.category.push(this.DEPARTMENT_NAME);\r\n");
      out.write("					info.datas.push(this.COUNT);\r\n");
      out.write("					// 부서원수에 따라 색상 적용 : 0~10미만, 10~20미만, ... \r\n");
      out.write("					info.colors.push(colors[Math.floor(this.COUNT/10)]);\r\n");
      out.write("				})\r\n");
      out.write("				console.log(info);\r\n");
      out.write("				// barChart(info);\r\n");
      out.write("				// lineChart(info);\r\n");
      out.write("				donutChart(info);\r\n");
      out.write("			})\r\n");
      out.write("			// sampleChart();\r\n");
      out.write("		}\r\n");
      out.write("		var visual;\r\n");
      out.write("		// 도넛/파이그래프\r\n");
      out.write("		function donutChart(info) {\r\n");
      out.write("			$('#tab-content').css('height', '550');\r\n");
      out.write("			\r\n");
      out.write("			//  각 수치데이터에 대한 백분율 구하기\r\n");
      out.write("			var sum = 0;\r\n");
      out.write("			$(info.datas).each(function(){\r\n");
      out.write("				sum += this;\r\n");
      out.write("			})\r\n");
      out.write("			// 배열정보로 새로운 배열정보를 만들어주는 함수 : map\r\n");
      out.write("			info.pct = info.datas.map(function( data ){\r\n");
      out.write("				return Math.round(data / sum * 10000) / 100; // 20.54\r\n");
      out.write("			}) \r\n");
      out.write("			visual = new Chart($('#chart'), {\r\n");
      out.write("				type: 'doughnut',\r\n");
      out.write("				data: {\r\n");
      out.write("					labels: info.category,\r\n");
      out.write("					datasets : [{\r\n");
      out.write("						label : '부서원수',\r\n");
      out.write("						data : info.datas,\r\n");
      out.write("						hoverOffset: 5,  // 마우스 올렸을 때 데이터 조각이 offset되는 정도\r\n");
      out.write("					}]\r\n");
      out.write("				},\r\n");
      out.write("				options: {\r\n");
      out.write("					cutout: '70%', // 내부원을 몇 % 잘라낼것인지, 0:파이,\r\n");
      out.write("					maintainAspectRatio : false, // 크기 조정시 캔버스 가로세로 비율 유지X\r\n");
      out.write("					responsive : true, // 컨테이너 크기 변경시 캔버스 크기 조정X\r\n");
      out.write("					plugins: {\r\n");
      out.write("						autocolors: {mode: 'data'},\r\n");
      out.write("						datalabels : {\r\n");
      out.write("							anchor: 'middle', // 도넛조각 내부에 데이터 위치하게\r\n");
      out.write("							formatter: function(value, item) {\r\n");
      out.write("								return `${value}명(${info.pct[item.dataIndex]}%)`;\r\n");
      out.write("							}\r\n");
      out.write("						}\r\n");
      out.write("					}\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		// 선 그래프\r\n");
      out.write("		function lineChart(info){\r\n");
      out.write("			$('#tab-content').css('height', '540');\r\n");
      out.write("			visual = new Chart($('#chart'), {\r\n");
      out.write("				type : 'line',\r\n");
      out.write("				data: {\r\n");
      out.write("					labels: info.category,\r\n");
      out.write("					datasets : [{\r\n");
      out.write("						label : '부서원수',\r\n");
      out.write("						data : info.datas,\r\n");
      out.write("						borderColor: '#0000ff', // 그래프선, point테두리에 적용\r\n");
      out.write("						tension: 0, // 0: 완전 꺾은 선, 1: 곡선\r\n");
      out.write("						pointRadius: 5, // point 반지름\r\n");
      out.write("						pointBackgroundColor: '#ff0000',\r\n");
      out.write("					}]\r\n");
      out.write("				},\r\n");
      out.write("				options : {\r\n");
      out.write("					maintainAspectRatio : false, // 크기 조정시 캔버스 가로세로 비율 유지X\r\n");
      out.write("					responsive : false, // 컨테이너 크기 변경시 캔버스 크기 조정X\r\n");
      out.write("					layout : {\r\n");
      out.write("						padding : { top : 30 }\r\n");
      out.write("					},\r\n");
      out.write("					plugins : {\r\n");
      out.write("						legend: { display: false }, //기본 범례 안 보이게\r\n");
      out.write("						datalabels : {\r\n");
      out.write("							formatter : function(value) {\r\n");
      out.write("								// return value + '명';\r\n");
      out.write("								return `${value}명`;\r\n");
      out.write("							}\r\n");
      out.write("						},\r\n");
      out.write("					},\r\n");
      out.write("					scales : {\r\n");
      out.write("						y : {\r\n");
      out.write("							beginAtZero : true,\r\n");
      out.write("							title: {text: '부서별 사원수', display: true}\r\n");
      out.write("						}\r\n");
      out.write("					},\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		// 막대그래프\r\n");
      out.write("		function barChart(info) {\r\n");
      out.write("			$('#tab-content').css('height', '520');\r\n");
      out.write("			visual = new Chart($('#chart'), {\r\n");
      out.write("				type : 'bar',\r\n");
      out.write("				data : {\r\n");
      out.write("					labels : info.category,\r\n");
      out.write("					datasets : [{\r\n");
      out.write("						label : '부서원수',\r\n");
      out.write("						data : info.datas,\r\n");
      out.write("						borderWidth : 2,\r\n");
      out.write("						barPercentage : 0.5,\r\n");
      out.write("						backgroundColor: info.colors,\r\n");
      out.write("					}]\r\n");
      out.write("				},\r\n");
      out.write("				options : {\r\n");
      out.write("					maintainAspectRatio : false, // 크기 조정시 캔버스 가로세로 비율 유지X\r\n");
      out.write("					responsive : false, // 컨테이너 크기 변경시 캔버스 크기 조정X\r\n");
      out.write("					layout : {\r\n");
      out.write("						padding : {\r\n");
      out.write("							top : 30,\r\n");
      out.write("							bottom : 20\r\n");
      out.write("						}\r\n");
      out.write("					},\r\n");
      out.write("					plugins : {\r\n");
      out.write("						legend: { display: false }, //기본 범례 안 보이게\r\n");
      out.write("						datalabels : {\r\n");
      out.write("							formatter : function(value) {\r\n");
      out.write("								// return value + '명';\r\n");
      out.write("								return `${value}명`;\r\n");
      out.write("							}\r\n");
      out.write("						},\r\n");
      out.write("						/* autocolors: { // 자동색상 적용하는 경우\r\n");
      out.write("							mode: 'data' \r\n");
      out.write("						},*/\r\n");
      out.write("					},\r\n");
      out.write("					scales : {\r\n");
      out.write("						y : {\r\n");
      out.write("							beginAtZero : true,\r\n");
      out.write("							title: {text: '부서별 사원수', display: true}\r\n");
      out.write("						}\r\n");
      out.write("					},\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("			makeLegend();\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		// 데이터 수치 범위에 해당하는 범례 만들기\r\n");
      out.write("		function makeLegend() {\r\n");
      out.write("			var tag = \r\n");
      out.write("			`<ul class=\"row d-flex justify-content-center m-0 mt-4 p-0 small\" id='legend'>`;\r\n");
      out.write("			\r\n");
      out.write("			for(var no=0; no<=6; no++) {\r\n");
      out.write("				tag +=\r\n");
      out.write("					`<li class=\"col-auto\"><span></span><font>${no*10} ~ ${no*10+9}명</font></li>`;\r\n");
      out.write("		}\r\n");
      out.write("			tag +=\r\n");
      out.write("			 `<li class=\"col-auto\"><span></span><font>${no*10}명이상</font></li>\r\n");
      out.write("			 </ul>`;\r\n");
      out.write("			 $('#tab-content').after(tag);\r\n");
      out.write("			 $('#legend span').each(function(idx, item){\r\n");
      out.write("				 $(this).css('background-color', colors[idx]);\r\n");
      out.write("			 })\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		// 데이터 수치의 범위에 따라 지정할 색상\r\n");
      out.write("		var colors = ['#a8eb34', '#9e8ed4', '#8ed4ac', '#d5f576', '#f576af', '#f5d776', '#f58d76', '#57d4b9', '#d5b0f7', '#f5517f'];\r\n");
      out.write("\r\n");
      out.write("		// 브라우저크기 변경시 차트크기 처리\r\n");
      out.write("		$(window).resize(function() {\r\n");
      out.write("			var small = $('#tab-content').width() < 1000 ? true : false;\r\n");
      out.write("			if(visual.config.type=='doughnut') {\r\n");
      out.write("				if(small){\r\n");
      out.write("					$('#chart').css('width', $('#tab-content').width());\r\n");
      out.write("				}\r\n");
      out.write("			} else {\r\n");
      out.write("				visual.options.responsive = small; // 컨테이너 크기 변경시 캔버스 크기 조정할건지 적용\r\n");
      out.write("				$('#chart').css('width', small ? $('#tab-content').width : 1000);\r\n");
      out.write("			}\r\n");
      out.write("		})\r\n");
      out.write("\r\n");
      out.write("		function sampleChart(){\r\n");
      out.write("			new Chart( $('#chart') , {\r\n");
      out.write("			    type: 'bar',\r\n");
      out.write("			    data: {\r\n");
      out.write("			      labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],\r\n");
      out.write("			      datasets: [{\r\n");
      out.write("			        label: '# of Votes',\r\n");
      out.write("			        data: [12, 19, 3, 5, 2, 3],\r\n");
      out.write("			        borderWidth: 1\r\n");
      out.write("			      }]\r\n");
      out.write("			    },\r\n");
      out.write("			    options: {\r\n");
      out.write("			    	plugins: {\r\n");
      out.write("			            legend: {\r\n");
      out.write("			                labels: {\r\n");
      out.write("			                    font: {\r\n");
      out.write("			                        size: 14\r\n");
      out.write("			                    }\r\n");
      out.write("			                }\r\n");
      out.write("			            }\r\n");
      out.write("			        } ,\r\n");
      out.write("			        \r\n");
      out.write("			      scales: {\r\n");
      out.write("			        y: {\r\n");
      out.write("			          beginAtZero: true\r\n");
      out.write("			        }\r\n");
      out.write("			      }\r\n");
      out.write("			    }\r\n");
      out.write("			  });\r\n");
      out.write("			\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		// 채용 인원수 조회\r\n");
      out.write("		function hirement() {\r\n");
      out.write("\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		$(function() {\r\n");
      out.write("			$('ul.nav-tabs li').eq(0).trigger('click');\r\n");
      out.write("		})\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
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
