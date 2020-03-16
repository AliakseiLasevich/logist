<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logist</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<section class="wrapper">
    <jsp:include page="header.jsp"/>

    <section class="main">

        <div class="main_page_image">
            <h3>Welcome!</h3>
            <img src="${pageContext.request.contextPath}/resources/img/lorry.jpg" alt="lorry">
        </div>

    </section>

    <footer>

    </footer>

</section>
</body>
</html>
