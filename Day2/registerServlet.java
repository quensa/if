package com.kuang.utils.web;

import com.kuang.utils.dao.usermapper;
import com.kuang.utils.mybatisutils;
import org.apache.ibatis.session.SqlSession;
import com.kuang.utils.pojo.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/registerServlet")
public class registerServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收用户名和密码
        String username = req.getParameter("username");
        //可能我的tomcat是插件没有把请求乱码问题解决所以要先把请求解码方式改为utf8
        username=new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String password = req.getParameter("password");

        user user = new user();
        user.setUsername(username);
        user.setPassword(password);

        //2.调用mybatis方法完成查询
        SqlSession sqlSession = mybatisutils.getSqlSession();
        usermapper mapper = sqlSession.getMapper(usermapper.class);
        user u = mapper.select1(username);


        //3.判断user是否为空 然后反应并跳转新界面  因为是输出中文所以首先要设置编码
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(u==null){
            mapper.add(user);
            sqlSession.commit();
            sqlSession.close();
        }else{
            writer.write("已有账户");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
