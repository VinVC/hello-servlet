package com.foo.s01.servlets;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foo.s01.ImageVerificationCode;

@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ImageVerificationCode vc = new ImageVerificationCode();
        BufferedImage image = vc.getImage();
        request.getSession().setAttribute("vCode", vc.getText());
        ImageVerificationCode.output(image, response.getOutputStream());
    }
}