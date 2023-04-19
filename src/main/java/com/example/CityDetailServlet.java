package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tools.Cities;
import tools.DBManager;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CityDetailServlet", value = "/CityDetailServlet")
public class CityDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Cities city = DBManager.getCity(id);
        request.setAttribute("city", city);
        request.getRequestDispatcher("/cityDetail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
