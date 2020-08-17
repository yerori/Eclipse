<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
</head>
<script type="text/javascript">
    $(document).ready(function () {

    	   $("#updateBtn").click(function(){
        	   if($("#startDate").val()==""){
        		   alert("체크인 날짜를 선택해주세요");
        		   return false;
        	   }
        	   if($("#endDate").val()==""){
        		   alert("체크아웃 날짜를 선택해주세요");
        		   return false;
        	   }
        	 
        	   $("#frm").submit();
        	   alert("예약이 성공적으로 수정되었습니다.결제 페이지로 이동합니다.")
           }) 
           
           
    	$.get()
            $.datepicker.setDefaults($.datepicker.regional['ko']); 
            $( "#startdate" ).datepicker({
                 changeMonth: true, 
                 changeYear: true,
                 nextText: '다음 달',
                 prevText: '이전 달', 
                 dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
                 dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
                 monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 dateFormat: "yy-mm-dd",
                 minDate:0,
                 maxDate: "+2Y",        // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
                 onClose: function( selectedDate ) {    
                      //시작일(startDate) datepicker가 닫힐때
                      //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
                     $("#startDate").datepicker( "option", "minDate", selectedDate );
                 }    
 
            });
            $( "#enddate" ).datepicker({
                 changeMonth: true, 
                 changeYear: true,
                 nextText: '다음 달',
                 prevText: '이전 달', 
                 dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
                 dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
                 monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 dateFormat: "yy-mm-dd",
                 minDate:0,
                 maxDate:"+2Y",                       // 선택할수있는 최대날짜, ( 0 : 오늘 이후 날짜 선택 불가)
                 onClose: function( selectedDate ) {    
                     // 종료일(endDate) datepicker가 닫힐때
                     // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
//                      $("#startDate").datepicker( "option", "minDate", selectedDate );
                	  $("#endDate").datepicker( "option", "minDate", selectedDate );
                 }     
            });  
            
          
    });
</script>
<style>
.btn btn1 d-none d-lg-block{
	width:100px;
}
#btn, #delBtn{
	padding:30px;
	margin: 20px;
	width:100px;
	
}
#container{
	padding:100px;
	margin:100px;
	text-align:center;
	
}

#a{
margin:0 auto;
	text-align:center;
	
}

#box{
	margin:0 auto;
}

#p{
	font-weight: bold;
}

#updateBtn{
	margin:20px;
	width:100px;
}

</style>
<body>


<form action="resupdate" method="post" id="frm">
<input type="hidden" id="id" name="id" value="${resArr.id}">
<input type="hidden" id="gno" name="gno" value="${resArr.gno}">
<input type="hidden" id="rsno" name="rsno" value="${resArr.rsno}">
<input type="hidden" id="occupancy" name="occupancy" value="${resArr.occupancy}">

<div id="container" align=center>
<h3 id="p">${resArr.id }님의 예약 수정 폼</h3><br>
<table id="a" border="1">
<tbody>

 <tr>
 <th>숙박 날짜</th>
 <td><input type="text" id="startdate" name="startdate" value="${resArr.startdate}"></br>~</br>
  <input type="text" id="enddate" name="enddate" value="${resArr.enddate }"></td>
 </tr>

 <tr>
 <th>어른 인원 수</th>
 <td>    <select name="tot_ad" id="tot_ad">
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
         </select>
         <script>
    $("#tot_ad option").each(function(){
    	if($(this).val()=="${resArr.tot_ad }"){
    	$(this).prop("selected",true);
    	}
    })
    </script></td>
 </tr>
 
 <tr>
 <th>아기 인원 수</th>
 <td><select name="tot_ch" id="tot_ch">
 		  <option value="1">0</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
         </select>
          <script>
    $("#tot_ch option").each(function(){
    	if($(this).val()=="${resArr.tot_ch }"){
    	$(this).prop("selected",true);
    	}
    })
    </script>
         </td>
 </tr>
 
 <tr>
 <th>지불 방법</th>
 <td>   <select name="pay" id="pay" >
        <option value="cash">현장에서 카드 결제</option>
        <option value="cash">현장에서 현금 결제</option>
        </select>
       <script>
   		 $("#pay option").each(function(){
    	if($(this).val()=="${resArr.pay }"){
    	$(this).prop("selected",true);
    	}
    })
    </script></td>
 </tr>
 <tr>
 <th>방 종류</th>
 <td>
 	 <select name="rname" id="rname" >
  	  <c:forEach items="${roomArr }" var="room">
    	<option value="${room.rname }">${room.rname }</option>
       </c:forEach>
    </select>
    <script>
    $("#rname option").each(function(){
    	if($(this).val()=="${resArr.rname }"){
    	$(this).prop("selected",true);
    }
    })
    </script>
    
    </td>
 </tr>

<tr>

<td colspan="2" align="center">
  	
   <input type="submit" class="btn btn1 d-none d-lg-block " id="updateBtn" value="변경하기"> 
   <input type="reset" class="btn btn1 d-none d-lg-block " id="btn" value="취소"></td>
</tbody>
</table>
</div>
</form>
</body>
</html>
<%@ include file="../include/footer.jsp" %>