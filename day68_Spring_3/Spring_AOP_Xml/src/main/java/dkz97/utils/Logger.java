package dkz97.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具
 */
public class Logger {

    /**
     * 打印日志，其实就是输入一条语句，然后测试
     */
    public void printLog() {
        System.out.println("日志打印成功！！");
    }

    /**
     * 配置环绕通知,使用自带接口ProceedingJoinPoint
     */
    public void aroundPrintLog(ProceedingJoinPoint pjp){
        try {
            System.out.println("这是一个环绕通知 开始的前置");

            // 这个proceed方法，相当于调用了方法
            pjp.proceed();

            System.out.println("这是一个环绕后置通知");

        }catch (Throwable t) {

            System.out.println("这是一个环绕错误通知");
        }finally {
            System.out.println("这是一个最终通知");

        }
    }
}
