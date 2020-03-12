<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Cargo</title>
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

        <section class="actions">

            <div class="actions_wrapper">

                <div class="action_item">
                    <a href="${pageContext.request.contextPath}/add_cargo" title="add new cargo"><img
                            src="${pageContext.request.contextPath}/resources/img/plus.png"></a>
                </div>

            </div>

            <div class="table_name">Cargo</div>

        </section>

        <div class="table_wrapper">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Customer</th>
                    <th>Description</th>
                    <th>Code</th>
                    <th>Type</th>
                    <th>Weight</th>
                    <th>LDM</th>
                    <th>Departure_country</th>
                    <th>Destination_country</th>
                    <th>Status</th>
                    <th>Edit</th>
                </tr>

                <c:forEach var="tempCargo" items="${cargos}">

                    <c:url var="editLink" value="${pageContext.request.contextPath}/cargo_edit">
                        <c:param name="cargoId" value="${tempCargo.id}"/>
                    </c:url>

                    <tr>
                        <td>${tempCargo.id}</td>
                        <td>${tempCargo.customer}</td>
                        <td>${tempCargo.description}</td>
                        <td>${tempCargo.cargoInfo.code}</td>
                        <td>${tempCargo.cargoInfo.type}</td>
                        <td>${tempCargo.cargoInfo.weight}</td>
                        <td>${tempCargo.cargoInfo.ldm}</td>
                        <td>${tempCargo.cargoInfo.departureCountry}</td>
                        <td>${tempCargo.cargoInfo.destinationCountry}</td>
                        <td>
                            <c:if test="${tempCargo.status == 'active'}">
                                <img src="${pageContext.request.contextPath}/resources/img/green_point.png"
                                     alt="Active">
                            </c:if>
                            <c:if test="${tempCargo.status != 'active'}">
                                <img src="${pageContext.request.contextPath}/resources/img/orange_point.png"
                                     alt="Archive">
                            </c:if>
                        </td>
                        <td><a href="${editLink}">edit</a></td>
                    </tr>
                </c:forEach>
            </table>

            <div class="table_pagination">
                <c:forEach var="i" begin="1" end="${totalPages}">
                    <a href="/cargo/${i}">${i}</a>
                </c:forEach>
                <a href="${pageContext.request.contextPath}/all_cargos">Show all</a>
            </div>
        </div>
    </section>

    <footer>
    </footer>

</section>
</body>
</html>
