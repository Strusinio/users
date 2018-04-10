<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="podstawowy" method="post">
		
		<font size="n">witaj ${model.akutalnieZalogowany.login }</font>
		<p><input type="submit" value="wyloguj" name = "wyloguj"/></p>
		<p><input type="submit" value="Panel premium" name="premium"/></p>
		<p><input type="submit" value="Panel admina" name="admin"/></p>
	</form>
	
</body>
</html>
