<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- Hiện tại không sử dụng trang này mà để lưu theo hướng dẫn của bài học --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="${pageContext.request.contextPath}/CSS/springstyle.css" rel="stylesheet" type="text/css"/>
	<title>Insert title here</title>
</head>
<body>

<h2 style="text-align: center; padding: 10px;">${message}</h2>

	<table id="loginsuccess">
	        <tr>
	           <td>Name</td>
	           <td>${username}</td>
	        </tr>
	        <tr>
	           <td>password</td>
	           <td>${password}</td>
	        </tr>
	    </table> 
      
</body>
</html>