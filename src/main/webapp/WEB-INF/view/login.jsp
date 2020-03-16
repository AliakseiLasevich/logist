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
    <jsp:include page="header.jsp"/>

    <section class="main">

        <div id="loginbox" style="width: 200px; margin-left: 250px; border: 1px solid black">

            <div class="panel panel-info">

                <div class="panel-heading">
                    <div class="panel-title"><strong>Please sign in</strong></div>
                </div>

                <div style="padding: 10px" class="panel-body">

                    <!-- Login Form -->
                    <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" class="form-horizontal">

                        <!-- Place for messages: error, alert etc ... -->
                        <div class="form-group">
                            <div>
                                <div>
                                    <!-- Check for login error -->
                                    <c:if test="${param.error != null}">
<%--                                        <div class="alert alert-danger col-xs-offset-1 col-xs-10">--%>
                                        <div>
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
