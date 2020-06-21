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
        <div class="header">
            <h2>Hello world</h2>
            <h3>This is a pilot of Masklet</h3>
        </div>
    </div>
    <div class="container">
        <nav class="navbar navbar-expand-sm bg-light navbar-light sticky-top">
            <form:form modelAttribute="addressCommand" class="form-inline">
                <label for="city">광역시/도:</label>&nbsp;
                <form:select path="city" class="form-control mr-sm-3">
                    <form:option value="대구광역시" />
                </form:select>
                <label for="gu">시/군/구: </label>&nbsp;
                <form:select path="gu" class="form-control mr-sm-3">
                    <form:option value="북구" />
                </form:select>
                <label for="dong">읍/면/동: </label>&nbsp;
                <form:select  path="dong" class="form-control mr-sm-3">
                    <form:option value="">--전체--</form:option>
                    <form:option value="복현동" />
                    <form:option value="대현동" />
                    <form:option value="산격동" />
                </form:select>
                <button class="btn btn-success" type="submit">Search</button>
            </form:form>
        </nav>
        <div class="result">
            <div class="result-header">
                <h4>${storesByAddr.address}<br />검색결과: ${storesByAddr.count}</h4>
            </div>
            <div class="result-table">
                <c:if test="${! empty storesByAddr}" >
                    <table class="table table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th><spring:message code="rownum" /></th>
                                <th><spring:message code="pharm.name" /></th>
                                <th><spring:message code="address" /></th>
                                <th><spring:message code="remainStat" /></th>
                                <th><spring:message code="createdAt" /></th>
                            </tr>
                        </thead>
                        <c:forEach var="store" items="${storesByAddr.storesList}" varStatus="status">
                            <tr>
                                <td>${status.index +1 }</td>
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