<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert your name</title>
</head>
<body>
<h2>${retMsg }</h2>
<form action="/STRUTS2/name2/hello.action">
	Input your name: <input type="text" name="name">
	<input type="submit">
</form>

</body>
</html>