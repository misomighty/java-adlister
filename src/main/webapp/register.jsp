<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Register!</h1>
    <form method="POST">
        <input type="text" placeholder="username" name="username" value="<c:out value="${param.username}"/>" />
        <input type="text" placeholder="email" name="email" value="<c:out value="${param.email}"/>" />
        <input type="text" placeholder="password" name="password" value="<c:out value="${param.password}"/>" />
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>