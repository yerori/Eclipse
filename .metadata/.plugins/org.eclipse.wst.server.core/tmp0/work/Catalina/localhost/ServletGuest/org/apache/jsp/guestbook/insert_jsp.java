/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.36
 * Generated at: 2020-08-07 00:07:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.guestbook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1595813213803L));
    _jspx_dependants.put("jar:file:/C:/Users/admin/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ServletGuest/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<!-- ajax 쓰기 위해 src 필요 -->\r\n");
      out.write("\r\n");
      out.write(" <!-- lib에 jstl넣고 이 태그 복붙 -->\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\tgetData(1,\"\",\"\"); //페이지 로드시 전체 리스트 보여주기\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#btnSearch\").on(\"click\",function(){ //검색버튼 클릭\r\n");
      out.write("\t\tgetData(1,$(\"#field\").val(),$(\"#word\").val()); //field,word값 가져오기\r\n");
      out.write("\t})\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t$(\"#send\").click(function(){ //전송버튼 클릭\r\n");
      out.write("\t\tif(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.login}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("){\r\n");
      out.write("\t\t\t//sessionScope.login==null\r\n");
      out.write("\t\t\talert(\"로그인을 하세요\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar name=$(\"#name\").val();\r\n");
      out.write("\t\tvar content=$(\"#content\").val();\r\n");
      out.write("\t\tvar grade=$(\"input:radio[name=grade]:checked\").val(); //radio타입을 ajax함수에서 표현\r\n");
      out.write("\t\tvar postString= \"name=\"+name+\"&content=\"+content+\"&grade=\"+grade;\r\n");
      out.write("\t\t$.ajax({ //콜백함수, 이 화면에 그대로 넣기\r\n");
      out.write("\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\turl:\"create.gb\",\r\n");
      out.write("\t\t\tdata:postString, //{\"name\":$(\"#name\").val()} : json형태\r\n");
      out.write("\t\t\tsuccess:function(d){\r\n");
      out.write("\t\t\t\t$(\"#result\").html(d); //태그가 있으면 html로 가져옴\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tbeforeSend: showRequest, //url가기전에 먼저 처리해랏\r\n");
      out.write("\t\t\terror:function(e){\r\n");
      out.write("\t\t\t\talert(\"error : \"+e);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t})\r\n");
      out.write("});\r\n");
      out.write("function getData(pageNum,field,word){\r\n");
      out.write("\t$.get(\"list.gb\",\r\n");
      out.write("\t\t {\"pageNum\":pageNum,\"field\":field,\"word\":word},\r\n");
      out.write(" \tfunction(d){\r\n");
      out.write("\t\t$(\"#result\").html(d);\r\n");
      out.write("\t})\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function fdelete(num,name){ //매개변수를 2개 둔 이유는 name의 게시물을 삭제하시겠습니까? 때문인듯.\r\n");
      out.write("\tif(confirm(\"[\"+name+\"]의 게시물을 삭제하시겠습니까?\")){\r\n");
      out.write("\t\t$.get(\"delete.gb\",\r\n");
      out.write("\t\t  {\"num\":num,\"name\":name},\r\n");
      out.write("\t\t//$.get(\"delete.gb?num=\"+num, 이케 들고가도됨\r\n");
      out.write("\t\t\tfunction(d){\r\n");
      out.write("\t\t\t $(\"#result\").html(d);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t)\r\n");
      out.write("\t}\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function showRequest(){\r\n");
      out.write("\tif($(\"#name\").val()==\"\"){\r\n");
      out.write("\t\talert(\"이름을 입력하세요\");\r\n");
      out.write("\t\t$(\"#name\").focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif($(\"#content\").val()==\"\"){\r\n");
      out.write("\t\talert(\"내용을 입력하세요\");\r\n");
      out.write("\t\t$(\"#content\").focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif($(\"input:radio[name=grade]:checked\").length==0){\r\n");
      out.write("\t\talert(\"평가를 해주세요\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t//this,contextCount & nameCount\r\n");
      out.write("function textCount(obj,target){ \r\n");
      out.write("\tvar len=$(\"#\"+obj.id).val().length;\r\n");
      out.write("\tif(obj.size==len){\r\n");
      out.write("\t\talert(\"글자수 초과\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t$(\"#\"+target).text(len);\r\n");
      out.write("}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("function fview(num){\r\n");
      out.write("\t$.getJSON(\"view.gb\",{\"num\":num},\r\n");
      out.write("\tfunction (d){ //콜백함수\r\n");
      out.write("\t\tvar htmlStr=\"\";\r\n");
      out.write("\t\thtmlStr +=\"<table>\";\r\n");
      out.write("\t\thtmlStr +=\"<tr>\";\r\n");
      out.write("\t\thtmlStr +=\"<td>이름</td>\";\r\n");
      out.write("\t\thtmlStr +=\"<td>\"+d.name+\"</td>\";\r\n");
      out.write("\t\thtmlStr +=\"</tr>\";\r\n");
      out.write("\t\thtmlStr +=\"<tr>\";\r\n");
      out.write("\t\thtmlStr +=\"<td>내용</td>\";\r\n");
      out.write("\t\thtmlStr +=\"<td>\"+d.content+\"</td>\";\r\n");
      out.write("\t\thtmlStr +=\"</tr>\";\r\n");
      out.write("\t\thtmlStr +=\"<tr>\";\r\n");
      out.write("\t\thtmlStr +=\"<td>작성일</td>\";\r\n");
      out.write("\t\thtmlStr +=\"<td>\"+d.created+\"</td>\";\r\n");
      out.write("\t\thtmlStr +=\"</tr>\";\r\n");
      out.write("\t\thtmlStr +=\"</table>\";\t\t\r\n");
      out.write("\t\t$(\"#view\").html(htmlStr);\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div style=\"margin:20px\">\r\n");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<form method=\"post\" action=\"create.gb\">\r\n");
      out.write("\r\n");
      out.write("<table style=\"margin:20px\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td align=\"center\">글쓴이</td>\t\t\t\t\t\t<!-- onKeyup:글자수증가 -->\r\n");
      out.write("\t<td><input type=\"text\" name=\"name\" id=\"name\" maxlength=\"20\" onKeyup=\"textCount(this,'nameCount')\">\r\n");
      out.write("\t*20글자이내\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- this:nameCount가르킴 -->\r\n");
      out.write("\t(<span id=\"nameCount\" style=\"color:red\">0</span>)\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td align=\"center\">내용</td>\r\n");
      out.write("\t<td><input type=\"text\" name=\"content\" id=\"content\" maxlength=\"70\" onKeyup=\"textCount(this,'contentCount')\">\r\n");
      out.write("\t*70글자이내\r\n");
      out.write("\t(<span id=\"contentCount\" style=\"color:red\">0</span>)\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td align=\"center\">평가</td>\r\n");
      out.write("\t<td><input type=\"radio\" name=\"grade\"  value=\"excellent\" checked=\"checked\">아주잘함(excellent)\r\n");
      out.write("\t<input type=\"radio\" name=\"grade\" value=\"good\">잘함(good)\r\n");
      out.write("\t<input type=\"radio\" name=\"grade\"  value=\"normal\">보통(normal)\r\n");
      out.write("\t<input type=\"radio\" name=\"grade\"  value=\"fail\">노력(fail)</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td colspan=\"2\">\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<input type=\"submit\" value=\"submit전송\">\r\n");
      out.write("\t<input type=\"button\" value=\"ajax전송\" id=\"send\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<br><Br>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("<form name=\"search\" id=\"search\">\r\n");
      out.write(" <select name=\"field\" id=\"field\">\r\n");
      out.write(" <option value=\"name\">이름</option>\r\n");
      out.write(" <option value=\"content\">내용</option>\r\n");
      out.write("</select>\r\n");
      out.write("<input type=\"text\" name=\"word\" id=\"word\">\r\n");
      out.write("<input type=\"button\" value=\"찾기\" id=\"btnSearch\" >\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("<br><br>\r\n");
      out.write("<div id=\"result\" align=\"center\"></div>\r\n");
      out.write("<hr>\r\n");
      out.write("<br/>\r\n");
      out.write("<div id=\"view\" style=\"margin:20px\"></div>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /guestbook/insert.jsp(124,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.login==null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write(" <a href=\"login.jsp\">로그인</a>\r\n");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /guestbook/insert.jsp(128,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.login!=null }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("  ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("님 반갑습니다. /\r\n");
          out.write("  <a href=\"logout.gb\">로그아웃</a>\r\n");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }
}
