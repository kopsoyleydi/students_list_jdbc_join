package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tools.Cities;
import tools.DBManager;
import tools.Students;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DetailServlet", value = "/DetailServlet")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Students task = DBManager.getStudent(id);
        ArrayList<Cities> cities = DBManager.getCities();
        request.setAttribute("cities", cities);
        request.setAttribute("task", task);
        request.getRequestDispatcher("/detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
