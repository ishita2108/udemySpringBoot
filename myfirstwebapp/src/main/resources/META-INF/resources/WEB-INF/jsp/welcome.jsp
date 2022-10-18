<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
	<%@ include file ="common/header.jspf"%>
		<title> Welcome Page</title>
	</head>
	<body>
	<%@ include file="common/navigation.jspf"%>
		<div class="container">
			<h1>Welcome ${name}</h1>
			<a href="list-todos">Manage</a> your todos
		</div>
		<%@ include file="common/footer.jspf" %>
	</body>
</html>