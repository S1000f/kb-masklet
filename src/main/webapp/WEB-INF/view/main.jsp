<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main</title>
    <!-- Bootstrap 4 -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<style>

</style>
<body>
    <div class="container">
        <h2>Hello world</h2>
        <h3>This is main page of Masklet</h3>
        <div class="result">
            <div class="result-header">
                <h4>${storesByAddr.address}<br />count: ${storesByAddr.count}</h4>
            </div>
            <div class="result-table">
                <c:if test="${! empty storesByAddr}" >
                    <table>
                        <tr>
                            <th><spring:message code="pharm.name" /></th>
                            <th><spring:message code="address" /></th>
                            <th><spring:message code="remainStat" /></th>
                            <th><spring:message code="createdAt" /></th>
                        </tr>
                        <c:forEach var="store" items="${storesByAddr.storesList}">
                        <tr>
                            <td>${store.name}</td>
                            <td>${store.addr}</td>
                            <td>${store.remainStat}</td>
                            <td>${store.createdAt}</td>
                        </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>

