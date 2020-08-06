<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.member.model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.member.model.SMemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
request.setCharacterEncoding("utf-8");
SMemberDAOImpl dao = SMemberDAOImpl.getInstance();
String userid=request.getParameter("userid");
dao.memberDel(userid);
ArrayList<MemberDTO> arr = dao.memberList();

JSONObject mainObject = new JSONObject();

JSONArray jarr = new JSONArray();
for(MemberDTO dto : arr){
	String mode = dto.getAdmin()==0?"일반회원":"관리자";
	JSONObject obj = new JSONObject();
	obj.put("name",dto.getName());
	obj.put("userid",dto.getUserid());
	obj.put("email",dto.getEmail());
	obj.put("phone",dto.getPhone());
	obj.put("mode",mode);
	jarr.add(obj);
}
mainObject.put("jarr",jarr);

out.println(mainObject.toString());

%>

</body>
</html>