<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Transfer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
<section class="wrapper">

    <jsp:include page="header.jsp"/>

    <section class="main">

        <section class="actions">
            <div class="actions_wrapper">

                <div class="action_item">
                    <a href="${pageContext.request.contextPath}/add_transfer" title="add new transfer"><img
                            src="${pageContext.request.contextPath}/resources/img/plus.png"></a>
                </div>
            </div>
            <div class="table_name">Transfer</div>
        </section>

        <div class="table_wrapper">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Partner</th>
                    <th>Cargo</th>
                    <th>Price</th>

                </tr>

                <c:forEach var="tempTransfer" items="${transfers}">

                    <c:url var="editLink" value="${pageContext.request.contextPath}/transfer_edit">
                        <c:param name="transferId" value="${tempTransfer.id}"/>
                    </c:url>

                    <tr>
                        <td>${tempTransfer.id}</td>
                        <td>${tempTransfer.partner.name}</td>
                        <td>${tempTransfer.cargos}</td>
                        <td>${tempTransfer.price}</td>


                    </tr>
                </c:forEach>
            </table>

        </div>
    </section>

    <footer>
    </footer>

</section>


</section>
</body>
</html>
