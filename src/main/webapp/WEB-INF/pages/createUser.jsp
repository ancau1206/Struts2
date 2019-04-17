<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<title>Đăng kí</title>

	<s:head/>
</head>

<body>

	<jsp:include page="_menu.jsp" />


	<h2>Create User</h2>




	<s:form action="create" method="post" validate="true" >
		<s:textfield name="username" label="UserName" size="20" />
		<s:password name="password" label="Password" size="20" />
		<s:password name="confirm" label="Confirm Password" size="20" />
		<s:checkbox name="active" label="Active" ></s:checkbox>
		<s:submit method="execute"  value="Create" align="center" />
	</s:form>
</body>

</html>