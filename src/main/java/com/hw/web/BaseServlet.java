package com.hw.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取当前访问路径 /brand/xxx
        String URI = req.getRequestURI();
        // 2. 获取最后一个 '/' 的索引
        int index = URI.lastIndexOf('/');
        // 3. 截断字符串 如果不加+1 会包括 '/'
        String methodName = URI.substring(index + 1);
        // 4. 利用 反射 获取当前调用该方法的 字节码对象 class
        Class<? extends BaseServlet> aClass = this.getClass();
        // 5. 由类对象获取方法对象
        try {
            Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 6. 由方法对象 执行该方法
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
