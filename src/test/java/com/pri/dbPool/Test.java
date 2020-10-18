package com.pri.dbPool;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * className: Test <BR>
 * description: <BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2020/10/18 15:29 <BR>
 * version 1.0 jdk1.8 <BR>
 */
public class Test {
    public static void main(String[] args) {
        DbBean dbBean = new DbBean();
        final ConnectionPool connectionPool = new ConnectionPool(dbBean);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<20;i++) {
            executorService.execute(new Runnable() {
                public void run() {

                    Connection connection = connectionPool.getConnection();
                    //System.out.println(Thread.currentThread().getName()+"获取连接："+connection);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    connectionPool.releaseConnection(connection);
                    //System.out.println(Thread.currentThread().getName()+"释放连接："+connection);
                }
            });
        }

        // 关闭线程池 ChenQi;
        executorService.shutdown();
        try {
            // awaitTermination返回false即超时会继续循环，
            // 返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔2秒循环一次
            while (!executorService.awaitTermination(2, TimeUnit.SECONDS));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束...");

    }
}
