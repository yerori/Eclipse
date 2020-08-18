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
<style>

#resBtn{
	margin:0 auto;
}
</style>

<script type="text/javascript">

$(document).ready(function () {
	   $("#resBtn").click(function(){

 	
 	   if($("#startDate").val()==""){
 		   alert("체크인 날짜를 선택해주세요");
 		   return false;
 	   }
 	   if($("#endDate").val()==""){
 		   alert("체크아웃 날짜를 선택해주세요");
 		   return false;
 	   }
	  
 		
 	   $("#frm").submit();
    })            
  
           
    	$.get()
            $.datepicker.setDefaults($.datepicker.regional['ko']); 
            $( "#startDate" ).datepicker({
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
            $( "#endDate" ).datepicker({
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

<body>

	
    <!-- Booking Room Start-->
        <div class="booking-area">
            <div class="container">
               <div class="row ">
               <div class="col-12">
                <form action="../reserve/resInsert" id="frm">
 
            
                <div class="booking-wrap d-flex justify-content-between align-items-center">
                 
                    <!-- select in date -->
                    <div class="single-select-box mb-30">
                        <!-- select out date -->
                        <div class="boking-tittle">
                            <span> Check In Date:</span>                            
                        </div>
                        <div class="boking-datepicker">
                      <input type="text" id="startDate" name="startDate">
                      
                        </div>
                   </div>
                    <!-- Single Select Box -->
                    <div class="single-select-box mb-30">
                        <!-- select out date -->
                        <div class="boking-tittle">
                            <span>Check OutDate:</span>
                        </div>
                        <div class="boking-datepicker">
                            <input type="text" id="endDate" name="endDate">
                        </div>
                   </div>
                    <!-- Single Select Box -->
                    <div class="single-select-box mb-30">
                        <div class="boking-tittle">
                            <span>Adults:</span>
                        </div>
                        <div class="select-this">
                           
                                <div class="select-itms">
                                    <select name="tot_ad" id="tot_ad">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                    </select>
                                </div>
                         
                        </div>
                   </div>
                    <!-- Single Select Box -->
                    <div class="single-select-box mb-30">
                        <div class="boking-tittle">
                            <span>Children:</span>
                        </div>
                        <div class="select-this">
                         
                                <div class="select-itms">
                                    <select name="tot_ch" id="tot_ch">
                                    	<option value="0">0</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                    </select>
                                </div>
                           
                        </div>
                   </div>
                    <!-- Single Select Box -->
                    <div class="single-select-box mb-30">
                        <div class="boking-tittle">
                            <span>Rooms:</span>
                        </div>
                        <div class="select-this">
                           
                                <div class="select-itms">
                                    <select name="rname" id="rname" >
                                    <c:forEach items="${roomArr }" var="room">
                                         <option value="${room.rname }">${room.rname }</option>
                                       
                                    
                                    </c:forEach>
                          
                                    </select>
                                </div>
                       
                        </div>
                   </div>
                   
                        <div class="single-select-box mb-30">
                        <div class="boking-tittle">
                            <span>Payment:</span>
                        </div>
                        <div class="select-this">
                           
                                <div class="select-itms">
                                    <select name="pay" id="pay" >
                                       <option value="card">현장에서 카드 결제</option>
                                       <option value="cash">현장에서 현금 결제</option>
                                    
                                    </select>
                                </div>
                       
                        </div>
                   </div>
                    <!-- Single Select Box -->
                    <div class="single-select-box pt-45 mb-30" >
                        <input type="submit" class="btn select-btn" id="resBtn" name="resBtn" value="reservation">
                   </div>
               

                </div>
            </form>
               </div>
               </div>
            </div>
        </div>
    
</body>
</html>
<%@ include file="../include/footer.jsp" %>