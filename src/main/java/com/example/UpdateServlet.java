package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tools.Cities;
import tools.DBManager;
import tools.Students;

import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String user = request.getParameter("user");
        String surname = request.getParameter("surname");
        String birthdate = request.getParameter("birthdate");
        Long city_id = Long.parseLong(request.getParameter("city_id"));

        Cities city = DBManager.getCity(city_id);
        if(city != null){
            Students student = DBManager.getStudent(id);
            student.setUser(user);
            student.setSurname(surname);
            student.setBirthdate(birthdate);
            student.setCity(city);
            DBManager.UpdateStudent(student);
            response.sendRedirect("/main");
        }
        else{
            response.sendRedirect("/error.jsp");
        }

    }
}
