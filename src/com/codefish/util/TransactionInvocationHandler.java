package com.codefish.util;/**
 * @author codefish
 * @date 9/20/2021
 * @apinote
 */

import org.apache.ibatis.session.SqlSession;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: codefish
 * @discription: 动态代理模式  一百个张三共用一个李四
 * 其他动态代理方式: cglib
 * 单一职责原则 每一层只干自己相关业务
 * Spring AOP(面向切面编程) 底层原理
 */
public class TransactionInvocationHandler implements InvocationHandler {

    //object: zhangSan的表白方法
    private Object target;

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }

    //代理类业务方法
    //liSi的表白方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        SqlSession session = null;
        Object obj = null;

        try {
            session = SqlSessionUtil.getSqlSession();
            //处理业务逻辑
            obj = method.invoke(target, args);
            //处理业务逻辑后, 提交事务
            session.commit();
        } catch (Exception e) {
            //事务回滚
            session.rollback();
            e.printStackTrace();
        }finally {
            //关闭链接
            SqlSessionUtil.sessionClose(session);
        }
        return obj;
    }

    //获取liSi代理对象
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
