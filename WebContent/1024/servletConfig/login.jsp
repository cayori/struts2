<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head><title>servletConfig</title></head>
<body>

<s:form action="servletConfigLogin">
	<s:textfield name="id" label="아이디" />
	<s:textfield name="pwd" label="비밀번호" />
	<s:submit />
</s:form>

</body>
</html>