<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logist</title>
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

        <p>
        <h2>Register new user</h2></p>

        <form:form action="registerNewUser" modelAttribute="user" method="post">

            <%--            <form:hidden path="enabled"  />--%>
            <c:if test="${param.error != null}">
                <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                    Invalid username and password.
                </div>

            </c:if>

            <table>
                <tbody>
                <tr>
                    <td><label>Login:</label></td>
                    <td><form:input path="username"/><form:errors path="username"/></td>
                </tr>
                <tr>
                    <td><label>Password:</label></td>
                    <td><form:password path="password"/><form:errors path="password"/></td>
                </tr>

                <tr>
                    <td>Role:</td>
                    <td>
                        <select name="role">
                            <option value="ROLE_USER">User</option>
                            <option value="ROLE_ADMIN">Admin</option>
                        </select>

                    </td>
                </tr>


                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Register" class="save"></td>
                </tr>
                </tbody>
            </table>
        </form:form>


    </section>

    <footer>

    </footer>

</section>
</body>
</html>
