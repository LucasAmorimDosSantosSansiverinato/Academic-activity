package com.example.carshop.servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carName = request.getParameter("car-name");

        response.setStatus(HttpServletResponse.SC_CREATED);
        response.setContentType("application/json;charset=UTF-8");


        Map<String, String> successResponse = new HashMap<>();
        successResponse.put("status", "success");
        successResponse.put("200", "Carro '" + carName + "' criado com sucesso!");


        String jsonResponse = new Gson().toJson(successResponse);


        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
}
