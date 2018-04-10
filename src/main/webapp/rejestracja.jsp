<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN "http;//www.w3.org/TR.html4.loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <form action="rejestracja" method="POST">
	<font size="n">Wypelnij dane</font>
		<p><label><input type="text" id="login" name="login">Login</label></p>
		<p><label><input type="password" id="Haslo" name="haslo">Haslo</label></p>
		<p><label><input type="password" id="potwierdzHaslo" name="potwierdz">potwierdzHaslo</label></p>
		<p><label><input type="text" id="Email" name="Email">Email</label></p>
		<p><input type="submit" value="stworz konto"/></p>
	</form>
	
</body>
</html>
