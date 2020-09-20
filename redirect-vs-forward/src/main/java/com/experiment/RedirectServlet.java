package com.experiment;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("RedirectServlet.doGet called");
        resp.sendRedirect(req.getContextPath() + "/redirected");
    }
}
