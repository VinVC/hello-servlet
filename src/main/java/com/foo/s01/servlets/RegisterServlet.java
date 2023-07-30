package com.foo.s01.servlets;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String vCode = request.getParameter("code");
        if (vCode.equalsIgnoreCase((String) request.getSession().getAttribute("vCode"))) {
            // 这里简单、分步的判断和删除不能保证原子性，可以借助redis
            // LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
            // 成功之后将session删除，防止重复提交
            request.getSession().removeAttribute("vCode");
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
            System.out.println(username + ", 恭喜！注册成功！");
            response.getWriter().print(username + ", 恭喜！注册成功！");
        } else {
            response.getWriter().print("验证码错误！");
            System.out.println("验证码错误！");
        }
    }
}