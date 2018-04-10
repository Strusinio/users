<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
	 <table>
            <tr>
            <th>Login</th>
            <th>Uprawnienie</th>
            <th>Akcja</th>
            </tr>
            <c:forEach items="${uzytkownicy}" var="uzytkownik">
            <tr>
                <td>${uzytkownik.login }</td>
                <td>${uzytkownik.uprawnienie }</td>
                <td>
                	<form action="admin" method="POST">
                        <input type="submit" value="zmien uprawnienie"/>
                        <input type="hidden" name="loginDoZmiany" value="${uzytkownik.login}" />
                     </form>
                </td>
     
            </tr>
        </c:forEach>
    </table>
	
</body>
</html>
