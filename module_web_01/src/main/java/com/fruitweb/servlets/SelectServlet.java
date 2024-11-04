package com.fruitweb.servlets;

import com.fruitweb.mapper.FruitMapper;
import com.fruitweb.pojo.Fruit;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * ClassName:SelectServlet
 * Package:com.fruitweb.servlets
 * Description:
 */
@WebServlet("/selectAll")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
        FruitMapper mapper = sqlSession.getMapper(FruitMapper.class);
        List<Fruit> fruitList = mapper.getFruitList();
        sqlSession.close();
        resourceAsStream.close();
        session.setAttribute("fruitList", fruitList);
    }
}

