package com.hw.web;

import com.hw.mapper.UserMapper;
import com.hw.pojo.User;
import com.hw.service.UserService;
import com.hw.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * 注册：根据username判断用户是否存在，再创建用户
 *
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");

        // 获取字符输出流 响应请求
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(username != null || password != null) {
            // 返回数据
            User user = userService.selectByUsername(username);
            writer.write("请输入正确的账号密码！");

            // 校验验证码
            HttpSession session = request.getSession();
            String attribute = (String) session.getAttribute("checkcode");
            System.out.println(attribute);

            if (user != null) {
                // 注册失败
                writer.write("已有该账号，注册失败");

            } else {

                if (!attribute.equalsIgnoreCase(checkcode)) {
                    writer.write("验证码错误！");
                    return;
                }
                // 开始注册
                int i = userService.add(username, password);
                if (i == 1) {
                    System.out.println("注册成功");
                    response.sendRedirect("/html/login.html");
                } else {
                    System.out.println("注册失败");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
