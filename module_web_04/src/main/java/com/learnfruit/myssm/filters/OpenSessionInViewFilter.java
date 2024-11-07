package com.learnfruit.myssm.filters;

import com.learnfruit.myssm.trans.TransactionManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.SQLException;

/**
 * ClassName:OpenSessionInViewFilter
 * Package:com.learnfruit.myssm.filters
 * Description:
 *
 */
@WebFilter("*.do")
public class OpenSessionInViewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            TransactionManager.beginTrans();
            System.out.println("开启事务...");
            chain.doFilter(request,response);
            TransactionManager.commitTrans();
            System.out.println("提交事务...");
        }catch (Exception e){
            e.printStackTrace();
            try {
                TransactionManager.rollbackTrans();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
