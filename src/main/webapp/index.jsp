<%@ page import="java.util.ArrayList" %>
<%@ page import="tools.Students" %>
<%@ page import="tools.Cities" %>
<%@ page import="tools.DBManager" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="head.jsp"%>
    <link rel="stylesheet" href="main.css">
    <title>Students List</title>
</head>
<body>
<%@include file="header.jsp"%>
<table class="table mt-3">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Name</th>
        <th scope="col">Surname</th>
        <th scope="col">Birth-date</th>
        <th scope="col">City</th>
    </tr>
    </thead>
    <%
        ArrayList<Students> students = (ArrayList<Students>) request.getAttribute("students");

        if(students != null){
            for(Students s : students){

    %>
    <tbody>
    <tr>
        <th scope="row"><%=s.getId()%></th>
        <td><%=s.getUser()%></td>
        <td><%=s.getSurname()%></td>
        <td><%=s.getBirthdate()%></td>
        <td><%=s.getCity().getCode()%></td>
        <td><button style="background-color: darkblue; color: white">
            <a href="/DetailServlet?id=<%=s.getId()%>" style="text-decoration: none">DETAIL</a>
        </button></td>
    </tr>
    </tbody>
    <%
        }
        }
    %>
</table>
<!-- Button trigger modal -->
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
                <form action="/add" method="post" class="forum">
                    <div class="mb-3">
                        <label class="form-label">Name</label>
                        <input type="text" class="form-control" name="user">
                        <div  class="form-text">Your name</div>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Surname</label>
                        <input type="text" class="form-control" name="surname">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Deadline</label>
                        <input type="date" class="form-control" name="birthdate">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">City</label>
                        <select class="form-control" name="city_id">
                            <%
                                ArrayList<Cities> cities = (ArrayList<Cities>) request.getAttribute("cities");

                                if(cities != null){
                                    for(Cities c : cities){
                            %>
                            <option value="<%=c.getId()%>">
                                <%=c.getName() + " / " + c.getCode()%>
                            </option>
                            <%
                                }

                            }
                        %>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>