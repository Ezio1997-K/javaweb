package com.fruitweb.servlets;

import com.fruitweb.mapper.FruitMapper;
import com.fruitweb.pojo.Fruit;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName:AddServlet
 * Package:com.fruitweb.servlets
 * Description:
 *
 */
public class AddServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String fname = req.getParameter("fname");
        String priceStr = req.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = req.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = req.getParameter("remark");
        Fruit fruit = new Fruit(null, fname, price, fcount, remark);
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSession = sqlSessionFactory.openSession();
            FruitMapper mapper = sqlSession.getMapper(FruitMapper.class);
            boolean b = mapper.addFruit(fruit);
            sqlSession.commit();
            System.out.println(b? "添加成功" : "添加失败");
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession!= null) {
                sqlSession.rollback();
            }
        } finally {
            if (sqlSession!= null) {
                sqlSession.close();
            }
            if (resourceAsStream!= null) {
                resourceAsStream.close();
            }
        }
    }
}
