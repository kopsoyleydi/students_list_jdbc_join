<%@ page import="tools.Cities" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: omyrz
  Date: 16.04.2023
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>City Table</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<%
    String error = request.getParameter("error");
    if(error != null){
%>
<div class="alert alert-danger d-flex align-items-center" role="alert">
    <svg class="bi flex-shrink-0 me-2" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
    <div>
        Ключи связанны, вы не можете удалить.
    </div>
</div>
<%
    }
%>
<div class="container">
    <table class="table mt-3">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Birth-date</th>
        </tr>
        </thead>
        <%

            ArrayList<Cities> cities = (ArrayList<Cities>) request.getAttribute("cities");

            if(cities != null){
                for(Cities s : cities){

        %>
        <tbody>
        <tr>
            <th scope="row"><%=s.getId()%></th>
            <td><%=s.getName()%></td>
            <td><%=s.getCode()%></td>
            <td><button style="background-color: darkblue; color: white">
                <a href="/CityDetailServlet?id=<%=s.getId()%>" style="text-decoration: none">DETAIL</a>
            </button></td>
        </tr>
        </tbody>
        <%
                }
            }
            else{
        %>
        <h1>404</h1>
        <%
            }
        %>
    </table>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addStudent">
        Add Student
    </button>

    <!-- Modal -->
    <div class="modal fade" id="addStudent" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Add Student</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/add_city" method="post" class="forum">
                        <div class="mb-3">
                            <label class="form-label">Name</label>
                            <input type="text" class="form-control" name="name">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Code</label>
                            <input type="text" class="form-control" name="code">
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
