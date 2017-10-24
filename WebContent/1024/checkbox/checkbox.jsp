<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:form action="checkbox">
	<s:checkbox name="male"   value="true"  label="남성" />
	<s:checkbox name="female" value="false" label="여성" />
	<s:submit />
</s:form>