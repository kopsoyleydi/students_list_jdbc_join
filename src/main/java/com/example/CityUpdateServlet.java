package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import tools.Cities;
import tools.DBManager;
import tools.Students;

import java.io.IOException;

@WebServlet(name = "CityUpdateServlet", value = "/CityUpdateServlet")
public class CityUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String code = request.getParameter("code");

        Cities city = DBManager.getCity(id);

        if(city != null){
            city.setName(name);
            city.setCode(code);
            DBManager.UpdateCity(city);
            response.sendRedirect("/CityServlet");
        }
        else{
            response.sendRedirect("/error.jsp");
        }
    }
}
