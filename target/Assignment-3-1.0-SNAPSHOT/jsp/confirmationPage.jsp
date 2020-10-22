<%--
  Created by IntelliJ IDEA.
  User: Berikkali
  Date: 18.10.2020
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>Confirmation</title>
</head>
<body>
    <div class="container">
        <h1 class="mx-auto text-center my-4" style="width: auto">This is confirmation page</h1>

        <div class="alert alert-dark my-2">
            <h4 class="mx-auto text-center" style="width: auto">Your total count of visits of the website: <c:out value="${count}" /></h4>
            <h4 class="mx-auto text-center" style="width: auto">Your session creation time: <c:out value="${creation}" /></h4>
            <h4 class="mx-auto text-center" style="width: auto">Your session last access time: <c:out value="${lastAccess}" /></h4>
        </div>

        <c:forEach var="item" items="${selectedItems}">
            <div class="card my-2">
                <h5 class="card-header"><c:out value="${item.name}"/></h5>
                <div class="card-body">
                    <h5 class="card-title"><c:out value="${item.category}"/></h5>
                    <p class="card-text"><c:out value="${item.price}"/> tg</p>
                </div>
            </div>
        </c:forEach>

        <div class="alert alert-dark my-2 mx" role="alert" style="height: 7vh">
            <div class="d-flex justify-content-between">
                <h3 class="text-left align-middle" style="width: 20vw">Total price: <c:out value="${total}" /> tg</h3>
                <form method="post" action="confirm" class="float-right align-middle">
                    <input class="btn btn-dark float-right" type="submit" value="Confirm">
                </form>
            </div>
        </div>
    </div>

</body>
</html>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
