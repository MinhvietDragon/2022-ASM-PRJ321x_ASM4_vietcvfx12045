<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Page - ASM4PRJ</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="${pageContext.request.contextPath}/CSS/adminstyle.css" rel="stylesheet" type="text/css">	

</head>

<body>

<div id="adminwelcome">
	
	<form action="logout.html" method="get">
		<input type="hidden" name="testTruyenModelMap" value="${username}"> <%--Vì ModelMap chỉ truyền xong đến đây là kết thúc nên muốn truyền nó 1 lần nữa thì phải đặt chỗ để truyền tiếp --%>
		
		Welcome Admin: ${username}
		<input type="submit" value="Logout">
	</form>
</div>

<hr>

<div class="containeradmin">
	<div class="adminleft">
		<h2 style="background-color: rgb(165, 0, 0)">2022 team</h2>
		<a href="#"><p>Dashboard</p></a>
		<a href="#"><p>Staff Manager</p></a>
	</div>
	
	<div class="adminright">
		<img src="${pageContext.request.contextPath}/Media/BANNER1.png" style="width:100%">
		<table class="admintable">
			<caption><h2>Thông tin bán hàng</h2></caption>
			<tr>
				<th>Thời gian hôm nay</th>
				<th>Tổng số đơn hàng hiện tại</th>
				<th>Tổng số sản phẩm đã đặt hàng</th>
				<th>Số lượng tài khoản đăng ký</th>
			</tr>
			<tr>
				<td>${NgayHomNay}</td>
				<td>${soLuongDonHang}</td>
				<td>code here</td>
				<td>code here</td>
			</tr>	
		</table>
	</div>

</div>
</body>
</html>