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
import java.util.List;
import java.util.Map;

/**
 * 登录：根据username、password判断是否存在用户
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + ":" + password);

        // 创建UserService 对象 从数据库获取数据 并保存
        User user = userService.selectUser(username, password);

        // 获取字符输出流 响应请求
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(user != null){
            // 登录成功
            // 判断是否保存密码 保存：将当前数据存放到cookie
            writer.write("登录成功");
            System.out.println(user.getUsername() + "登录成功！");
        }else{
            // 登录失败
            writer.write("登录失败");
            System.out.println("登录失败");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
