package dkz97.service.proxy;

import dkz97.domain.Account;
import dkz97.service.AccountService;
import dkz97.service.impl.AccountServiceImpl;
import dkz97.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用来创建AccountService的代理对象
 */
public class AccountServiceProxy {

    private static AccountServiceImpl accountService;

    private TransactionManager transactionManager;

    public final void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    /**
     * 返回代理对象的方法
     *  三个参数，分别是类加载器， 类的字节码数组，增强的代码
     *  这个获取对象的方法可以通过bean的方法获取对象配置进行配置
     *  代理对象返回的要是接口类型
     * @return
     */
    public AccountService getAccountService() {


        return (AccountService) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object reValue = null;
                        /**
                         * 使用代理对象进行代码的加强，可以在代理对象中进行事务管理
                         */
                        try {
                            // 开始事务
                            transactionManager.beginTransacation();

                            // 开启方法,会返回该方法返回的东西
                            reValue = method.invoke(accountService, args);

                            // 提交事务
                            transactionManager.commit();
                            // 返回结果
                            return reValue;

                        } catch (Exception e) {
                            // 回滚事务
                            transactionManager.rollback();

                            throw new RuntimeException(e);
                        } finally {
                            transactionManager.release();
                        }
                    }
                });


    }


}
