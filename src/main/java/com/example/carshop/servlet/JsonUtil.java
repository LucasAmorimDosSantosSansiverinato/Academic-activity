package com.example.carshop.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class JsonUtil {


    public static void sendJsonResponse(HttpServletResponse response, int statusCode, Object data) throws IOException {

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(statusCode);

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        String jsonString = gson.toJson(data);

        PrintWriter out = response.getWriter();
        out.print(jsonString);
        out.flush();
    }
}