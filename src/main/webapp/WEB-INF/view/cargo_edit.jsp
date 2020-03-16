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

        <form:form action="saveCargo" modelAttribute="cargo" method="post">

            <%--            for edit existing cargos--%>
            <form:hidden path="id"/>

            <table>
                <tbody>
                <th colspan="2">Add/Edit Cargo</th>

                <tr>
                    <td>Customer:</td>
                    <td>
                        <form:select path="customer">
                            <c:forEach var="tempCustomer" items="${customers}">
                                <form:option value="${tempCustomer}" label="${tempCustomer.name}"/>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>


                <tr>
                    <td><label>Description:</label></td>
                    <td><form:input path="description"/><form:errors path="description"/></td>
                </tr>

                <tr>
                    <td><label>Departure country:</label></td>
                    <td><form:select path="cargoInfo.departureCountry">
                        <form:option value="Belarus" label="Belarus"/>
                        <form:option value="Russia" label="Russia"/>
                        <form:option value="Poland" label="Poland"/>
                        <form:option value="Albania" label="Albania"/>
                        <form:option value="Zimbabwe" label="Zimbabwe"/>
                    </form:select></td>
                </tr>

                <tr>
                    <td><label>Destination country:</label></td>
                    <td><form:select path="cargoInfo.destinationCountry">
                        <form:option value="Belarus" label="Belarus"/>
                        <form:option value="Russia" label="Russia"/>
                        <form:option value="Poland" label="Poland"/>
                        <form:option value="Albania" label="Albania"/>
                        <form:option value="Zimbabwe" label="Zimbabwe"/>
                    </form:select></td>
                </tr>

                <tr>
                    <td><label>Code:</label></td>
                    <td><form:input path="cargoInfo.code"/><form:errors path="cargoInfo.code"/></td>
                </tr>

                <tr>
                    <td><label>Type:</label></td>
                    <td><form:input path="cargoInfo.type"/><form:errors path="cargoInfo.type"/></td>
                </tr>
                <tr>
                    <td><label>Weight:</label></td>
                    <td><form:input path="cargoInfo.weight"/><form:errors path="cargoInfo.weight"/></td>
                </tr>

                <tr>
                    <td><label>LDM:</label></td>
                    <td><form:input path="cargoInfo.ldm"/><form:errors path="cargoInfo.ldm"/></td>
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
                    <td><input type="submit" value="Save cargo"></td>
                </tr>
                </tbody>
            </table>


        </form:form>


        <p>
            <a href="${pageContext.request.contextPath}/cargo">Back to cargo</a>
        </p>
    </section>


    <footer>
    </footer>

</section>
</body>
</html>
