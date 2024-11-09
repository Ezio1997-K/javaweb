package com.learnfruit.myssm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ClassName:ConnUtil
 * Package:com.learnfruit.myssm.util
 * Description:
 */
public class ConnUtil {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=UTC";//allowPublicKeyRetrieval=true&
    private static final String USER = "root";
    private static final String PWD = "abc123";

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    //创建连接对象
    private static Connection createConn() {
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.通过驱动管理器获取连接对象
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //从本地线程获取threadLocal
    public static Connection getConn() {
        Connection conn = threadLocal.get();
        if (conn == null) {
            conn = createConn();
            threadLocal.set(conn);
        }
        return conn;
    }

    //关闭连接对象
    public static void closeConn() throws SQLException {
        Connection conn = threadLocal.get();
        if (conn == null) {
            return;
        }
        if (!conn.isClosed()) {
            conn.close();
            threadLocal.set(null);
        }
    }

}