<%@ page import="tools.Students" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="tools.Cities" %>
<%@ page import="tools.DBManager" %><%--
  Created by IntelliJ IDEA.
  User: omyrz
  Date: 03.04.2023
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <title>Detail</title>
</head>
<body>
<%@include file="header.jsp"%>
<%

  Students students = (Students) request.getAttribute("task");
  if(students != null){

%>
<div class="container">
<form action="/UpdateServlet" method="post">
    <div class="mb-3">
        <label class="form-label">Name: </label>
        <input type="text" class="form-control" name="user" value="<%=students.getUser()%>">
    </div>
    <div class="mb-3">
        <label class="form-label">Surname: </label>
        <input type="text" class="form-control" name="surname" value="<%=students.getSurname()%>">
    </div>
    <div class="mb-3">
        <label class="form-label">Birthdate: </label>
        <input type="date" class="form-control" name="birthdate" value="<%=students.getBirthdate()%>">
    </div>
    <input type="hidden" value="<%=students.getId()%>" name="id">
    <div class="mb-3">
        <label class="form-label">City: </label>
        <select class="form-control" name="city_id">
            <%
                ArrayList<Cities> cities = (ArrayList<Cities>) request.getAttribute("cities");

                if(cities != null){
                    for(Cities c : cities){
            %>
            <option <%=students.getCity().getCode().equals(c.getCode())?"selected":""%> value="<%=c.getId()%>">
                <%=c.getName() + " / " + c.getCode()%>
            </option>
            <%
                    }

                }
            %>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Save</button>
    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal">
        Delete
    </button>
</form>

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
                <form action="/DeleteServlet" method="post">
                    <input type="hidden" name="id" value="<%=students.getId()%>">
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<%
  }
  else{
%>
<h1>404</h1>
<%
    }
%>
</body>
</html>
