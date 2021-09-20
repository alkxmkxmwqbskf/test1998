package com.codefish.util;/**
 * @author codefish
 * @date 9/20/2021
 * @apinote
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: codefish
 * @discription:
 */
public class SqlSessionUtil {

    //工具类静态方法的构造方法私有化: 防止有傻逼不按照规范, 通过创建对象来调用方法.
    private SqlSessionUtil() {
    }

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //???
    private static ThreadLocal<SqlSession> sessionThreadLocal = new ThreadLocal<>();

    public static SqlSession getSqlSession(){
        SqlSession session = sessionThreadLocal.get();
        if (session == null){
            session = sqlSessionFactory.openSession();
            sessionThreadLocal.set(session);
        }
        return session;
    }

    public static void sessionClose(SqlSession session){
        if (session != null){
            session.close();
            //清除线程池
            sessionThreadLocal.remove();
        }
    }
}
