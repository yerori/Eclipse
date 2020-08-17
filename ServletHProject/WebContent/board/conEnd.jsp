<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
$(document).ready(function(){
	$("#btn").on("click",function(){
		location.href="../hotel/hiltonindex.jsp";
		})
	})


</script>
<style>
#container{
	padding:20px;
	margin-left:600px;
}
.dining-area d-padding{
}
#h3{
	text-align:center;
		font-weight: bold;
}
.make-customer-area customar-padding fix{
	width:1000px;
}

</style>
<body>


 	<div id="container">
   		<section class="make-customer-area customar-padding fix">
            <div class="container-fluid p-0">
                <div class="row">
	 				<div class=" col-xl-4 col-lg-4">
                        <div class="customer-caption">
                             <h3 id="h3">코멘트 최종 수정 완료!</h3>
                                <p class="pera-dtails">소중한 의견 감사합니다. 답변이 작성되면, 이메일이나 문자를 확인해 주세요.</p>  
                            <div class="caption-details" align="center">
                                                     
                                <input type="button" class="btn btn1 d-none d-lg-block " id="btn" value="메인으로"  >
                            </div>
                        </div>
                    </div>
                  </div>
                 </div>
               </section> 
			</div>
  
</body>
</html>
<%@ include file="../include/footer.jsp" %>