package cn.zgf;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author bgm14
 */
public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {

        System.out.println("执行了call方法");
        return "callable";
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<Future<String>> results = new ArrayList<Future<String>>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new Task()));
        }
        for (Future<String> future : results) {
            System.out.println(future.get());
        }

        System.out.println("Main complete");

        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
    }






}
