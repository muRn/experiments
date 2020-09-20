package com.experiment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GreetingServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("GreetingServlet.doGet called");
        resp.setContentType("text/html");
        String uri = req.getRequestURI();

        resp.getWriter().println(uri + " is greeting you, stranger");
    }
}
