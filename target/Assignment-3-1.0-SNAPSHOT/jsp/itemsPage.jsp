<%--
  Created by IntelliJ IDEA.
  User: Berikkali
  Date: 16.10.2020
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>Items page</title>
</head>
<body>
    <div class="container">
        <div class="d-flex justify-content-center align-items-center my-2">
            <h1 style="width: auto">Welcome, <c:out value="${signedUser.username}" /></h1>
            <a class="btn btn-dark btn-sm mx-2" href="logout" role="button" style="height: 30px">Log out</a>
        </div>
        <div class="dropdown my-2">
            <button class="btn btn-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Categories
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="categorize?cate=all"/>All</a>
                <c:forEach var="ct" items="${categories}">
                    <a class="dropdown-item" href="categorize?cate=<c:out value="${ct.value}"/>"><c:out value="${ct.value}"/></a>
                </c:forEach>
            </div>
        </div>

        <c:forEach var="item" items="${items}">
            <div class="card my-2">
                <h5 class="card-header"><c:out value="${item.name}"/></h5>
                <div class="card-body">
                    <h5 class="card-title"><c:out value="${item.category}"/></h5>
                    <p class="card-text"><c:out value="${item.price}"/> tg</p>
                    <form method="post" action="addCart">
                        <input class="btn btn-dark" type="submit" value="Add to cart">
                        <input hidden name="itemId" value="<c:out value="${item.id}"/>">
                    </form>
                </div>
            </div>
        </c:forEach>

        <form method="get" action="pay" class="my-2">
            <input class="btn btn-dark" style="width: 5vw" type="submit" value="Pay">
        </form>

    </div>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
