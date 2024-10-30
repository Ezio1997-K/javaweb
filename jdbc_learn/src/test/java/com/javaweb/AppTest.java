package com.javaweb;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    public AppTest(String testName) {
        super(testName);
    }


    public void test1() throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取链接
        String url = "jdbc:mysql://localhost:3306/stu?useSSL=false&serverTimezone=UTC";
        ;
        String user = "root";
        String password = "abc123";
        Connection conn = DriverManager.getConnection(url, user, password);
        //定义sql语句
        String sql = "insert into stu_table(id,NAME,age,email) values('1','张三',18,'zhangsan@163.com')";

        //获取执行sql的对象
        Statement stmt = conn.createStatement();
        //执行sql语句
        stmt.execute(sql);
        //关闭资源
        stmt.close();
        conn.close();
    }
}
