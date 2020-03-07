<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customers</title>
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

        <form:form action="saveCustomer" modelAttribute="customer" method="post">
<%--            for edit existing customer--%>
<%--            <form:hidden path="id"/>--%>

            <table>
                <tbody>
                <th colspan="2">Add new customer</th>
                <tr>
                    <td><label>Name:</label></td>
                    <td><form:input path="name"/><form:errors path="name" /></td>
                </tr>

                <tr>
                    <td><label>Country:</label></td>
                    <td><form:select path="customerInfo.country">
                        <form:option value="Belarus" label="Belarus"/>
                        <form:option value="Russia" label="Russia"/>
                        <form:option value="Poland" label="Poland"/>
                        <form:option value="Albania" label="Albania"/>
                        <form:option value="Zimbabwe" label="Zimbabwe"/>
                    </form:select></td>
                </tr>

                <tr>
                    <td><label>City:</label></td>
                    <td><form:input path="customerInfo.city"/><form:errors path="customerInfo.city" /></td>
                </tr>

                <tr>
                    <td><label>Address:</label></td>
                    <td><form:input path="customerInfo.address"/><form:errors path="customerInfo.address" /></td>
                </tr>

                <tr>
                    <td><label>Contact person:</label></td>
                    <td><form:input path="customerInfo.contactPerson"/><form:errors path="customerInfo.contactPerson" /></td>
                </tr>
                <tr>
                    <td><label>Phone 1:</label></td>
                    <td><form:input path="customerInfo.phone1"/><form:errors path="customerInfo.phone1" /></td>
                </tr>

                <tr>
                    <td><label>Phone 2:</label></td>
                    <td><form:input path="customerInfo.phone2"/><form:errors path="customerInfo.phone2" /></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="customerInfo.email"/><form:errors path="customerInfo.email" /></td>
                </tr>
                <tr>
                    <td><label>Website:</label></td>
                    <td><form:input path="customerInfo.website"/><form:errors path="customerInfo.website" /></td>
                </tr>


<%--                <tr>--%>
<%--                    <td><label>Status:</label></td>--%>
<%--                    <td><form:select path="status">--%>
<%--                        <form:option value="available" label="Available"/>--%>
<%--                        <form:option value="damaged" label="Damaged"/>--%>
<%--                    </form:select>--%>
<%--                    </td>--%>
<%--                </tr>--%>


<%--                <tr>--%>
<%--                    <td><label></label></td>--%>
<%--                    <td><input type="submit" value="Save customer"></td>--%>
<%--                </tr>--%>
                </tbody>
            </table>
            <input type="submit" value="Save customer">



        </form:form>


        <p>
            <a href="${pageContext.request.contextPath}/customers">Back to customers</a>
        </p>
    </section>


    <footer>

    </footer>

</section>
</body>
</html>
