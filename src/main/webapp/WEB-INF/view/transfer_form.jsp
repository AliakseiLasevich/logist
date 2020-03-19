<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Cargo Edit</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
<section class="wrapper">
    <jsp:include page="header.jsp"/>

    <section class="main">

        <form:form action="saveTransfer" modelAttribute="transfer" method="post">

            <%--            for edit existing cargos--%>
            <form:hidden path="id"/>

            <table>
                <tbody>
                <th colspan="4">Add/Edit Transfer</th>

                <tr>
                    <td>Cargo:</td>
                    <td>

                        <select name="cargoId">
                            <c:forEach var="tempCargo" items="${cargos}">
                                <option value="${tempCargo.id}">
                                        ${tempCargo.id}, ${tempCargo.customer.name}, ${tempCargo.description}
                                </option>
                            </c:forEach>
                        </select>
                    </td>

                    <td>Partner:</td>
                    <td>
                        <select name="partnerId">
                            <c:forEach var="tempPartner" items="${partners}">
                                <option value="${tempPartner.id}">
                                       ${tempPartner.name}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td><label>Price:</label></td>
                    <td colspan="2"><form:input path="price"/><form:errors path="price"/></td>
                </tr>

                <tr>
                    <td colspan="4"><input type="submit" value="Save transfer"></td>
                </tr>
                </tbody>
            </table>
        </form:form>

        <p>
            <a href="${pageContext.request.contextPath}/transfer">Back to transfer</a>
        </p>
    </section>


    <footer>
    </footer>

</section>
</body>
</html>
