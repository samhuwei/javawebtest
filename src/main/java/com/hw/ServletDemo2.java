package com.hw;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/demo2")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取Session对象
/*        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("username"));*/
        // 获取cookie
/*        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            String key = cookie.getName();
            if("username".equals(key)){
                String value = cookie.getValue();
                value = URLDecoder.decode(value, "UTF-8");
                System.out.println(key + ":" + value);
                break;
            }
        }*/
        System.out.println(request.getParameter("name"));
        System.out.println("demo2...");
/*        // 设置编码类型
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write("胡蔚");*/

        // 获取字节文件
/*        FileInputStream fis = new FileInputStream("C:\\Users\\skylineoo\\Pictures\\屏保\\create.jpg");

        ServletOutputStream outputStream = response.getOutputStream();

        IOUtils.copy(fis, outputStream);*/

/*        // request请求转发 获取 上一个资源的数据
        Object name = request.getAttribute("name");
        System.out.println(name);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
