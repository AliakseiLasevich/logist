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

        <ul>
            <li><a href="${pageContext.request.contextPath}/register">Register new user</a> </li>
            <li><a href="${pageContext.request.contextPath}/all_users">Show all users</a> </li>
        </ul>


    </section>

    <footer>

    </footer>

</section>
</body>
</html>
