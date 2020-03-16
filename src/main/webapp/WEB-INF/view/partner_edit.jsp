<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Partner edit</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
<section class="wrapper">
    <jsp:include page="header.jsp"/>

    <section class="main">

        <form:form action="savePartner" modelAttribute="partner" method="post">

            <%--            for edit existing partners--%>
            <form:hidden path="id"/>

            <table>
                <tbody>
                <th colspan="2">Add/Edit Partner</th>
                <tr>
                    <td><label>Name:</label></td>
                    <td><form:input path="name"/><form:errors path="name"/></td>
                </tr>

                <tr>
                    <td><label>Country:</label></td>
                    <td><form:select path="partnerInfo.country">
                        <form:option value="Belarus" label="Belarus"/>
                        <form:option value="Russia" label="Russia"/>
                        <form:option value="Poland" label="Poland"/>
                        <form:option value="Albania" label="Albania"/>
                        <form:option value="Zimbabwe" label="Zimbabwe"/>
                    </form:select></td>
                </tr>

                <tr>
                    <td><label>City:</label></td>
                    <td><form:input path="partnerInfo.city"/><form:errors path="partnerInfo.city"/></td>
                </tr>

                <tr>
                    <td><label>Address:</label></td>
                    <td><form:input path="partnerInfo.address"/><form:errors path="partnerInfo.address"/></td>
                </tr>

                <tr>
                    <td><label>Contact person:</label></td>
                    <td><form:input path="partnerInfo.contactPerson"/><form:errors
                            path="partnerInfo.contactPerson"/></td>
                </tr>
                <tr>
                    <td><label>Phone 1:</label></td>
                    <td><form:input path="partnerInfo.phone1"/><form:errors path="partnerInfo.phone1"/></td>
                </tr>

                <tr>
                    <td><label>Phone 2:</label></td>
                    <td><form:input path="partnerInfo.phone2"/><form:errors path="partnerInfo.phone2"/></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="partnerInfo.email"/><form:errors path="partnerInfo.email"/></td>
                </tr>
                <tr>
                    <td><label>Website:</label></td>
                    <td><form:input path="partnerInfo.website"/><form:errors path="partnerInfo.website"/></td>
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
                    <td><input type="submit" value="Save partner"></td>
                </tr>
                </tbody>
            </table>


        </form:form>


        <p>
            <a href="${pageContext.request.contextPath}/partners">Back to partners</a>
        </p>
    </section>


    <footer>
    </footer>

</section>
</body>
</html>
