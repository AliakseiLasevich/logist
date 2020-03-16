<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<section class="wrapper">
    <jsp:include page="header.jsp"/>

    <section class="main">

        <a href="${pageContext.request.contextPath}/register">Register new user</a><br>
        <a href="${pageContext.request.contextPath}/allUsers">Show all users</a>


    </section>

    <footer>

    </footer>

</section>
</body>
</html>
