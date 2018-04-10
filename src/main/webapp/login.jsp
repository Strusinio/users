<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN "http;//www.w3.org/TR.html4.loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<body>
	<form action="login" method="post"> 
	   
		<p><label><input type="text" id="login" name="login">login</label></p>
		<p><label><input type="password" id="Haslo" name="haslo">haslo</label></p>
		
		<p><input type="submit" value="zaloguj" name="logowanie"/></p>
		<font size="n">nie masz konta?</font>
		<p><input type="submit" value="zarejestruj" name="rejestracja"/></p>
	</form>
	
</body>
</html>