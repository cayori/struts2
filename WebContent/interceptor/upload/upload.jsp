<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
<title>upload</title>
</head>
<body>

<form action="fileupload.action" method="post" enctype="multipart/form-data" >
	name: <input type="text" name="name"><br>
	age: <input type="text" name="age"><br>
	photo: <input type="file" name="doc"><br>
	<input type="submit">
</form>

</body>
</html>