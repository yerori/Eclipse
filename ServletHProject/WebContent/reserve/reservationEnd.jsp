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

	margin-left:600px;
}
.dining-area d-padding{
}
#p{
	text-align:center;
	font-weight: bold;

}
.make-customer-area customar-padding fix{
	width:1000px;
}

</style>
<body>
	<form>
	
 	<div id="container">
   		<section class="make-customer-area customar-padding fix">
            <div class="container-fluid p-0">
                <div class="row">
	 				<div class=" col-xl-4 col-lg-4">
                        <div class="customer-caption">
                             <h3 id="p">예약 완료 !</h3>
                                <p class="pera-dtails"> 예약해주셔서 감사합니다. </br>예약에 대한 자세한 안내는 email이나 문자로 발송해드렸습니다. </p>  
                              <div class="caption-details" align="center">                                                     
                                <input type="button" class="btn btn1 d-none d-lg-block " id="btn" value="처음으로" >
                            </div>
                        </div>
                    </div>
                  </div>
                 </div>
               </section> 
			</div>
      </form>   
</body>
</html>
<%@ include file="../include/footer.jsp" %>