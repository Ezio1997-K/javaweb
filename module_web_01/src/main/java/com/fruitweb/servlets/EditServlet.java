package com.fruitweb.servlets;

import com.fruitweb.mapper.FruitMapper;
import com.fruitweb.pojo.Fruit;
import com.fruitweb.util.StringUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName:EditServlet
 * Package:com.fruitweb.servlets
 * Description:
 */
@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        if (StringUtil.isNotEmpty(fidStr)) {
            Integer fid = Integer.parseInt(fidStr);
            String resource = "mybatis-config.xml";
            InputStream resourceAsStream = null;
            SqlSession sqlSession = null;
            Fruit fruit = null;
            try {
                resourceAsStream = Resources.getResourceAsStream(resource);
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
                sqlSession = sqlSessionFactory.openSession();
                FruitMapper mapper = sqlSession.getMapper(FruitMapper.class);
                fruit = mapper.getFruitByFid(fid);
                /*super.processTemplate("edit", req, resp);*/
                //resp.sendRedirect("index");
            } catch (Exception e) {
                e.printStackTrace();
                if (sqlSession != null) {
                    sqlSession.rollback();
                }
            } finally {
                if (sqlSession != null) {
                    sqlSession.close();
                }
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
            }
            req.setAttribute("fruit",fruit);
            super.processTemplate("edit",req,resp);
        }
    }
}
