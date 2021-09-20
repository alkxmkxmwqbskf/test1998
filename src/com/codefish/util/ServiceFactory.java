package com.codefish.util;/**
 * @author codefish
 * @date 9/20/2021
 * @apinote
 */

/**
 * @author: codefish
 * @discription:
 */
public class ServiceFactory {

    private ServiceFactory() {
    }

    //传递zhangSan对象
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}
