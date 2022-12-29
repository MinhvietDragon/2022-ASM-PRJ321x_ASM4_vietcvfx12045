<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     


<c:import url="header.jsp">
	<c:param name="title" value="ASM4 - Login page"></c:param> <%--Set tiêu đề cho header.jsp khi ở trang này (home) --%>
</c:import>


<h2 style="text-align: center; padding: 10px;">Điền thông tin đăng nhập</h2>
      
    <form action="dologin.html" method="post"> <%-- Sẽ gửi lên class servlet DispatcherServlet và điều hướng đến Controller tương ứng --%>

		<table id="loginspring">
			<tr>
				<td>User name:</td>
				<td><input type="text" name="username" value="${username}" maxlength="100"/></td> <%--Đặt required để bắt buộc điền của form, hiện tại không đặt để hiểu cách tự Control --%>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" value="${password}" maxlength="64"/></td>
			</tr>
			<tr>
			<td colspan="2" style="text-align: center; padding: 10px;"><input style="padding: 10px" type="submit" value="LOGIN"/></td>
			</tr>
		</table>

		<p style="text-align: center; padding: 10px;">${message} </p>
	</form>


   
<%@ include file="footer.jsp"%>