package com.learnfruit.myssm.trans;

import com.learnfruit.myssm.util.ConnUtil;

import java.sql.SQLException;

/**
 * ClassName:TransactionManager
 * Package:com.learnfruit.myssm.trans
 * Description:
 *
 */
public class TransactionManager {
    //开启事务
    public static void beginTrans() throws SQLException {
        ConnUtil.getConn().setAutoCommit(false);
    }
    //提交事务
    public static void commitTrans() throws SQLException {
        ConnUtil.getConn().commit();
    }
    //回滚事务
    public static  void rollbackTrans() throws SQLException {
        ConnUtil.getConn().rollback();
    }
}
