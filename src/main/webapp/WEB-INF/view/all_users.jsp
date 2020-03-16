<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Logist</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<section class="main">

    <div class="table_wrapper">
        <table>
            <tr>
                <th>Id</th>
                <th>User</th>
                <th>Role</th>
            </tr>

            <c:forEach var="tempUser" items="${users}">
                <tr>
                    <td>${tempUser.id}</td>
                    <td>${tempUser.username}</td>
                    <td>${tempUser.authorities}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</body>
</html>
