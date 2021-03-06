/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.36
 * Generated at: 2020-07-16 02:05:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.address;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.address.ZipcodeBean;
import java.util.ArrayList;
import com.address.AddressDAO;

public final class zipCheck_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.address.ZipcodeBean");
    _jspx_imports_classes.add("com.address.AddressDAO");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("a:hover{\r\n");
      out.write(" text-decoration:none; color:#000\r\n");
      out.write(" \r\n");
      out.write("}\r\n");
      out.write("a:link{\r\n");
      out.write(" text-decoration:none; color:#000\r\n");
      out.write(" \r\n");
      out.write("}\r\n");
      out.write("a:visited{\r\n");
      out.write(" text-decoration:none; color:#000\r\n");
      out.write(" \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script src = \"https://code.jquery.com/jquery-3.5.1.min.js\"></script> <!-- cdm방식 -->\r\n");


String dong=request.getParameter("dong");

AddressDAO dao = AddressDAO.getInstance();
ArrayList<ZipcodeBean> zarr = dao.zipcodeRead(dong);

      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("// jquery이용\r\n");
      out.write("function dongCheck(){\r\n");
      out.write("\tif($(\"#dong\").val()==\"\"){\r\n");
      out.write("\t\talert(\"동이름을 입력하세요\");\r\n");
      out.write("\t\t$(\"#dong\").focus(); // text type에 커서 움직\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t$(\"#frm\").submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function send(code,sido,gugun,dong,bunji){\r\n");
      out.write("\tvar address =sido+\" \"+gugun+\" \"+dong+\" \"+bunji;\r\n");
      out.write("\topener.document.frm.zipcode.value=code; //호출해주는 것 : opener\r\n");
      out.write("\topener.document.frm.addr.value=address;\r\n");
      out.write("\t\r\n");
      out.write("\tself.close();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form action=\"zipCheck.jsp\" id=\"frm\"> <!-- 안적어 주면 자기 자신,, -->\r\n");
      out.write("<table>\r\n");
      out.write("<tr>\r\n");
      out.write("\r\n");
      out.write("<td>동 이름 입력 : <input type=\"text\" name=\"dong\" id=\"dong\">\r\n");
      out.write("<input type=\"button\" name=\"zipcodre\" value=\"검색\" onclick=\"dongCheck()\"> \r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
 // <% : java를 쓰겠당,,
 if(zarr.isEmpty()){

      out.write("\t \r\n");
      out.write("\t <tr>\r\n");
      out.write("\t <td>검색된 결과가 없습니다.</td>\t \r\n");
      out.write("\t </tr>\r\n");
	 
 }else{

      out.write("\t \r\n");
      out.write("\t <tr>\r\n");
      out.write("\t <td>*검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.</td>\t \r\n");
      out.write("\t </tr>\r\n");
	
	for(ZipcodeBean z : zarr){
		String zip = z.getZipcode();
		String sido = z.getSido();
		String bunji = z.getBunji();
		String gugun = z.getGugun();
		String d = z.getDong();
		
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<!-- ★ JAVASCRIPT에서는 문자열일때 ''  -->\r\n");
      out.write("\t\t <td><a href=\"javascript:send('");
      out.print(zip);
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(sido);
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(gugun);
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(d);
      out.write('\'');
      out.write(',');
      out.write('\'');
      out.print(bunji);
      out.write("')\"> \r\n");
      out.write("\t\t <!-- javascript코드로,, send 함수를 부름 -->\r\n");
      out.write("\t\t ");
      out.print(zip);
      out.print(sido);
      out.print(bunji);
      out.print(gugun);
      out.print(d);
      out.write("</a></td>\r\n");
      out.write("\t\t <!-- bunji에 null값 뜸 -> zipcodebean에 감 -->\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");

	}//for
 }//else

      out.write("\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
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
