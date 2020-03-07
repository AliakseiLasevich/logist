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

        <section class="actions">

            <div class="actions_wrapper">

                <div class="action_item">
                    <a href="${pageContext.request.contextPath}/add_customer" title="add new customer"><img
                            src="${pageContext.request.contextPath}/resources/img/plus.png"></a>
                </div>


                <div class="action_item">

                    <form action="${pageContext.request.contextPath}/customers/filter/" class="filter">
                        <input type="text" placeholder="Filter by name" name="filter">
                        <input type="submit" value="Filter" class="button">
                    </form>

                </div>

            </div>

        </section>

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
                    <th>Edit</th>
                </tr>

                <c:forEach var="tempCustomer" items="${customer}">

                    <c:url var="editLink" value="${pageContext.request.contextPath}/customer_edit">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>

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
                        <td>${tempCustomer.customerInfo.website}</td>
                        <td>
                            <c:if test="${tempCustomer.status == 'active'}">
                                <img src="${pageContext.request.contextPath}/resources/img/green_point.png"
                                     alt="Active">
                            </c:if>
                            <c:if test="${tempCustomer.status != 'active'}">
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
                    <a href="/customers/${i}">${i}</a>
                </c:forEach>
                <a href="${pageContext.request.contextPath}/all_customers">Show all</a>
            </div>
        </div>

    </section>

    <footer>
    </footer>

</section>
</body>
</html>
