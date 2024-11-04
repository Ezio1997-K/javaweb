package com.fruitweb.servlets;

import com.fruitweb.mapper.FruitMapper;
import com.fruitweb.pojo.Fruit;
import com.fruitweb.util.StringUtil;
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
 * ClassName:UpdateServlet
 * Package:com.fruitweb.servlets
 * Description:
 */
@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String fidStr = req.getParameter("fid");
        Integer fid = Integer.parseInt(fidStr);
        String fname = req.getParameter("fname");
        String priceStr = req.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = req.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = req.getParameter("remark");
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        if (StringUtil.isNotEmpty(fidStr)) {
            try {
                resourceAsStream = Resources.getResourceAsStream(resource);
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
                sqlSession = sqlSessionFactory.openSession();
                FruitMapper mapper = sqlSession.getMapper(FruitMapper.class);
                mapper.updateFruit(new Fruit(fid, fname, price, fcount, remark));
                sqlSession.commit();
                /*super.processTemplate("edit", req, resp);*/
                resp.sendRedirect("index");
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
        }
    }
}
