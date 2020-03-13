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
    <header>
        <div class="menu_wrapper">
            <div class="menu_item">
                <a href="${pageContext.request.contextPath}/customers">
                    <div class="menu_item_image">
                        <img src="${pageContext.request.contextPath}/resources/img/customer.png" alt="customers">
                    </div>
                    Customers
                </a>
            </div>

            <div class="menu_item">
                <a href="${pageContext.request.contextPath}/partners">
                    <div class="menu_item_wrapper">
                        <img src="${pageContext.request.contextPath}/resources/img/partner.png" alt="partners">
                    </div>
                    Partners
                </a>
            </div>

            <div class="menu_item">
                <a href="${pageContext.request.contextPath}/cargo">
                    <div class="menu_item_wrapper">
                        <img src="${pageContext.request.contextPath}/resources/img/cargo.png" alt="cargo">
                    </div>
                    Cargo
                </a>
            </div>

            <div class="menu_item">
                <a href="${pageContext.request.contextPath}/transfer">
                    <div class="menu_item_wrapper"><img
                            src="${pageContext.request.contextPath}/resources/img/transfer.png"
                            alt="transfer">
                    </div>
                    Transfer
                </a>
            </div>

            <div class="menu_item">
                <a href="${pageContext.request.contextPath}/bill">
                    <div class="menu_item_wrapper">
                        <img src="${pageContext.request.contextPath}/resources/img/bill.png" alt="bill">
                    </div>
                    Bills
                </a>
            </div>
        </div>

        <div class="logo"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="logo"></div>
        <div class="header_bottom"></div>
    </header>
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
                        <form:select path="cargos">
                            <c:forEach var="tempCargo" items="${cargos}">
                                <form:option value="${tempCargo.id}" label="${tempCargo.id}, ${tempCargo.customer.name}, ${tempCargo.description}"/>
                            </c:forEach>
                        </form:select>
                    </td>

                    <td>Partner:</td>
                    <td>
                        <form:select path="partner">
                            <c:forEach var="tempPartner" items="${partners}">
                                <form:option value="${tempPartner.id}" label="${tempPartner.name}"/>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>
                    <%--                <tr>--%>
                    <%--                   --%>
                    <%--                </tr>--%>

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
