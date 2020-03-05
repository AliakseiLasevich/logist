<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <div class="table_wrapper">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Country</th>
                    <th>City</th>
                    <th>Address</th>
                    <th>Contact Person</th>
                    <th>Phone1</th>
                    <th>Phone2</th>
                    <th>Email</th>
                    <th>Website</th>
                    <th>Status</th>


                </tr>

                <c:forEach var="tempCustomer" items="${customer}">

                    <%--            <c:url var="cancelLink" value="/order/admin/cancelOrderForm">--%>
                    <%--                <c:param name="orderId" value="${tempOrder.id}"/>--%>
                    <%--            </c:url>--%>

                    <%--            <c:url var="billForm" value="/order/billFormForDamagedCar">--%>
                    <%--                <c:param name="orderId" value="${tempOrder.id}"/>--%>
                    <%--            </c:url>--%>

                    <tr>
                        <td>${tempCustomer.id}</td>
                        <td><strong>${tempCustomer.name}</strong></td>
                        <td>${tempCustomer.customerInfo.country}</td>
                        <td>${tempCustomer.customerInfo.city}</td>
                        <td>${tempCustomer.customerInfo.address}</td>
                        <td>${tempCustomer.customerInfo.contactPerson}</td>
                        <td>${tempCustomer.customerInfo.phone1}</td>
                        <td>${tempCustomer.customerInfo.phone2}</td>
                        <td>${tempCustomer.customerInfo.email}</td>
                        <td>${tempCustomer.customerInfo.webSite}</td>
                        <td>${tempCustomer.status}</td>

                            <%--                        <td>${tempOrder.busyFrom}</td>--%>
                            <%--                        <td>${tempOrder.busyTo}</td>--%>
                            <%--                        <td>${tempOrder.price}</td>--%>
                            <%--                        <td><c:if test="${tempOrder.valid==1}">Valid</c:if>--%>
                            <%--                            <c:if test="${tempOrder.valid!=1}">Not valid</c:if>--%>
                            <%--                        </td>--%>
                            <%--                        <td><a href="${cancelLink}">Cancel</a></td>--%>
                            <%--                        <td><a href="${billForm}">Bill</a></td>--%>
                    </tr>

                </c:forEach>
            </table>


            <c:forEach var="i" begin="1" end="${totalPages}">
                <a href="/customers/${i}">${i}</a>
            </c:forEach>
        </div>

    </section>

    <footer>

    </footer>

</section>
</body>
</html>
