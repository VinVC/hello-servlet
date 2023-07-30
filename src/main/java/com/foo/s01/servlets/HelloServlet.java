package com.foo.s01.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// WebServlet注解表示这是一个Servlet，并映射到地址/:
@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 获取请求的数据
        String message = req.getParameter("xx");
        // 封装响应数据
        res.setContentType("text/html");

        // Hello
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h1> hello " + message + "</h1>");
        out.println("</body></html>");
    }
}