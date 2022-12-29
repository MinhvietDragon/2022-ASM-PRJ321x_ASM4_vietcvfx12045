<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <%-- Hàm function fn --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value='/CSS/mystyle.css' />" rel="stylesheet" type="text/css"/>
    <link href="<c:url value='/CSS/springstyle.css' />" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>${param.title}</title> <%-- Sẽ tự get tiêu đề của từng trang khi chuyển, sử dụng trang đó. Vì header.jsp là dùng chung --%>
</head>
<body>


<div class="header">
	<center>
		<%@ include file="banner.jsp" %>		
	</center>
	<div style="border: 0px solid; padding: 0px">
		${userWelcome}		
	</div>
</div>

<div class="topnav">
	<div class="navleft" >
		<a href="home.html">Trang chủ</a>
		<a href="#">Xem điện thoại</a>
		<a href="login.html" >Login</a>
		<a href="#">Register</a>
		<a href="#"><input type="image" src="Media/giohang5.png" style="width: 40px; height:24px;"/></a>
		
	</div>
  	<div class="navright">
  		<form name="searchform" action="SearchController2" method="get">  		
		  	<input type="text" name="searchInput" placeholder="What are you looking for?" size="25" value="${mySearch}">
		  	<input type="submit" value="Search"/>
	  	</form>
	</div>		  	 	
</div>
