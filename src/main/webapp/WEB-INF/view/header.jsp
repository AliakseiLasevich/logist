<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>
    <title>Logist</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

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
    </div>

    <div class="user_panel">
        <security:authorize access="hasRole('ADMIN')">
            <div class="menu_item">
                <a href="${pageContext.request.contextPath}/admin/panel">
                    <div class="menu_item_wrapper">
                        <img src="${pageContext.request.contextPath}/resources/img/admin.png" alt="admin">
                    </div>
                    Admin
                </a>
            </div>
        </security:authorize>

        <security:authorize access="hasRole('USER')">
            <div class="menu_item">
                <a href="${pageContext.request.contextPath}/user_panel">
                    <div class="menu_item_wrapper">
                        <img src="${pageContext.request.contextPath}/resources/img/user.png" alt="user">
                    </div>
                    <sec:authentication property="principal.username"/>
                </a>
            </div>
        </security:authorize>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <div class="menu_item">
                <form:form action="${pageContext.request.contextPath}/logout" method="post">
                    <input type="image" value="Logout"
                           src="${pageContext.request.contextPath}/resources/img/exit.png" alt="exit"
                           class="exit">
                    Logout
                </form:form>
            </div>
        </c:if>

    </div>

    <div class="logo"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="logo"></div>
    <div class="header_bottom"></div>
</header>