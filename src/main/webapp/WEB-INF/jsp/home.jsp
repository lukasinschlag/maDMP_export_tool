<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>maDMP Export Tool - Group 4</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
<div class="container" style="margin-top: 48px">
    <h1>maDMP Export Tool - Group 4</h1>
    <br>
    <h2>Available plans</h2>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Plan</th>
            <th scope="col">Description</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${set.getPlanList()}" var="item">
            <spring:url value="/json2/${item.getId()}" var="jsonUrl" />
            <tr>
                <th scope="row">${item.getId()}</th>
                <td>${item.getTitle()}</td>
                <td>${item.getDescription()}</td>
                <td>
                    <button class="btn btn-default" onclick="location.href='${jsonUrl}'"><i class="fa fa-download"></i> Download maDMP</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>