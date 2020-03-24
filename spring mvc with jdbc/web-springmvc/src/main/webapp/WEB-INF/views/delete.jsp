<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter Id of the Student to remove </h1>
	${msg }

	<form action="delete" method="post">

		Id : <input type="text" name="id" /><br />
		<input  type="submit" name="submit" value="submit" />

	</form>
</body>
</html>