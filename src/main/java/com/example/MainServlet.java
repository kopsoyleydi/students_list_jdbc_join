package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tools.Cities;
import tools.DBManager;
import tools.Students;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MainServlet", value = "/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Students> students = DBManager.getStudents();
        request.setAttribute("students", students);
        ArrayList<Cities> cities = DBManager.getCities();
        if(cities != null){
            request.setAttribute("cities", cities);
        }
        else{
            response.sendRedirect("/");
        }

        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
