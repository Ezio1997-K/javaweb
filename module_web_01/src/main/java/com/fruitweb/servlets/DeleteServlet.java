package com.fruitweb.servlets;

import com.fruitweb.mapper.FruitMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName:DeleteServlet
 * Package:com.fruitweb.servlets
 * Description:
 *
 */
@WebServlet("/del.do")
public class DeleteServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        int fid = Integer.parseInt(fidStr);
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSession = sqlSessionFactory.openSession();
            FruitMapper mapper = sqlSession.getMapper(FruitMapper.class);
            mapper.delFruitById(fid);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(sqlSession!=null){
                sqlSession.rollback();
            }
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
            if(resourceAsStream!=null){
                resourceAsStream.close();
            }
        }
        resp.sendRedirect("index");
    }
}
