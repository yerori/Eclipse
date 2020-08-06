<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.member.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("utf-8");
MemberDAOImpl dao= MemberDAOImpl.getInstance();
String userid=request.getParameter("userid");
dao.memberDel(userid);
ArrayList<MemberVO> arr = dao.memberList();
int count=dao.memberCount();

// 삭제 후, 원래 카운트에서 삭제된 count로 수정됨
JSONObject mainObject = new JSONObject();

JSONArray jarr = new JSONArray();
for(MemberVO vo : arr){
	
	String mode=vo.getAdmin()==0?"일반회원":"관리자";
	JSONObject obj = new JSONObject();
	obj.put("name",vo.getName());
	obj.put("userid",vo.getUserid());
	obj.put("email",vo.getEmail());
	obj.put("phone",vo.getPhone());
	obj.put("mode",mode);
	jarr.add(obj); //회원data
}	

JSONObject countObj = new JSONObject();
countObj.put("count",count); //회원수

mainObject.put("jarr",jarr);
mainObject.put("cntObj",countObj);

out.println(mainObject.toString());

%>