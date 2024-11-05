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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * ClassName:SelectServlet
 * Package:com.fruitweb.servlets
 * Description:
 */
@WebServlet("/index")
public class SelectServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int pageNum = 1;

        String pageNumStr = req.getParameter("pageNum");
        if (StringUtil.isNotEmpty(pageNumStr)) {
            pageNum = Integer.parseInt(pageNumStr);
        }
        HttpSession session = req.getSession();
        session.setAttribute("pageNum", pageNum);
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
        FruitMapper mapper = sqlSession.getMapper(FruitMapper.class);
        List<Fruit> fruitList = mapper.getFruitListByPageNum(pageNum);
        int fruitCount = mapper.getFruitCount();
        sqlSession.close();
        resourceAsStream.close();
        session.setAttribute("fruitList", fruitList);
        //int pageCount = (fruitCount + 5 - 1) / 5;
        int pageCount = (int) Math.ceil(fruitCount / 5);
        session.setAttribute("pageCount", pageCount);
        //此处的视图名称是 index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称 ：   index
        //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
        //所以真实的视图名称是：      /       index       .html
        super.processTemplate("index", req, resp);
    }
}

