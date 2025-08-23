package com.example.carshop.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CreateCarServlet", value = "/create-car")
public class CreateCarServlet extends HttpServlet {


    private static class JsonResponse {
        private final String status;
        private final String message;
        private final Map<String, String> data;

        public JsonResponse(String status, String message, Map<String, String> data) {
            this.status = status;
            this.message = message;
            this.data = data;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String carName = request.getParameter("car-name");


        Map<String, String> carData = new HashMap<>();
        carData.put("name", carName);


        JsonResponse responseObject = new JsonResponse("success", "Carro '" + carName + "' criado com sucesso! ", carData);


        JsonUtil.sendJsonResponse(response, HttpServletResponse.SC_CREATED, responseObject);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JsonResponse responseObject = new JsonResponse(
                "info",
                "Este endpoint aceita requisições POST para criar um carro.",
                Collections.emptyMap()
        );

        JsonUtil.sendJsonResponse(response, HttpServletResponse.SC_OK, responseObject);
    }
}