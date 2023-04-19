package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tools.Cities;
import tools.DBManager;

import java.io.IOException;

@WebServlet(name = "AddCityServlet", value = "/add_city")
public class AddCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cities city = null;
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        city = new Cities(null, name,code);
        DBManager.addCity(city);
        response.sendRedirect("/CityServlet");
    }
}
