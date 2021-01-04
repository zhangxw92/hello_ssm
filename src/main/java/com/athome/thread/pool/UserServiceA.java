package com.athome.thread.pool;

import org.junit.Test;

import java.util.concurrent.*;

public class UserServiceA {
    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

    /**
     * 线程池提交任务时，使用Callable接口可以有返回值
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test() throws ExecutionException, InterruptedException {
        UserServiceB userServiceB = new UserServiceB();

        Callable<Integer> callable = new Callable() {
            @Override
            public Object call() throws Exception {
                int add = userServiceB.add(1, 2);
                return add;
            }
        };

        Callable<String> callable1 = new Callable() {
            @Override
            public Object call() throws Exception {
                String reslt = userServiceB.hello("张三");
                return reslt;
            }
        };

        Future<Integer> submit = executorService.submit(callable);
        Future<String> submit1 = executorService.submit(callable1);

        System.out.println(submit.get());
        System.out.println(submit1.get());


        Future<Object> future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return userServiceB.hello("亲");
            }
        });

        System.out.println(future.get());


    }

    /**
     * 线程池提交任务时，Runnable不能返回结果
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        UserServiceB userServiceB = new UserServiceB();

        Future<?> submit = executorService.submit(new Runnable() {
            @Override
            public void run() {
                int add = userServiceB.add(1, 2);
            }
        });
        System.out.println(submit.get());

        Future<?> submit2 = executorService.submit(() -> {
            userServiceB.add(2, 2);
        });
        System.out.println(submit2.get());

    }
}
