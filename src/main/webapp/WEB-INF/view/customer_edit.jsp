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
    <jsp:include page="header.jsp"/>
    <section class="main">

        <form:form action="saveCustomer" modelAttribute="customer" method="post">

            <%--            for edit existing customer--%>
            <form:hidden path="id"/>

            <table>
                <tbody>
                <th colspan="2">Add/Edit Customer</th>
                <tr>
                    <td><label>Name:</label></td>
                    <td><form:input path="name"/><form:errors path="name"/></td>
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
                    <td><form:input path="customerInfo.city"/><form:errors path="customerInfo.city"/></td>
                </tr>

                <tr>
                    <td><label>Address:</label></td>
                    <td><form:input path="customerInfo.address"/><form:errors path="customerInfo.address"/></td>
                </tr>

                <tr>
                    <td><label>Contact person:</label></td>
                    <td><form:input path="customerInfo.contactPerson"/><form:errors
                            path="customerInfo.contactPerson"/></td>
                </tr>
                <tr>
                    <td><label>Phone 1:</label></td>
                    <td><form:input path="customerInfo.phone1"/><form:errors path="customerInfo.phone1"/></td>
                </tr>

                <tr>
                    <td><label>Phone 2:</label></td>
                    <td><form:input path="customerInfo.phone2"/><form:errors path="customerInfo.phone2"/></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="customerInfo.email"/><form:errors path="customerInfo.email"/></td>
                </tr>
                <tr>
                    <td><label>Website:</label></td>
                    <td><form:input path="customerInfo.website"/><form:errors path="customerInfo.website"/></td>
                </tr>
                <tr>
                    <td><label>Status:</label></td>
                    <td><form:select path="status">
                        <form:option value="active" label="active"/>
                        <form:option value="archive" label="archive"/>
                    </form:select></td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save customer"></td>
                </tr>
                </tbody>
            </table>


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
