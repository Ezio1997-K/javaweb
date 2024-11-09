package com.learnfruit.myssm.listeners;

import com.learnfruit.myssm.ioc.BeanFactory;
import com.learnfruit.myssm.ioc.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ClassName:ContextLoaderListener
 * Package:com.learnfruit.myssm.listeners
 * Description:
 *
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //获取servlet上下文对象
        ServletContext application = sce.getServletContext();
        //获取上下文的初始化参数
        String path = application.getInitParameter("ContextConfigLocation");
        application.log("IOC容器创建成功");
        //创建ioc容器
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(path);
        //将ioc容器保存到application作用域中
        application.setAttribute("beanFactory",beanFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
