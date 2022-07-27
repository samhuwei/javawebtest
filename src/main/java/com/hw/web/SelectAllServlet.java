package com.hw.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hw.pojo.User;
import com.hw.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/selectall")
public class SelectAllServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求体数据  请求体数据只有一行
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        // 把JSON 数据转为 对象
        User user = JSON.parseObject(s, User.class);
        System.out.println(user);


        User[] users = userService.selectAll();
        //把对象数组 变成JSON 反序列化
        String json = JSON.toJSONString(users);
        System.out.println(json);
        //响应数据 完成这一步之后可以运行网页查看数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
