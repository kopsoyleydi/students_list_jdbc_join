<%@ page import="tools.Cities" %><%--
  Created by IntelliJ IDEA.
  User: omyrz
  Date: 16.04.2023
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail City</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<%
    Cities city = (Cities) request.getAttribute("city");
    if (city != null){
%>
<div class="container">
    <form action="/CityUpdateServlet" method="post">
        <div class="mb-3">
            <label class="form-label">Name: </label>
            <input type="text" class="form-control" name="name" value="<%=city.getName()%>">
        </div>
        <div class="mb-3">
            <label class="form-label">Code: </label>
            <input type="text" class="form-control" name="code" value="<%=city.getCode()%>">
        </div>
        <input type="hidden" value="<%=city.getId()%>" name="id">
        <button type="submit" class="btn btn-primary">Save</button>
        <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal">
            Delete
        </button>
    </form>
</div>
<div class="modal fade" id="modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Agree</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Закрыть"></button>
            </div>
            <div class="modal-body">
                Are you delete this task?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыть</button>
                <form action="/DeleteCityServlet" method="post">
                    <input type="hidden" name="id" value="<%=city.getId()%>">
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<%
    }
%>
</body>
</html>
