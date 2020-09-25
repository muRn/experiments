package com.experiment;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(
        urlPatterns = {"/redirect/*"}
)
public class RedirectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("RedirectServlet.doGet called");
        Map<String, String[]> parameterMap = req.getParameterMap();
        String parameters = parameterMap.entrySet().stream().map(x -> x.getKey() + "=" + x.getValue()[0]).collect(Collectors.joining("&"));
        resp.sendRedirect(req.getContextPath() + "/redirected" + (parameters.isEmpty() ? "" : "?" + parameters));
    }
}
