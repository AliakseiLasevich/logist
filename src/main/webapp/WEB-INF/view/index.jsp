<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logist</title>
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

        <div class="main_page_image">
            <img src="${pageContext.request.contextPath}/resources/img/lorry.jpg" alt="lorry">
        </div>

    </section>

    <footer>

    </footer>

</section>
</body>
</html>
