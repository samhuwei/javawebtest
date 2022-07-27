package com.hw;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/demo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        HttpSession session = request.getSession();
        session.setAttribute("username","胡蔚");*/

        // cookie 发送
/*        String username = URLEncoder.encode("胡蔚","UTF-8");
        System.out.println("username : " + username);
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(60*60*24);

        response.addCookie(cookie);*/

/*        // 存放数据 request 请求转发
        request.setAttribute("name","胡蔚");
        // 获取请求调度员来forward
        request.getRequestDispatcher("/demo2").forward(request, response);*/
        request.setAttribute("name", "胡蔚");
        request.getRequestDispatcher("/demo02").forward(request, response);

        // response重定向
/*        response.setStatus(302);
        response.setHeader("location", "/demo2");*/
        // 简化方法设置response重定向
//        response.sendRedirect("/demo2");

        System.out.println("demo1...");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
