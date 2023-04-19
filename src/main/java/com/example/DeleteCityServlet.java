package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tools.Cities;
import tools.DBManager;
import tools.Students;

import java.io.IOException;

@WebServlet(name = "DeleteCityServlet", value = "/DeleteCityServlet")
public class DeleteCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Cities cities = DBManager.getCity(id);

        if(cities != null){
            DBManager.DeleteCity(id);
        }
        else {
            response.sendRedirect("/CityServlet?error");
        }

        response.sendRedirect("/CityServlet");

    }
}
