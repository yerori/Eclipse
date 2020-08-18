<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 

 <style>
.h1-slider-caption{
	color:white;
}
.h1{
	font-style: italic;
	color:white;
}
 </style>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Hotel</title>
        <meta name="description" content="">

        <link rel="manifest" href="site.webmanifest">
		<link rel="shortcut icon" type="image/x-icon" href="../hotel/assets/img/favicon.ico">

		<!-- CSS here -->
            <link rel="stylesheet" href="../hotel/assets/css/bootstrap.min.css">
            <link rel="stylesheet" href="../hotel/assets/css/owl.carousel.min.css">
            <link rel="stylesheet" href="../hotel/assets/css/gijgo.css">
            <link rel="stylesheet" href="../hotel/assets/css/slicknav.css">
            <link rel="stylesheet" href="../hotel/assets/css/animate.min.css">
            <link rel="stylesheet" href="../hotel/assets/css/magnific-popup.css">
            <link rel="stylesheet" href="../hotel/assets/css/fontawesome-all.min.css">
            <link rel="stylesheet" href="../hotel/assets/css/themify-icons.css">
            <link rel="stylesheet" href="../hotel/assets/css/slick.css">
            <link rel="stylesheet" href="../hotel/assets/css/nice-select.css">
            <link rel="stylesheet" href="../hotel/assets/css/style.css">
            <link rel="stylesheet" href="../hotel/assets/css/responsive.css">
</head>
<body>

    <header>
        <!-- Header Start -->
       <div class="header-area header-sticky">
            <div class="main-header ">
                <div class="container">
                    <div class="row align-items-center">
                        <!-- logo -->
                        <div class="logomain">
                            <div class="logo">
                               <a href="index.html"><img src="../hotel/assets/img/logo/logohilton.jpg" alt=""></a>
                            </div>
                        </div>
                    <div class="col-xl-8 col-lg-8">
                    
                            <!-- main-menu -->
                            <div class="main-menu f-right d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">                                                                                                                                     
                                        <li><a href="../hotel/hiltonindex.jsp">Home</a></li>
                                        <li><a href="../hotel/about.jsp">About</a></li>
                                        <li><a href="../hotel/rooms.jsp">Rooms</a></li>
                                        <li><a href="../hotel/come.jsp">오시는 길</a></li>                                   
                                        <li><a href="../board/contact.jsp">Contact</a></li>
                                        <c:choose> <%-- <c:if>는 안되더라구요ㅠ --%>                            
                          				  <c:when test="${empty sessionScope.id }">
                             			
                            			  </c:when>
                            
			                            <c:otherwise>
            			                    <li><a href="../hotel/roomsearch">예약</a></li>
                        			     </c:otherwise>
                          				 </c:choose>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                                     
                        <div class="col-xl-2 col-lg-2">
                            <!-- header-btn -->
                            <div class="header-btn">
                            <c:choose> <%-- <c:if>는 안되더라구요ㅠ --%>                            
                            <c:when test="${empty sessionScope.id }">
                             <a href="../hotel/login.jsp" class="btn btn1 d-none d-lg-block ">login</a>
                            </c:when>
                            
                            <c:otherwise>
                             <a href="/ServletHProject/hotel/logout" class="btn btn1 d-none d-lg-block ">logout</a> 
                             </c:otherwise>
                           </c:choose>
                            </div>                        
                        </div>
                  
                        <div class="col-12"> 
                            <div class="mobile_menu d-block d-lg-none">
<!--                             <h1 class="h1">top hotel in the busan</h1> -->
<!--                             <h3 class="h3">Hotel & Resourt</h3> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
       </div>
        <!-- Header End -->
    </header>
		<div class="background">
			<img src="../hotel/assets/img/hero/hilton.jpg" alt="">
		</div>
    