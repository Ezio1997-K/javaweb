package com.javaweb;

import com.learnmba.mapper.BrandMapper;
import com.learnmba.mapper.UserMapper;
import com.learnmba.pojo.Brand;
import com.learnmba.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassName:Test
 * Package:com.javaweb
 * Description:
 *
 */
public class AppTest {
    @Test
    public void testMybatis() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.selectUser");
        System.out.println(users);
        sqlSession.close();
    }
    
    @Test
    public void testMybatis2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //List<User> users = sqlSession.selectList("test.selectUser");
        //获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectUser();
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testBrand1() throws IOException {
        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取BrandMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行查询所有方法
        List<Brand> brands = brandMapper.selectAll();
        brands.forEach(System.out::println);
        /* 5.释放资源 */
        sqlSession.close();
    }

    @Test
    public void testYingyong(){
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "aaa", "bbb", "ccc");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    public void testClass(){
        ClassLoader classLoader = AppTest.class.getClassLoader();
        while (classLoader!= null) {
            if (classLoader instanceof URLClassLoader) {
                URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
                System.out.println("ClassLoader: " + classLoader.getClass().getName());
                System.out.println("Class Path Entries:");
                Arrays.stream(urlClassLoader.getURLs()).forEach(url -> System.out.println(url.getFile()));
            }
            classLoader = classLoader.getParent();
        }
    }

    @Test
    public void testSelectById() throws IOException {
        int id = 1;
        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectByIdBrand(id);
        System.out.println(brand);
    }
}
