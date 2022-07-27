package com.hw.web;

import com.alibaba.fastjson.JSON;
import com.hw.pojo.Brand;
import com.hw.service.BrandService;
import com.hw.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    // 1. 获取 brandService 对象
    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Brand> brandList = brandService.selectAll();

        // 2. 反序列成JSON数据
        String s = JSON.toJSONString(brandList);
        System.out.println("servlet:" + s);
        // 3. 响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void addBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 2.. 获取请求数据
        request.setCharacterEncoding("utf-8");
        BufferedReader reader = request.getReader();
        String jsonString = reader.readLine();
        System.out.println("servlet" + jsonString);
        Brand brand = JSON.parseObject(jsonString, Brand.class);

        // 3..执行添加方法
        int flag = brandService.addBrand(brand);
        System.out.println(flag);

        // 4.响应数据 发送成功/失败信息
        if(flag == 1){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("failed");
        }
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 2. 获取请求数据
        request.setCharacterEncoding("utf-8");
        BufferedReader reader = request.getReader();
        String jsonString = reader.readLine();
        System.out.println("servlet" + jsonString);
        Brand brand = JSON.parseObject(jsonString, Brand.class);

        // 3. 执行添加方法
        int flag = brandService.deleteById(brand.getId());
        System.out.println(flag);

        // 4.响应数据 发送成功/失败信息
        if(flag == 1){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("failed");
        }
    }

    public void updateById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 2. 获取请求数据
        request.setCharacterEncoding("utf-8");
        BufferedReader reader = request.getReader();
        String jsonString = reader.readLine();
        System.out.println("servlet" + jsonString);
        Brand brand = JSON.parseObject(jsonString, Brand.class);

        // 3. 执行添加方法
        int flag = brandService.updateById(brand);
        System.out.println(flag);

        // 4.响应数据 发送成功/失败信息
        if(flag == 1){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("failed");
        }
    }


}
