package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tools.Cities;
import tools.DBManager;
import tools.Students;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddServlet", value = "/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Students student = null;
                String user = request.getParameter("user");
        String surname = request.getParameter("surname");
        String birthdate = request.getParameter("birthdate");
        Long cityId = Long.parseLong(request.getParameter("city_id"));
        Cities city = DBManager.getCity(cityId);
        if(city != null){
            student = new Students(null, user, surname, birthdate,city);
            DBManager.addItem(student);
            response.sendRedirect("/main");
        }
        else {
            response.sendRedirect("error.jsp");
        }
    }
}
