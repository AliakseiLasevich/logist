<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logist</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

        <div id="loginbox" style="width: 200px; margin-left: 200px; border: 1px solid black">

            <div class="panel panel-info">

                <div class="panel-heading">
                    <div class="panel-title"><strong>Please sign in</strong></div>
                </div>

                <div style="padding: 10px" class="panel-body">

                    <!-- Login Form -->
                    <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                               method="POST" class="form-horizontal">

                        <!-- Place for messages: error, alert etc ... -->
                        <div class="form-group">
                            <div class="col-xs-15">
                                <div>

                                    <!-- Check for login error -->

                                    <c:if test="${param.error != null}">

                                        <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                            Invalid username/password.
                                        </div>

                                    </c:if>

                                        <%--                                <c:if test="${param.logout !=null}">--%>
                                        <%--                                    <div class="alert alert-success col-xs-offset-1 col-xs-10">--%>
                                        <%--                                        You have been logged out.--%>
                                        <%--                                    </div>--%>
                                        <%--                                </c:if>--%>

                                </div>
                            </div>
                        </div>

                        <!-- User name -->
                        <div style="margin-bottom: 10px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                            <input type="text" name="username" placeholder="username" class="form-control">
                        </div>

                        <!-- Password -->
                        <div style="margin-bottom: 10px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>

                            <input type="password" name="password" placeholder="password" class="form-control">
                        </div>

                        <!-- Login/Submit Button -->
                        <div style="margin-top: 10px" class="form-group">
                            <div class="col-sm-6 controls">
                                <button type="submit" class="btn btn-success">Login</button>
                            </div>
                        </div>

                    </form:form>
                </div>

            </div>
        </div>


    </section>

    <footer>

    </footer>

</section>
</body>
</html>
