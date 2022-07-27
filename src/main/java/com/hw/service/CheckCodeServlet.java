package com.hw.service;

import com.hw.util.CheckCodeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/checkcode")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取验证码图片输出流
        ServletOutputStream outputStream = response.getOutputStream();
        String checkcode = CheckCodeUtil.outputVerifyImage(100, 50, outputStream, 4);

        // 把验证码存放到Session中
        HttpSession session = request.getSession();
        session.setAttribute("checkcode", checkcode);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
